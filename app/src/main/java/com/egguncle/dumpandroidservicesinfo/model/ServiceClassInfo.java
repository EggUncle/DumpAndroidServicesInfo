package com.egguncle.dumpandroidservicesinfo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egguncle on 18-6-26.
 */

public class ServiceClassInfo {

    public String serviceName;

    public String serviceClassName;

    public List<ServiceMethod> methodList = new ArrayList<>();

    public class ServiceMethod {
        public String methodName;
        public int code;
        public List<String> paramTypeList = new ArrayList<>();
    }

}
