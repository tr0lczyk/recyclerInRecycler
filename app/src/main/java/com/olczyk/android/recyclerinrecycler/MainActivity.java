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

    @ViewById
    RecyclerView vertical_recycler2;

    @ViewById
    RecyclerView vertical_recycler3;

    List<VerticalObject> verticalObjects = new ArrayList<>();

    List<Note> notes = new ArrayList<>();

    @AfterViews
    public void aVoid(){
        createNote2List();
        vertical_recycler.setHasFixedSize(true);
        vertical_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HorizontalAdapter adapter = new HorizontalAdapter(notes,this);
        vertical_recycler.setAdapter(adapter);

        vertical_recycler2.setHasFixedSize(true);
        vertical_recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HorizontalAdapter adapter2 = new HorizontalAdapter(notes,this);
        vertical_recycler2.setAdapter(adapter2);

        vertical_recycler3.setHasFixedSize(true);
        vertical_recycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        HorizontalAdapter adapter3 = new HorizontalAdapter(notes,this);
        vertical_recycler3.setAdapter(adapter3);
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

    private void createNote2List(){
        for (int i = 0; i <= 20; i++){
            Note note = new Note("dupa " + i, "button " + i);
            notes.add(note);
        }
    }
}
