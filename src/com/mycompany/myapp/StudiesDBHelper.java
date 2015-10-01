package com.mycompany.myapp;

/*
 * Created by David on 05/08/2015
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  android.content.ContentValues;

import java.util.ArrayList;
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

    private static final String studyTblNAME = "estudio";
    private static final String study_ID = "idEstudio";
    private static final String study_TITLE = "Titulo";
    private static final String study_PERCENT = "Porcentaje";

    private static final String themeTblNAME = "tema";
    private static final String theme_ID = "idTema";
    private static final String theme_TITLE = "Titulo";
    private static final String theme_HTMLCONTENT = "ContenidoHTML";
    private static final String theme_QUESTION = "Pregunta";
    private static final String theme_OPTION1 = "Opcion1";
    private static final String theme_OPTION2 = "Opcion2";
    private static final String theme_OPTION3 = "Opcion3";
    private static final String theme_ANSWER = "Respuesta";


    private static final String[] user_COLUMNS = {user_ID, user_NAME, user_DIR, user_PHONE, user_EMAIL };
    private static final String[] study_COLUMNS = {study_ID, study_TITLE, study_PERCENT};
    private static final String[] theme_COLUMNS = {theme_ID, study_ID, theme_TITLE, theme_HTMLCONTENT, theme_QUESTION, theme_OPTION1, theme_OPTION2, theme_OPTION3, theme_ANSWER};

    public StudiesDBHelper(Context context){
        super(context, dbNAME, null, dbVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + userTblNAME +  " ( " + user_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + user_NAME + " TEXT, " + user_DIR + " TEXT, " + user_PHONE + " TEXT, " + user_EMAIL + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
        String CREATE_STUDY_TABLE = "CREATE TABLE IF NOT EXISTS " + studyTblNAME +  " ( " + study_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + study_TITLE + " TEXT, " + study_PERCENT + " NUMERIC)";
        db.execSQL(CREATE_STUDY_TABLE);
        String CREATE_THEME_TABLE = "CREATE TABLE IF NOT EXISTS " + themeTblNAME +  " ( " + theme_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + study_ID + " INTEGER, " + theme_TITLE + " TEXT," + theme_HTMLCONTENT + " TEXT, " + theme_QUESTION + " TEXT, " + theme_OPTION1 + " TEXT," + theme_OPTION2 + " TEXT," + theme_OPTION3 + " TEXT, " + theme_ANSWER + " TEXT)";
        db.execSQL(CREATE_THEME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1) {
           // db.execSQL("DROP TABLE IF EXISTS " + userTblNAME);
            this.onCreate(db);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////                            INTERFAZ DE USUARIO                                       ///////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        // get reference of the UserDB database
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
                // Add user to users
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(userTblNAME, user_ID + " = ?", new String[]{String.valueOf(user.getIdUsusario())});
        db.close();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////                            INTERFAZ DE STUDY                                       ///////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean insertStudy(Study study){
        boolean result = false;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(study_ID, study.getIdStudy());
        values.put(study_TITLE, study.getTitle());
        values.put(study_PERCENT, study.getPercent());
        long rowID = db.insert(studyTblNAME, null, values);
        db.close();
        if (rowID!= -1) {
            result = true;
        }
        return result;
    }

    public int updateStudy(Study study){
        // get reference of the StudiesDB database
        SQLiteDatabase db = this.getWritableDatabase();
        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(study_TITLE, study.getTitle()); //
        values.put(study_PERCENT, study.getPercent()); //
        // update
        int i = db.update(studyTblNAME, values, study_ID + " = ?", new String[]{String.valueOf(study.getIdStudy())});
        db.close();
        return i;
    }

    public Study readStudy(int ID) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        // get book query
        Cursor cursor = db.query(studyTblNAME, // a. table
                study_COLUMNS, study_ID + " = ?", new String[] { String.valueOf(ID)}, null, null, null, null);
        // if results !=null, parse the first one
        if (cursor != null) cursor.moveToFirst();
        Study study = new Study();
        study.setIdStudy(Integer.parseInt(cursor.getString(0)));
        study.setTitle(cursor.getString(1));
        study.setPercent(Double.parseDouble(cursor.getString(2)));
        db.close();
        return study;
    }
    public Study readStudyByTitlte(String Title) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        // get book query
        Cursor cursor = db.query(studyTblNAME, // a. table
                study_COLUMNS, study_TITLE + " = ?", new String[] { Title}, null, null, null, null);
        // if results !=null, parse the first one
        if (cursor != null) cursor.moveToFirst();
        Study study = new Study();
        study.setIdStudy(Integer.parseInt(cursor.getString(0)));
        study.setTitle(cursor.getString(1));
        study.setPercent(Double.parseDouble(cursor.getString(2)));
        db.close();
        return study;
    }
    public List<Study> getAllStudies() {
        List studies = new LinkedList();
        // select book query
        String query = "SELECT  * FROM " + studyTblNAME;
        // get reference of the UserDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        // parse all results
        Study study = null;
        if (cursor.moveToFirst()) {
            do {
                study = new Study();
                study.setIdStudy(Integer.parseInt(cursor.getString(0)));
                study.setTitle(cursor.getString(1));
                study.setPercent(Double.parseDouble(cursor.getString(2)));
                // Add user to users
                studies.add(study);
            } while (cursor.moveToNext());
        }
        return studies;
    }

    public void deleteStudy(Study study) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(studyTblNAME, study_ID + " = ?", new String[]{String.valueOf(study.getIdStudy())});
        db.close();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean insertTheme(Theme theme){
    boolean result = false;
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(theme_ID, theme.getIdTheme());
    values.put(study_ID, theme.getIdStudy());
    values.put(study_TITLE, theme.getTitle());
    values.put(theme_HTMLCONTENT, theme.getHTMLContent());
    values.put(theme_QUESTION, theme.getQuestion());
    values.put(theme_OPTION1, theme.getOPTION1());
    values.put(theme_OPTION2, theme.getOPTION2());
    values.put(theme_OPTION3, theme.getOPTION3());
    values.put(theme_ANSWER, theme.getANSWER());
    long rowID = db.insert(themeTblNAME, null, values);
    db.close();
    if (rowID!= -1) {
        result = true;
    }
    return result;
}

    public int updateTheme(Theme theme){
        // get reference of the StudiesDB database
        SQLiteDatabase db = this.getWritableDatabase();
        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put(study_ID, theme.getIdStudy()); //
        values.put(study_TITLE, theme.getTitle());
        values.put(theme_HTMLCONTENT, theme.getHTMLContent()); //
        values.put(theme_QUESTION, theme.getQuestion());
        values.put(theme_OPTION1, theme.getOPTION1()); //
        values.put(theme_OPTION2, theme.getOPTION2()); //
        values.put(theme_OPTION3, theme.getOPTION3()); //
        values.put(theme_ANSWER, theme.getANSWER()); //
        // update
        int i = db.update(themeTblNAME, values, theme_ID + " = ?", new String[]{String.valueOf(theme.getIdTheme())});
        db.close();
        return i;
    }

    public Theme readTheme(int ID) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getReadableDatabase();
        // get book query
        Cursor cursor = db.query(themeTblNAME, // a. table
                theme_COLUMNS, theme_ID + " = ?", new String[] { String.valueOf(ID)}, null, null, null, null);
        // if results !=null, parse the first one
        if (cursor != null) cursor.moveToFirst();
        Theme theme = new Theme();
        theme.setIdTheme(Integer.parseInt(cursor.getString(0)));
        theme.setIdStudy(Integer.parseInt(cursor.getString(1)));
        theme.setTitle(cursor.getString(2));
        theme.setHTMLContent(cursor.getString(3));
        theme.setQuestion(cursor.getString(4));
        theme.setOPTION1(cursor.getString(5));
        theme.setOPTION2(cursor.getString(6));
        theme.setOPTION3(cursor.getString(7));
        theme.setANSWER(cursor.getString(8));
        db.close();
        return theme;
    }


    public void deleteThemeByStudy (Theme theme) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(studyTblNAME, theme_ID + " = ?", new String[]{String.valueOf(theme.getIdStudy())});
        db.close();
    }

    public void deleteTheme (Theme theme) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(studyTblNAME, theme_ID + " = ?", new String[]{String.valueOf(theme.getIdTheme())});
        db.close();
    }

    public List<Theme> getAllThemesByStudy(int StudyID) {
        List themes = new LinkedList();
        // select book query
        String query = "SELECT " + theme_ID + ", " + study_ID + ", " + theme_TITLE + ", " + theme_HTMLCONTENT + ", " + theme_QUESTION + ", "+ theme_OPTION1 + ", " + theme_OPTION2 + ", " + theme_OPTION3 + ", " + theme_ANSWER + "  FROM " + themeTblNAME + " WHERE " + study_ID + " = " + String.valueOf(StudyID) + " ORDER BY " + theme_ID;
        // get reference of the UserDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        // parse all results
        Theme theme = null;
        if (cursor.moveToFirst()) {
            do {
                theme = new Theme();
                theme.setIdTheme(Integer.parseInt(cursor.getString(0)));
                theme.setIdStudy(Integer.parseInt(cursor.getString(1)));
                theme.setTitle(cursor.getString(2));
                theme.setHTMLContent(cursor.getString(3));
                theme.setQuestion(cursor.getString(4));
                theme.setOPTION1(cursor.getString(5));
                theme.setOPTION2(cursor.getString(6));
                theme.setOPTION3(cursor.getString(7));
                theme.setANSWER(cursor.getString(8));
                // Add user to users
                themes.add(theme);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return themes;
    }
   /* public List getAllStudiesTitles () {
        List<Study> studies = getAllStudies();
        ArrayList <String> titles = new ArrayList<String>();
        for (Study study : studies){

        }
        for (int i = 0; i<studies.size();i++){
            String st = studies.get(i).getTitle():

        }

    }*/
}
