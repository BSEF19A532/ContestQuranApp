package com.example.contestquranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "quran_app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String tayah_statement = "CREATE TABLE \"tayah\" (\n" +
//                "\t\"_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
//                "\t\"SuraID\"\tINTEGER,\n" +
//                "\t\"AyaNo\"\tINTEGER,\n" +
//                "\t\"ArabicText\"\tTEXT,\n" +
//                "\t\"FatehMuhammadJalandhri\"\tTEXT,\n" +
//                "\t\"MehmoodulHassan\"\tTEXT,\n" +
//                "\t\"DrMohsinKhan\"\tTEXT,\n" +
//                "\t\"MuftiTaqiUsmani\"\tTEXT,\n" +
//                "\t\"RakuID\"\tINTEGER,\n" +
//                "\t\"PRakuID\"\tINTEGER,\n" +
//                "\t\"ParaID\"\tINTEGER\n" +
//                ")";
//
//        String tsurah_statement = "CREATE TABLE \"tsurah\" (\n" +
//                "\t\"_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
//                "\t\"SurahIntro\"\tTEXT,\n" +
//                "\t\"SurahNameE\"\tTEXT,\n" +
//                "\t\"Nazool\"\tTEXT,\n" +
//                "\t\"SurahNameU\"\tTEXT\n" +
//                ")";
//        sqLiteDatabase.execSQL(tayah_statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<SurahListModel> getSurahs() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT SurahNameE, SurahNameU, SurahIntro FROM tsurah;", null);
        ArrayList<SurahListModel> result = new ArrayList<>();
        if (!cursorCourses.moveToFirst()) return result;
        do {
            SurahListModel item = new SurahListModel(
                    cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2)
            );
            result.add(item);
        } while (cursorCourses.moveToNext());
        return result;
    }

    public ArrayList<AyahListModel> getAyahs(int surahID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery(
                "SELECT ArabicText, FatehMuhammadJalandhri, DrMohsinKhan " +
                    "FROM tayah " +
                    "WHERE suraID = ?;",
        new String[] { Integer.toString(surahID) });
        ArrayList<AyahListModel> result = new ArrayList<>();
        if (!cursorCourses.moveToFirst()) return result;
        do {
            AyahListModel item = new AyahListModel(
                    cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2)
            );
            result.add(item);
        } while (cursorCourses.moveToNext());
        return result;
    }

    public int getSurah(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT _id FROM tsurah WHERE SurahNameE LIKE ?;", new String[] { "%" + name + "%" });
        if (!cursorCourses.moveToFirst()) return -1;
        do {
            return cursorCourses.getInt(0);
        } while (cursorCourses.moveToNext());
    }

    public ArrayList<AyahListModel> getPara(int paraID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery(
                "SELECT ArabicText, FatehMuhammadJalandhri, DrMohsinKhan " +
                        "FROM tayah " +
                        "WHERE ParaID = ?;",
                new String[] { Integer.toString(paraID) });
        ArrayList<AyahListModel> result = new ArrayList<>();
        if (!cursorCourses.moveToFirst()) return result;
        do {
            AyahListModel item = new AyahListModel(
                    cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2)
            );
            result.add(item);
        } while (cursorCourses.moveToNext());
        return result;
    }

}
