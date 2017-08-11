package ir.msit87.amirdev_json.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by MSIT on 8/10/2017.
 */

public class App extends Application {

    private static App appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public static Context getContext(){
        return appInstance.getApplicationContext();
    }
}
