package com.mycompany.myapp;

/**
 * Created by David on 05/08/2015.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  android.content.ContentValues;

import java.util.LinkedList;
import java.util.List;

public class StudiesDBHelper extends SQLiteOpenHelper {
    private static final int dbVERSION = 1;
    private static final String dbNAME = "StudiesDB";

    private static final String userTblNAME = "usuario";
    private static final String user_ID = "idUsuario";
    private static final String user_NAME = "Nombre";
    private static final String user_DIR = "Direccion";
    private static final String user_PHONE = "Telefono";
    private static final String user_EMAIL = "Email";

    private static final String[] user_COLUMNS = {user_ID, user_NAME, user_DIR, user_PHONE, user_EMAIL };

    public StudiesDBHelper(Context context){
        super(context, dbNAME, null, dbVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + userTblNAME +  " ( " + user_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + user_NAME + " TEXT, " + user_DIR + " TEXT, " + user_PHONE + " TEXT, " + user_EMAIL + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1) {
           // db.execSQL("DROP TABLE IF EXISTS " + userTblNAME);
            this.onCreate(db);
        };
    }

    public boolean insertUser(User user){
        boolean result = false;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(user_ID, user.getIdUsusario());
        values.put(user_NAME, user.getNombre());
        values.put(user_DIR, user.getDireccion());
        values.put(user_PHONE, user.getTelefono());
        values.put(user_EMAIL, user.getEmail());
        long rowID = db.insert(userTblNAME, null, values);
        db.close();
        if (rowID!= -1) {
            result = true;
        }
        return result;
    }

    public int updateUser(User user){
        // get reference of the StudiesDB database
        SQLiteDatabase db = this.getWritableDatabase();
        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(user_NAME, user.getNombre()); // get Name
        values.put(user_DIR, user.getDireccion()); // get Dir
        values.put(user_PHONE, user.getTelefono()); // get Phone
        values.put(user_EMAIL, user.getEmail()); // get Email
        // update
        int i = db.update(userTblNAME, values, user_ID + " = ?", new String[] { String.valueOf(user.getIdUsusario()) });
        db.close();
        return i;
    }


    ///////////////////////
    public User readUser(int ID) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        // get book query
        Cursor cursor = db.query(userTblNAME, // a. table
                user_COLUMNS, " idUsuario = ?", new String[] { String.valueOf(ID)}, null, null, null, null);
        // if results !=null, parse the first one
        if (cursor != null) cursor.moveToFirst();
        User user = new User();
        user.setIdUsusario(Integer.parseInt(cursor.getString(0)));
        user.setNombre(cursor.getString(1));
        user.setDireccion(cursor.getString(2));
        user.setTelefono(cursor.getString(3));
        user.setEmail(cursor.getString(3));
        db.close();
        return user;
    }

    public List getAllUsers() {
        List users = new LinkedList();
        // select book query
        String query = "SELECT  * FROM " + userTblNAME;
        // get reference of the BookDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // parse all results

        User user = null;
        if (cursor.moveToFirst()) {

            do {

                user = new User();
                user.setIdUsusario(Integer.parseInt(cursor.getString(0)));
                user.setNombre(cursor.getString(1));
                user.setDireccion(cursor.getString(2));

                // Add book to books

                users.add(user);

            } while (cursor.moveToNext());

        }

        return users;

    }


    public void deleteBook(User user) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getWritableDatabase();
        // delete book
        db.delete(userTblNAME, user_ID + " = ?", new String[]{String.valueOf(user.getIdUsusario())});
        db.close();
    }

    ///////////////////////////
}
