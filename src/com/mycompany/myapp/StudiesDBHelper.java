package com.mycompany.myapp;

/**
 * Created by David on 05/08/2015.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  android.content.ContentValues;
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
        super(context,dbNAME, null, dbVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "title TEXT, " + "author TEXT )";
        db.execSQL(CREATE_BOOK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + userTblNAME);
        this.onCreate(db);
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
        // get reference of the BookDB database
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
}
