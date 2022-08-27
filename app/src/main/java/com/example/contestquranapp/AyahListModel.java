package com.example.contestquranapp;

public class AyahListModel {
    private String ArabicText;
    private String engTranslation;
    private String urduTranslation;

    public AyahListModel(String arabicText, String urduTranslation, String engTranslation) {
        ArabicText = arabicText;
        this.engTranslation = engTranslation;
        this.urduTranslation = urduTranslation;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public String getEngTranslation() {
        return engTranslation;
    }

    public String getUrduTranslation() {
        return urduTranslation;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public void setEngTranslation(String engTranslation) {
        this.engTranslation = engTranslation;
    }

    public void setUrduTranslation(String urduTranslation) {
        this.urduTranslation = urduTranslation;
    }
}
