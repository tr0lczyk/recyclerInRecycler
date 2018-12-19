package com.olczyk.android.recyclerinrecycler;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    RecyclerView vertical_recycler;

    List<VerticalObject> verticalObjects = new ArrayList<>();

    @AfterViews
    public void aVoid(){
        createNoteList();
        vertical_recycler.setHasFixedSize(true);
        vertical_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        VerticalAdapter adapter = new VerticalAdapter(verticalObjects,this);
        vertical_recycler.setAdapter(adapter);
    }

    private void createNoteList(){
        for (int i = 0; i <= 5; i++){
            VerticalObject singleObject =  new VerticalObject();
            singleObject.setSection("Section  " + i);
            List<Note> notes = new ArrayList<>();
            for (int j = 0; j <= 8; j++) {
                Note note = new Note("note " + j, "click " + j );
                notes.add(note);
            }
            singleObject.setNotes(notes);
            verticalObjects.add(singleObject);
        }
    }
}
