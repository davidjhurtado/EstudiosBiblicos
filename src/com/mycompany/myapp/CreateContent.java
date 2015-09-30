package com.mycompany.myapp;

/** * Created by David on 17/09/2015 . */
import android.content.Context;

public class CreateContent {

    public CreateContent() {
        super();
    }

    public void insertContent(Context context){
        Study study = new Study(1,"Fé de Jesús",0);
        String title = "¿Qué Enseña la Biblia acerca de Dios?";
        String htmlcontent = "<html><title></title><body><p><b>Efesios 4:6</b> Un <b>Dios<7b> y Padre de todos, el Cual es Sobre todos y por todos, y en todos.<p></body></html>";
        String question = "¿Cuántos dioses hay? Efesios 4:6";
        Theme theme = new Theme(1,1,title,htmlcontent,question,"A) Un Solo DIOS","B) Muchos DIOSES","C) Varios DIOSES","A) Un Solo DIOS");
        StudiesDBHelper db = new StudiesDBHelper(context);
        db.insertStudy(study);
        db.insertTheme(theme);
        theme.setIdTheme(2);
        theme.setIdStudy(1);
        theme.setTitle(title);
        htmlcontent = "<html><title></title><body><b>Juan 4:24</b> \"Dios es Espíritu; y Los Que le adoran, en Espíritu y en verdad es Necesario Que adoren\"</body></html>";
        theme.setHTMLContent(htmlcontent);
        theme.setQuestion("¿Cuál es la naturaleza de Dios?");
        theme.setOPTION1("A) CARNE");
        theme.setOPTION2("B) ESPIRITU");
        theme.setOPTION3("C) CIENCIA");
        theme.setANSWER("B) ESPIRITU");
        db.insertTheme(theme);
    }

}
