package com.example.test;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Method;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Configuration config = this.getResources().getConfiguration();
            String s = String.valueOf(config.fontScale);
            Log.i("sanbo", "------->" + s);

            Configuration mCurConfig = null;
            Class<?> activityManagerNative = getActivityManagerNative();
            Object obj = activityManagerNative.getMethod("getDefault").invoke(activityManagerNative);
            Method method = obj.getClass().getMethod("getConfiguration");
            mCurConfig = (Configuration) method.invoke(obj);
            s = String.valueOf(mCurConfig.fontScale);
            Log.i("sanbo", "2222------->" + s);

        } catch (Throwable e) {
        }
    }

    private Class<?> getActivityManagerNative() throws ClassNotFoundException {
        return Class.forName("android.app.ActivityManagerNative");
    }
}
