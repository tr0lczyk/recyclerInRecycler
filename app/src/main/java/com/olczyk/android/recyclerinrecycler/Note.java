package com.olczyk.android.recyclerinrecycler;

public class Note {
    private String title;
    private String button;

    public Note(String title, String button) {
        this.title = title;
        this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
