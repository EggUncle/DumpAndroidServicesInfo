package com.egguncle.dumpandroidservicesinfo.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.egguncle.dumpandroidservicesinfo.R;
import com.egguncle.dumpandroidservicesinfo.model.ResultData;
import com.egguncle.dumpandroidservicesinfo.model.ServiceClassInfo;
import com.egguncle.dumpandroidservicesinfo.model.ServiceInfo;
import com.egguncle.dumpandroidservicesinfo.utils.CommandUtil;
import com.egguncle.dumpandroidservicesinfo.utils.FileUtil;
import com.egguncle.dumpandroidservicesinfo.utils.JsonUtil;
import com.egguncle.dumpandroidservicesinfo.utils.ServiceInfoParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //申请读取SD卡权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    ) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
            }
        }


        Log.i(TAG, "ServiceInfo: ====================================================");
        String result = CommandUtil.exec("service list");
        //Log.i(TAG, "onCreate: \n"+result);
        String[] strList = result.split("\n");
        ServiceInfoParser serviceInfoParser = new ServiceInfoParser();
        for (int i = 1; i < strList.length; i++) {
            //Log.i(TAG, "onCreate: " + strList[i]);
            String line = strList[i];
            ServiceInfo info = new ServiceInfo();
            info.num = Integer.valueOf((line.split("\t"))[0]);
            String tmp = (line.split("\t"))[1];
            info.serviceName = tmp.substring(0, tmp.indexOf(":"));
            info.className = line.substring(line.indexOf("[") + 1, line.lastIndexOf("]"));
            //Log.i(TAG, "onCreate: " + info.num + "|" + info.serviceName + "|" + info.className);

            serviceInfoParser.parser(info);
        }
        List<ServiceClassInfo> serviceClassInfoList = serviceInfoParser.getServiceClassInfoList();
        for (ServiceClassInfo info : serviceClassInfoList) {
            String serviceName = info.serviceName;
            Log.i(TAG, "onCreate: -----------------------------------");
            Log.i(TAG, "onCreate: " + serviceName);
            Log.i(TAG, "onCreate: " + info.serviceClassName);
            List<ServiceClassInfo.ServiceMethod> serviceMethodList = info.methodList;
            for (ServiceClassInfo.ServiceMethod serviceMethod : serviceMethodList) {
                String typesStr = "";
                for (String c : serviceMethod.paramTypeList) {
                    typesStr = typesStr + c + " ";
                }
                Log.i(TAG, "onCreate: " + serviceMethod.code + " " + serviceMethod.methodName + "|" + typesStr);
            }
        }
        ResultData resultData = new ResultData();
        resultData.android = Build.VERSION.RELEASE;
        resultData.infos = serviceClassInfoList;
        FileUtil.writeFile(JsonUtil.genJsonStr(resultData), Environment.getExternalStorageDirectory().getPath() + "/service_info.json");
    }
}
