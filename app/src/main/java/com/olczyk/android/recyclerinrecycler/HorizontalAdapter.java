package com.olczyk.android.recyclerinrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.RecyclerHolder> {
    private List<Note> notes = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public HorizontalAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerHolder(layoutInflater,parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder recyclerHolder, int i) {
        Note note = notes.get(i);
        recyclerHolder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.horizontal_recycler_list_item;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder{
        private Note note;
        private TextView textView;
        private Button button;

        public RecyclerHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
            super(inflater.inflate(viewType,parent,false));
            textView = itemView.findViewById(R.id.textView_horizontal_item);
            button = itemView.findViewById(R.id.button_horizontal_item);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Clicked " + textView.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(Note note){
            this.note = note;
            textView.setText(note.getTitle());
            button.setText(note.getButton());
        }
    }
}
