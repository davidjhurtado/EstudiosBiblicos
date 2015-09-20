package com.mycompany.myapp;

/**
 *  * Created by David Hurtado on 14/09/2015.
 */
public class Study {
    private int idStudy = 0;
    private String Title = "";
    private double Percent = 0;

    public int getIdStudy() {
        return idStudy;
    }

    public void setIdStudy(int idStudy) {
        this.idStudy = idStudy;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPercent() {
        return Percent;
    }

    public void setPercent(double percent) {
        Percent = percent;
    }
    public Study (){
    }
    public Study(int idStudy, String title, double percent) {
        super();
        this.idStudy = idStudy;
        Title = title;
        Percent = percent;
    }
}
