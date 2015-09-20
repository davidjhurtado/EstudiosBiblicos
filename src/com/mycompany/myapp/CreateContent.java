package com.mycompany.myapp;

/**
 * Created by David on 17/09/2015.
 */
import android.content.Context;
import  android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateContent {

    private Context _context;

    public Context get_context() {
        return _context;
    }

    public void set_context(Context _context) {
        this._context = _context;
    }

    public CreateContent(Context context) {
        super();
        this._context = context;
    }
    public void insertContent(Context content){
        Study study = new Study(1,"Fé de Jesús",0);
        Theme theme = new Theme(1,1,"¿Qué Enseña la Biblia acerca de Dios?","<html><title></title><body>Efesios 4:6 Un Dios y Padre de todos, el Cual es Sobre todos y por todos, y en todos.</body></html>","","","","");
        StudiesDBHelper db = new StudiesDBHelper(get_context());
        db.insertStudy(study);
    }

}
