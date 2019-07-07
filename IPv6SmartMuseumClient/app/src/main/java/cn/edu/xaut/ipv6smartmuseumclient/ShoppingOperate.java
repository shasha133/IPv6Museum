package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyl on 2018/1/24.
 */

public class ShoppingOperate {
    private ShoppingSQLHelper dbhelper;
    private Context context;

    //要操作数据库操作实例首先得得到数据库操作实例
    public ShoppingOperate(Context context) {
        this.context=context;
        this.dbhelper = ShoppingSQLHelper.getInstance(context);
    }

    public void save(String id){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Cursor cur=db.query("Shopping",new String[]{"gooodsid"},"gooodsid=?",new String[]{id},null,null,null);
        int i = 0;
        while(cur.moveToNext()) {
            i++;
        }
        if(i == 0) {
            cv.put("gooodsid", id);
            Long t = db.insert("Shopping", null, cv);
            Log.d("插入成功：", "" + t);
        }
        db.close();
    }
    public void delete(String id){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.delete("Shopping ","gooodsid=?",new String[]{id});
        db.close();
    }
    public List<String> read(){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor cur=db.query("Shopping", new String[]{"gooodsid"}, null, null, null, null, null);
        List<String> CarList = new ArrayList<>();
        while(cur.moveToNext()){
            String historyClass = cur.getString(cur.getColumnIndex("gooodsid"));
            CarList.add(historyClass);
        }
        db.close();
        return CarList;
    }

}
