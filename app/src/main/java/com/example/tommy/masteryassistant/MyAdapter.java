package com.example.tommy.masteryassistant;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Danie_000 on 10/21/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Skill> skills = new ArrayList<Skill>();
    public Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        // each data item is just a string in this case
        public TextView skillName;
        public TextView skillHours;
        public Context context;
        public ViewHolder(View v, Context context) {
            super(v);
            itemView.setOnClickListener(this);
            this.context = context;
            skillName = (TextView) v.findViewById(R.id.name_of_skill);
            skillHours = (TextView)v.findViewById(R.id.no_of_hours);
        }

        public void onClick(View w){
            Preferences.setCurrentSkill(context, skillName.getText().toString());
            Toast.makeText(context, skillName.getText().toString() + " Selected", Toast.LENGTH_SHORT).show();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Skill> skills, Context newContext) {
        this.skills = skills;
        this.context = newContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v, context);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Skill currentSkill = skills.get(position);
        holder.skillName.setText(currentSkill.get_name());
        holder.skillHours.setText(Integer.toString(currentSkill.get_timeCompleted()) + " Hours");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return skills.size();
    }
}