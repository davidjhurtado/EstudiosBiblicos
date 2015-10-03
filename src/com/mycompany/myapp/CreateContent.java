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
        Theme theme = new Theme(1,1,title,htmlcontent,question,"A) Un Solo DIOS","B) Muchos DIOSES","C) Varios DIOSES","1");
        StudiesDBHelper db = new StudiesDBHelper(context);
        db.insertStudy(study);
        db.insertTheme(theme);
        theme.setIdTheme(2);
        theme.setIdStudy(1);
        theme.setTitle(title);
        htmlcontent = "<html><title></title><body><p><strong>Juan 4:24</strong> \"Dios es Esp&iacute;ritu; y Los Que le adoran, en Esp&iacute;ritu y en verdad es Necesario Que adoren\"</p></body></html>";
        theme.setHTMLContent(htmlcontent);
        theme.setQuestion("¿Cuál es la naturaleza de Dios?");
        theme.setOPTION1("A) CARNE");
        theme.setOPTION2("B) ESPIRITU");
        theme.setOPTION3("C) CIENCIA");
        theme.setANSWER("2");
        db.insertTheme(theme);
        study.setPercent(0);
        study.setTitle("Hogar Felíz");
        study.setIdStudy(2);
        db.insertStudy(study);
        theme.setIdTheme(3);
        theme.setIdStudy(study.getIdStudy());
        htmlcontent = "<h2>Hogar Feliz</h2>\n" +
                "<p>Los arduos problemas de la sociedad moderna guardan una &iacute;ntima relaci&oacute;n con los problemas que se viven en el seno del hogar. S&iacute; hubiera mejores hogares, &iquest;no cree Ud. que vivir&iacute;amos en un mundo mejor? De ah&iacute; que la necesidad m&aacute;s apremiante del momento actual sea la de construir mejores hogares, donde padres e hijos puedan convivir en un clima de armon&iacute;a, y de donde parta una influencia elevadora para bien de la humanidad. Esta es la raz&oacute;n que nos ha movido a preparar este curso por correspondencia, que hoy ponemos cordialmente en sus manos, con los mejores deseos para Ud. y sus seres amados. A lo largo de las diez lecciones del curso iremos abordando aspectos pr&aacute;cticos y valiosos para la felicidad familiar, tales como la armon&iacute;a y la felicidad conyugal, la intimidad del matrimonio, c&oacute;mo desarrollar el amor, c&oacute;mo educar a los hijos, c&oacute;mo tratar al hijo rebelde, las finanzas de la casa, la salud de la familia y much&iacute;simos otros temas relativos al quehacer del hogar. En suma, todos los elementos indispensables parra forjar y retener la dicha del n&uacute;cleo familiar</p>";
        theme.setHTMLContent(htmlcontent);
        theme.setQuestion("¿Es mi novio (o mi novia)\n" +
                "generalmente alegre, feliz y optimista?\n" +
                "Es muy raro que el matrimonio cambie\n" +
                "los rasgos fundamentales de la\n" +
                "personalidad");
        theme.setOPTION1("A) A veces");
        theme.setOPTION2("B) Siempre");
        theme.setOPTION3("C) Nunca");
        theme.setANSWER("2");
        db.insertTheme(theme);
    }

}
