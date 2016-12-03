package example.com.mvpnews.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import example.com.mvpnews.DaoMaster;
import example.com.mvpnews.DaoSession;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public class BaseApplication extends Application{
    private static DaoMaster.DevOpenHelper openHelper;
    private static SQLiteDatabase db;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession ;
    private static Context context;
    private static Date date;
    private static SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public void onCreate(){
        context = getApplicationContext();
        openHelper= new DaoMaster.DevOpenHelper(this,"NEWS",null);
        db = openHelper.getWritableDatabase();
        daoMaster  = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        date = new Date();
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
    public static Context getContext(){
        return context;
    }
    public static String getDate(){
        return mDateFormat.format(date);
    }
}
