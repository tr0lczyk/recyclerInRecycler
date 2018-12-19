package com.olczyk.android.recyclerinrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalHolder> {
    private List<VerticalObject> verticalObjects;
    private Context context;
    LayoutInflater layoutInflater;

    public VerticalAdapter(List<VerticalObject> verticalObjects, Context context) {
        this.verticalObjects = verticalObjects;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public VerticalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VerticalHolder(layoutInflater, parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalHolder verticalHolder, int i) {
        VerticalObject verticalObject = verticalObjects.get(i);
        verticalHolder.bind(verticalObject);
    }

    @Override
    public int getItemCount() {
        return verticalObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.main_recycler_list_item;
    }

    public class VerticalHolder extends RecyclerView.ViewHolder {
        private VerticalObject verticalObject;
        RecyclerView horizontal_recycler;
        TextView textView_section;

        public VerticalHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
            super(inflater.inflate(viewType,parent,false));
            horizontal_recycler = itemView.findViewById(R.id.horizontal_recycler);
            textView_section = itemView.findViewById(R.id.textView_section);
        }

        public void bind(VerticalObject verticalObject) {
            this.verticalObject = verticalObject;
            String section = verticalObject.getSection();
            textView_section.setText(section);
            horizontal_recycler.setHasFixedSize(true);
            horizontal_recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            HorizontalAdapter adapter = new HorizontalAdapter(verticalObject.getNotes(), context);
            horizontal_recycler.setAdapter(adapter);
        }
    }
}
