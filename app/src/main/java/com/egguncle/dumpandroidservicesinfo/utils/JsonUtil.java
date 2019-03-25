package com.egguncle.dumpandroidservicesinfo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by egguncle on 18-7-2.
 */

public class JsonUtil {

    public static String genJsonStr(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(object);
    }

}
