package com.example.crud_fitur2.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "fitur2";

    public Helper(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       final String SQL_CREATE_TABLE = "create table fitur2 (id integer primary key autoincrement,nisn text not null, name not null, jenis_kelamin not null, tempat_lahir not null, tanggal_lahir not null, agama not null, asal_sekolah not null)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists fitur2");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        String QUERY = "select * from fitur2";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("nisn",cursor.getString(1));
                map.put("name",cursor.getString(2));
                map.put("jenis_kelamin", cursor.getString(3));
                map.put("tempat_lahir",cursor.getString(4));
                map.put("tanggal_lahir",cursor.getString(5));
                map.put("agama",cursor.getString(6));
                map.put("asal_sekolah",cursor.getString(7));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String nisn, String name, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String agama, String asal_sekolah){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY =  "insert into fitur2 (nisn,name,jenis_kelamin,tempat_lahir,tanggal_lahir, agama,asal_sekolah) values('"+nisn+"','"+name+"','"+jenis_kelamin+"', '"+tempat_lahir+"','"+tanggal_lahir+"','"+agama+"', '"+asal_sekolah+"');";
        database.execSQL(QUERY);
    }

    public void update(int id, String nisn, String name, String jenis_kelamin, String tempat_lahir, String tanggal_lahir, String agama, String asal_sekolah){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "update fitur2 set nisn = '"+nisn+"', name = '"+name+"', jenis_kelamin = '"+jenis_kelamin+"', tempat_lahir = '"+tempat_lahir+"',tanggal_lahir = '"+tanggal_lahir+"', agama = '"+agama+"', asal_sekolah = '"+asal_sekolah+"' where id =" +id;
        database.execSQL(QUERY);
    }

    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "delete from fitur2 where id="+id;
        database.execSQL(QUERY);
    }
}
