package com.mycompany.myapp;

/**
 * Created by David on 14/09/2015.
 */
public class Theme {
    private int idStudy = 0;
    private  int idTheme = 0;
    private String Title = "";
    private String HTMLContent = "";
    private String Question = "";
    private String OPTION1 = "";
    private String OPTION2 = "";
    private String OPTION3 = "";
    private String ANSWER = "";

    public int getIdStudy() {
        return idStudy;
    }

    public void setIdStudy(int idStudy) {
        this.idStudy = idStudy;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getHTMLContent() {
        return HTMLContent;
    }

    public void setHTMLContent(String HTMLContent) {
        this.HTMLContent = HTMLContent;
    }
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }


    public String getOPTION1() {
        return OPTION1;
    }

    public void setOPTION1(String OPTION1) {
        this.OPTION1 = OPTION1;
    }

    public String getOPTION2() {
        return OPTION2;
    }

    public void setOPTION2(String OPTION2) {
        this.OPTION2 = OPTION2;
    }

    public String getOPTION3() {
        return OPTION3;
    }

    public void setOPTION3(String OPTION3) {
        this.OPTION3 = OPTION3;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Theme() {
        super();
    }
    public Theme(int idTheme, int idStudy, String Title, String HTMLContent, String Question, String OPTION1, String OPTION2, String OPTION3, String ANSWER ){
        this.idTheme = idTheme;
        this.idStudy = idStudy;
        this.Title = Title;
        this.HTMLContent = HTMLContent;
        this.Question = Question;
        this.OPTION1 = OPTION1;
        this.OPTION2 = OPTION2;
        this.OPTION3 = OPTION3;
        this.ANSWER = ANSWER;
    }
}
