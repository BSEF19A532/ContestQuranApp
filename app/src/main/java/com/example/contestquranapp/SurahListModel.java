package com.example.contestquranapp;

public class SurahListModel {
    private String engSurahName;
    private String urduSurahName;
    private String urduSurahIntro;

    public SurahListModel(String engSurahName, String urduSurahName, String urduSurahIntro) {
        this.engSurahName = engSurahName;
        this.urduSurahName = urduSurahName;
        this.urduSurahIntro = urduSurahIntro;
    }

    public String getEngSurahName() {
        return engSurahName;
    }

    public String getUrduSurahName() {
        return urduSurahName;
    }

    public String getUrduSurahIntro() {
        return urduSurahIntro;
    }

    public void setEngSurahName(String engSurahName) {
        this.engSurahName = engSurahName;
    }

    public void setUrduSurahName(String urduSurahName) {
        this.urduSurahName = urduSurahName;
    }

    public void setUrduSurahIntro(String urduSurahIntro) {
        this.urduSurahIntro = urduSurahIntro;
    }
}
