package com.virjar.ratel.api.extension.superappium.sekiro;

import android.util.Log;

import com.virjar.ratel.api.extension.superappium.PageTriggerManager;
import com.virjar.ratel.api.extension.superappium.SuperAppium;
import com.virjar.sekiro.api.SekiroClient;

import java.util.UUID;

public class SekiroStarter {
    public static String sekiroGroup = "ratel-appium";
    private static final String dumpTopActivity = "dumpActivity";
    private static final String dumpTopFragment = "dumpFragment";
    private static final String screenShot = "screenShot";
    private static final String executeJsOnWebView = "ExecuteJsOnWebView";

    private static boolean isStarted = false;

    public static void startService(String host, int port, String token) {
        if (isStarted) {
            return;
        }
        Log.i(SuperAppium.TAG, "start a supperAppium client: " + token);
        PageTriggerManager.getTopFragment("insureComponentStarted");
        SekiroClient.start(host, port, token, sekiroGroup)
                .registerHandler(dumpTopActivity, new DumpTopActivityHandler())
                .registerHandler(dumpTopFragment, new DumpTopFragmentHandler())
                .registerHandler(screenShot, new ScreenShotHandler())
                .registerHandler(executeJsOnWebView, new ExecuteJsOnWebViewHandler())
        ;

        isStarted = true;
    }

    public static void startService(String host, int port) {
        startService(host, port, UUID.randomUUID().toString());
    }
}
