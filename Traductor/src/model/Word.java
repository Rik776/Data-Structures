package model;

public class Word {
    private String english;
    private String spanish;
    private String french;
    public Word(String english) {
        this.english = english;
    }
    public String getEnglish() {
        return english;
    }
    public String getSpanish() {
        return spanish;
    }
    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }
    public String getFrench() {
        return french;
    }
    public void setFrench(String french) {
        this.french = french;
    }
    
}
