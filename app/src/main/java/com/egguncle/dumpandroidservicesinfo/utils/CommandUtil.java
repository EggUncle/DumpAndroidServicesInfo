package com.egguncle.dumpandroidservicesinfo.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by egguncle on 18-6-26.
 */

public class CommandUtil {

    private final static String TAG = CommandUtil.class.getSimpleName();

    public static String exec(final String command) {
        String result = null;
        Future future = CommandThreadPool.getInstance().submit(new Callable() {
            @Override
            public Object call() throws Exception {
                StringBuffer r = new StringBuffer();
                try {
                    Process process = Runtime.getRuntime().exec(command);
                    InputStream inputStream = process.getInputStream();
                    BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
                    String line = read.readLine();
                    while (line != null) {
                        r.append(line + "\n");
                        line = read.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new String(r);
            }
        });
        try {
            result = (String) future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static class CommandThreadPool extends ThreadPoolExecutor {

        private static CommandThreadPool instance = new CommandThreadPool(5);

        private CommandThreadPool(int corePoolSize) {
            super(corePoolSize, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        }

        public static CommandThreadPool getInstance() {
            return instance;
        }

    }

}
