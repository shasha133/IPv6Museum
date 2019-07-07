package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gyl on 2018/1/24.
 */

public class ShoppingSQLHelper extends SQLiteOpenHelper {

    private static final String dbname="SHOP.db";
    private static final int version=1;
    private static  ShoppingSQLHelper dbHelper;

    private final String createTb="CREATE TABLE Shopping(gooodsid VARCHAR2)";

    public ShoppingSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ShoppingSQLHelper(Context context){
        super(context, dbname, null, version);
    }

    public static ShoppingSQLHelper getInstance(Context context) {

        if (dbHelper == null) { //单例模式
            dbHelper = new ShoppingSQLHelper(context);
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建一个数据库表 User ，字段：_id、name、avatar。
        db.execSQL(createTb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}


