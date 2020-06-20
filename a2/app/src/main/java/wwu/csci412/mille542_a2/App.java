package wwu.csci412.mille542_a2;

import android.app.Application;
import android.content.Context;

// Created this class so that the FilmContent class can access the string array
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
