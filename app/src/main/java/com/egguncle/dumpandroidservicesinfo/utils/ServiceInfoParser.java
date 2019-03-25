package com.egguncle.dumpandroidservicesinfo.utils;

import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.egguncle.dumpandroidservicesinfo.model.ServiceClassInfo;
import com.egguncle.dumpandroidservicesinfo.model.ServiceInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by egguncle on 18-6-26.
 */

public class ServiceInfoParser {

    private final static String TAG = ServiceInfoParser.class.getSimpleName();

    private List<ServiceClassInfo> serviceClassInfoList;

    public ServiceInfoParser() {
        serviceClassInfoList = new ArrayList<>();
    }

    public List<ServiceClassInfo> getServiceClassInfoList() {
        return serviceClassInfoList;
    }

    public void parser(ServiceInfo info) {
        if ("".equals(info.className)) {
            return;
        }

        String stubClassName;
        String clazzName = info.className;
        //IActivityManager haven't stub class
        if (info.serviceName.equals("activity")) {
            stubClassName = info.className + "$Stub";
        } else {
            stubClassName = info.className + "$Stub";
        }

        try {
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager")
                    .getMethod("getService", String.class).invoke(null, info.serviceName);
            if (iBinder == null) {
                Log.i(TAG, "parser: can't found " + info.serviceName);
                return;
            }


            Class stubClass = Class.forName(stubClassName);
            Class serviceClass = Class.forName(clazzName);
            Log.i(TAG, "parser: found stub class " + stubClassName);

            Field[] stubFields = stubClass.getDeclaredFields();
            Method[] serviceMethods = serviceClass.getDeclaredMethods();
            if (stubFields.length == 0) {
                Log.i(TAG, "parser: field length is 0");
                return;
            }
//            Log.i(TAG, "parser: ===================================");
//            Log.i(TAG, "parser: class-------------------------");
            Log.i(TAG, "parser: class " + stubClassName);
//            Log.i(TAG, "parser: field-------------------------");
            Map<String, Integer> methodCodeMap = new HashMap<>();
            for (Field field : stubFields) {
                field.setAccessible(true);
                if (!field.getName().contains("TRANSACTION")) {
                    continue;
                }
                String methodName;
                if (field.getName().replace("TRANSACTION_", "").contains("_")) {
//                    Log.i(TAG, "parser: field " + info.className + " " + field.getName());
                    methodName = getMethodNameFromTransactCodeName(field.getName());
//                    Log.i(TAG, "parser: field " + info.className + " " + getMethodNameFromTransactCodeName(field.getName()));
//                    Log.i(TAG, "parser: field " + info.className + " " + field.getInt(null));
                } else {
                    methodName = field.getName().replace("TRANSACTION_", "");
                }

                if (field.getType() != null && field.getType().getName() != null && field.getType().getName().equals("int")) {
                    methodCodeMap.put(methodName, field.getInt(null));
                }
            }
            ServiceClassInfo serviceClassInfo = new ServiceClassInfo();
            serviceClassInfo.serviceName = info.serviceName;
            serviceClassInfo.serviceClassName = info.className;
            for (Method method : serviceMethods) {
                if (methodCodeMap.get(method.getName()) == null && methodCodeMap.get(method.getName()) == 0) {
                    continue;
                }
                ServiceClassInfo.ServiceMethod serviceMethod = serviceClassInfo.new ServiceMethod();
                serviceMethod.methodName = method.getName();
                serviceMethod.code = methodCodeMap.get(method.getName());
                method.setAccessible(true);
                Class[] parameters = method.getParameterTypes();
                for (Class c:parameters){
                  //  serviceMethod.paramTypeList.add(c.getSimpleName());
                    serviceMethod.paramTypeList.add(c.getCanonicalName());
                }
                serviceClassInfo.methodList.add(serviceMethod);
            }
            serviceClassInfoList.add(serviceClassInfo);
        } catch (ClassNotFoundException e) {
            Log.i(TAG, "parser error : can't found stub " + stubClassName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIInterface(Class clazz) {
        for (Class c : clazz.getInterfaces()) {
            if (c.getSimpleName().equals("IInterface")) {
                return true;
            }
        }
        return false;
    }

    private String getMethodNameFromTransactCodeName(String name) {
        name = name.replace("TRANSACTION_", "");
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(name.charAt(name.length() - 1) + "");
        //solve name end withi _number
        if (isNum.matches()) {
            name = name.substring(0, name.lastIndexOf("_"));
        }
        return name;
    }
}
