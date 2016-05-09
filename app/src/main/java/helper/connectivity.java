package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by shivangshu on 3/5/16.
 */

public class connectivity extends SQLiteOpenHelper {

    private static final String database = "user.db";// To make database
    // unaccessible to other
    // unauthenticated users

    private final static String table = "Registration";
    Context context;

    public connectivity(Context context) {
        super(context, database, null, 1);// manually changed super constructor
        // null- we dont use factory class
        // 1-version
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        String query = "create table " + table
                + " (id int primary key, "
                + "Name text(40), "
                + "Sex char(2), Age char(3))";
        arg0.execSQL(query);
//        Toast.makeText(context, "Table Created!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

        String query = "drop table if exists " + table;
        arg0.execSQL(query);// Old table deleted
        onCreate(arg0);// New table created according to current version
    }

    public void insert(String name, String sex, String age) {
        SQLiteDatabase db = getWritableDatabase();// open db in writable mode
        ContentValues c = new ContentValues();// DML Statements
        // Used when you need to manipulate data
        // one of the class of content provider
        // c.put(Column Name, Local value received)
        String idRecd = searchMaxId();
        c.put("id",idRecd+1);
        c.put("Name", name);
        c.put("Sex", sex);
        c.put("Age", age);

        db.insert(table, null, c);
        // Toast.makeText(context, "Element inserted in table!!",
        // Toast.LENGTH_SHORT).show();
    }

    public Cursor search(String findemail) {
        // TODO Auto-generated method stub

        SQLiteDatabase data = getReadableDatabase();// open database in readable
        // mode
        String query = "select * from " + table + " where Email='" + findemail
                + "'";
        Cursor cursor = data.rawQuery(query, null);

        return cursor;
    }



    public String searchName(){
        SQLiteDatabase data = getReadableDatabase();
        String query="select Name from "+table+" where id=(select max(id) from " +table+")";
        Cursor cursor=data.rawQuery(query, null);

        if(cursor.moveToFirst()){
            return   cursor.getString(0);
        }
        if(cursor==null)
            return "";
        return "";
    }
    public String searchMaxId(){
        SQLiteDatabase data = getReadableDatabase();
        String query="select max(id) from "+table;
        Cursor cursor=data.rawQuery(query, null);
        if(cursor.moveToFirst()){
          return   cursor.getString(0);
        }
        if(cursor==null)
            return "";
        return "";
    }

    // public ArrayList<String> search(String findemail) {
    // // TODO Auto-generated method stub
    // ArrayList<String> arr = new ArrayList<String>();
    // SQLiteDatabase data = getReadableDatabase();// open database in readable
    // // mode
    // String query = "select * from " + table + " where Email='" + findemail
    // + "'";
    // Cursor cursor = data.rawQuery(query, null);
    // if (cursor.moveToFirst()) {
    // do {
    // // String foundname = cursor.getString(0);
    // // String foundemail = cursor.getString(2);
    // // String foundcountry = cursor.getString(3);
    // // Toast.makeText(context,"foundname"+ foundname,
    // // Toast.LENGTH_SHORT).show();
    // // Log.d("val=", findemail);
    //
    // arr.add(cursor.getString(0));
    // arr.add(cursor.getString(2));
    // arr.add(cursor.getString(3));
    // } while (cursor.moveToNext());
    // }
    // return arr;
    // }
    // public Cursor searchAll()
    // public ArrayList<String> searchAll() {
    // // TODO Auto-generated method stub
    // ArrayList<String> arr = new ArrayList<String>();
    // SQLiteDatabase data = getReadableDatabase();// open database in readable
    // // mode
    // String query = "select * from " + table;
    // Cursor cursor = data.rawQuery(query, null);
    // if (cursor.moveToFirst()) {
    // do {
    // // String foundname = cursor.getString(0);
    // // String foundemail = cursor.getString(2);
    // // String foundcountry = cursor.getString(3);
    // // Toast.makeText(context,"foundname"+ foundname,
    // // Toast.LENGTH_SHORT).show();
    // // Log.d("val=", findemail);
    //
    // arr.add(cursor.getString(0));
    // arr.add(cursor.getString(2));
    // arr.add(cursor.getString(3));
    // } while (cursor.moveToNext());
    // }
    // return arr;
    // //return cursor
    // }

    public Cursor searchAll() {
        // TODO Auto-generated method stub

        SQLiteDatabase data = getReadableDatabase();// open database in readable
        // mode
        String query = "select * from " + table+" where id=(select max(id) from "+table+")";
        Cursor cursor = data.rawQuery(query, null);

        return cursor;
        // return cursor
    }

    public boolean delete(String email) {
        // SQLiteDatabase data = getReadableDatabase();
        SQLiteDatabase db = getWritableDatabase();
        if (search(email).getCount() >0) {

            db.delete(table, "Email='" + email + "'", null);
            // Toast.makeText(context, "Element deleted.", Toast.LENGTH_SHORT)
            // .show();

            return true;
        } else
            return false;
    }

    public void update(String email, String name, String password,
                       String country) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        if (!name.equals(""))
            c.put("Name", name);
        if (!password.equals(""))
            c.put("Password", password);
        if (!country.equals(""))
            c.put("Country", country);
        db.update(table, c, "Email='" + email + "'", null);
        Toast.makeText(context, "Element Updated!", Toast.LENGTH_SHORT).show();
    }

}