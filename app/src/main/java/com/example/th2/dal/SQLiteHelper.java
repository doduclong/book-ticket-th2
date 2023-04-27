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

    public Ticket getItemById(int id){
        String where="id=?";
        String[] agrs={Integer.toString(id)};
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.query("ticket",null,where,agrs,null,
                null,null);
        if(rs!=null && rs.moveToNext()){
            return new Ticket(rs.getInt(0),rs.getString(1),rs.getString(1),rs.getString(3),
                    rs.getString(4),rs.getString(5));

        }
        return null;
    }
    //update item
    public int updateItem(Ticket ticket){
        ContentValues values=new ContentValues();
        values.put("name", ticket.getName());
        values.put("departure", ticket.getDeparture());
        values.put("time", ticket.getTime());
        values.put("luggage", ticket.getLuggage());
        values.put("service", ticket.getService());
        String where="id=?";
        String[] agrs={Integer.toString(ticket.getId())};
        SQLiteDatabase st=getWritableDatabase();
        return st.update("ticket",values,where,agrs);
    }
    public int deleteItem(int id){
        String where="id=?";
        String[] agrs={Integer.toString(id)};
        SQLiteDatabase st=getWritableDatabase();
        return st.delete("ticket",where,agrs);
    }
    public List<Ticket> searchItemBykey(String key){
        List<Ticket> list=new ArrayList<>();
        String sql="select t.id,t.name,t.price,t.date,c.id,c.name " +
                "from categories c inner join items t " +
                "on (c.id=t.cid) where t.name like ? or c.name like ?";
        String[] agrs={"%"+key+"%","%"+key+"%"};
        SQLiteDatabase st=getReadableDatabase();
        Cursor rs=st.rawQuery(sql,agrs);
        while(rs!=null && rs.moveToNext()){
            list.add(new Ticket(rs.getInt(0),rs.getString(1),rs.getString(1),rs.getString(3),
                    rs.getString(4),rs.getString(5)));
        }
        rs.close();
        return list;
    }

    public void clearDatabase(String TABLE_NAME) {
        SQLiteDatabase db = getReadableDatabase();
        String clearDBQuery = "DELETE FROM " + TABLE_NAME;
        db.execSQL(clearDBQuery);
    }
}
