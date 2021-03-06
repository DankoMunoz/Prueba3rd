package com.example.prueba3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper {
    public static String Nombre_BD= "Votaciones.db";
    public static int Version_DB=1;
    public static String Tabla_Voto="create table voto (id_voto integer primary key autoincrement, voto_blanco integer, voto_nulo integer,voto_boric integer, voto_kast integer)";

    public DBhelper(Context context) {
        super(context, Nombre_BD,  null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_Voto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists voto");
        sqLiteDatabase.execSQL(Tabla_Voto);
    }
}
