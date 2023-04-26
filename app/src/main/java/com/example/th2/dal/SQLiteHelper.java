package com.example.th2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.th2.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "book_ticket.db";
    private static int DATABASE_VERSION = 1;
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ticket("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,departure TEXT, time TEXT, luggage TEXT, service TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {

        super.onOpen(db);
    }

    public List<Ticket> getAllTicket(){
        List<Ticket> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery("SELECT * FROM ticket", null);
        while (rs!=null && rs.moveToNext()){
            int id = rs.getInt(0);
            String name = rs.getString(1);
            String departure = rs.getString(2);
            String time = rs.getString(3);
            String luggage = rs.getString(4);
            String service = rs.getString(5);
            list.add(new Ticket(id, name,departure, time, luggage, service));
        }
        return list;
    }

    public long addTicket(Ticket ticket){
        ContentValues values = new ContentValues();
        values.put("name", ticket.getName());
        values.put("departure", ticket.getDeparture());
        values.put("time", ticket.getTime());
        values.put("luggage", ticket.getLuggage());
        values.put("service", ticket.getService());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("ticket", null, values);
    }

    public void clearDatabase(String TABLE_NAME) {
        SQLiteDatabase db = getReadableDatabase();
        String clearDBQuery = "DELETE FROM " + TABLE_NAME;
        db.execSQL(clearDBQuery);
    }
}
