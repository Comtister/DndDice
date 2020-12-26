package com.example.dnddice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DiceDatabase extends SQLiteOpenHelper {

    private static final String VERİTABANİ_ADİ="Dices";
    private static final int VERİTABANİ_SURUM=1;
    private static final String TABLO_DICES="zarlar";
    private static final String ROW_ID="id";
    private static final String ROW_TITLEA="titlea";
    private static final String ROW_NUMBERA="numbera";
    private static final String ROW_TYPEA="typea";
    private static final String ROW_BONUSA="bonusa";
    private static final String ROW_NUMBERB="numberb";
    private static final String ROW_TYPEB="typeb";
    private static final String ROW_BONUSB="bonusb";


    public DiceDatabase(Context context){
        super(context,VERİTABANİ_ADİ,null,VERİTABANİ_SURUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE "+TABLO_DICES+"("
        +ROW_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
        +ROW_TITLEA+ " TEXT NOT NULL, "
        +ROW_NUMBERA+ " TEXT NOT NULL, "
        +ROW_TYPEA+ " TEXT NOT NULL, "
        +ROW_BONUSA+ " TEXT NOT NULL, "
        +ROW_NUMBERB+ " TEXT NOT NULL, "
        +ROW_TYPEB+ " TEXT NOT NULL, "
        +ROW_BONUSB+ " TEXT NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void VeriEkle(String title,String numbera,String tipa,String eka,String numberb,String tipb,String ekb){
        SQLiteDatabase db=this.getWritableDatabase();

        try {
            ContentValues cv=new ContentValues();
            cv.put(ROW_TITLEA,title);
            cv.put(ROW_NUMBERA,numbera);
            cv.put(ROW_TYPEA,tipa);
            cv.put(ROW_BONUSA,eka);
            cv.put(ROW_NUMBERB,numberb);
            cv.put(ROW_TYPEB,tipb);
            cv.put(ROW_BONUSB,ekb);
            db.insert(TABLO_DICES,null,cv);
        }catch (Exception e){

        }
        db.close();
    }

    public List<CustomDice> VeriListele(){
        List<CustomDice> veriler=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();

        try {
            String[] sutunlar={ROW_ID,ROW_TITLEA,ROW_NUMBERA,ROW_TYPEA,ROW_BONUSA,
            ROW_NUMBERB,ROW_TYPEB,ROW_BONUSB};
            Cursor cursor=db.query(TABLO_DICES,sutunlar,null,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(new CustomDice(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getString(5),cursor.getString(6),
                        cursor.getString(7)));
            }
        }catch (Exception e){

        }
        db.close();
        return veriler;

    }

    public void VeriSil(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        try{
            String where=ROW_ID + " = " + id;
            db.delete(TABLO_DICES,where,null);
        }catch (Exception e){

        }
        db.close();
    }

    public CustomDice VeriCek(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLO_DICES,new String[]{ROW_ID,
        ROW_TITLEA,ROW_NUMBERA,ROW_TYPEA,ROW_BONUSA,ROW_NUMBERB,
        ROW_TYPEB,ROW_BONUSB},ROW_ID+"=?",
                new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor!=null)
            cursor.moveToFirst();

        CustomDice customDice=new CustomDice(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4),cursor.getString(5),
                cursor.getString(6),cursor.getString(7));

        return customDice;

    }



}
