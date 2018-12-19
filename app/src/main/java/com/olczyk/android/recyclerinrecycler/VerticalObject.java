package com.olczyk.android.recyclerinrecycler;

import java.util.List;

public class VerticalObject {

    private String section;
    private List<Note> notes;

    public VerticalObject(){}

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
