package com.example.tommy.masteryassistant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.lzyzsd.circleprogress.DonutProgress;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

import static com.example.tommy.masteryassistant.R.id.imageView;
import static com.example.tommy.masteryassistant.R.id.wrap_content;

/**
 * Created by Danie_000 on 10/28/2016.
 */

public class Milestone_adapter extends RecyclerView.Adapter<Milestone_adapter.ViewHolder> {
    ArrayList<Milestone_Collection> SET_of_milestoneCollections = new ArrayList<>();


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private DonutProgress donutProgress1;
        private DonutProgress donutProgress2;
        private DonutProgress donutProgress3;
        private DonutProgress donutProgress4;
        private DonutProgress donutProgress5;
        private DonutProgress donutProgress6;
        private DonutProgress donutProgress7;
        private DonutProgress donutProgress8;
        private DonutProgress donutProgress9;
        private DonutProgress donutProgress10;
        private TextView milestone_level;
        private TextView milestone_hours_complete;
        private TextView Rank1;
        private TextView Rank2;
        private TextView Rank3;
        private TextView Rank4;
        private TextView Rank5;
        private TextView Rank6;
        private TextView Rank7;
        private TextView Rank8;
        private TextView Rank9;
        private TextView Rank10;
        private ProgressBar progressBar;

        public ViewHolder(View v) {
            super(v);
            donutProgress1 = (DonutProgress) v.findViewById(R.id.donut_progress1);
            donutProgress2 = (DonutProgress) v.findViewById(R.id.donut_progress2);
            donutProgress3 = (DonutProgress) v.findViewById(R.id.donut_progress3);
            donutProgress4 = (DonutProgress) v.findViewById(R.id.donut_progress4);
            donutProgress5 = (DonutProgress) v.findViewById(R.id.donut_progress5);
            donutProgress6 = (DonutProgress) v.findViewById(R.id.donut_progress6);
            donutProgress7 = (DonutProgress) v.findViewById(R.id.donut_progress7);
            donutProgress8 = (DonutProgress) v.findViewById(R.id.donut_progress8);
            donutProgress9 = (DonutProgress) v.findViewById(R.id.donut_progress9);
            donutProgress10 = (DonutProgress) v.findViewById(R.id.donut_progress10);
            milestone_level = (TextView) v.findViewById(R.id.level_milestone);
            milestone_hours_complete = (TextView) v.findViewById(R.id.completed_hours_text);
            Rank1 = (TextView) v.findViewById(R.id.rank1);
            Rank2 = (TextView) v.findViewById(R.id.rank2);
            Rank3 = (TextView) v.findViewById(R.id.rank3);
            Rank4 = (TextView) v.findViewById(R.id.rank4);
            Rank5 = (TextView) v.findViewById(R.id.rank5);
            Rank6 = (TextView) v.findViewById(R.id.rank6);
            Rank7 = (TextView) v.findViewById(R.id.rank7);
            Rank8 = (TextView) v.findViewById(R.id.rank8);
            Rank9 = (TextView) v.findViewById(R.id.rank9);
            Rank10 = (TextView) v.findViewById(R.id.rank10);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Milestone_adapter(ArrayList<Milestone_Collection> SET_of_milestoneCollections) {
        this.SET_of_milestoneCollections = SET_of_milestoneCollections;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Milestone_adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.milestone_card_alt, parent, false);
        // set the view's size, margins, paddings and layout parameters


        Milestone_adapter.ViewHolder vh = new Milestone_adapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(Milestone_adapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Milestone_Collection milestone_collection = SET_of_milestoneCollections.get(position);
        int current_time, min_time, fill_time;
        current_time = milestone_collection.getMilestones_set().get(0).getCurrent_time();
        holder.milestone_level.setText( milestone_collection.getLevel());



        int[] progress_percents;
        int[] fill_time_totals;

        if (milestone_collection.size() == 10){
            progress_percents = new int[10];
            fill_time_totals = new int[10];


            holder.milestone_hours_complete.setText(Integer.toString(current_time / 3600) + " / "
                    + Integer.toString(milestone_collection.getMilestones_set().get(9).getFill_time() / 3600)
                    + " Hours");

            //Determine progress percent for each Milestone object. store percents in array.
            for (int i = 0; i < 10; i++) {
                min_time = milestone_collection.getMilestones_set().get(i).get_min_time();
                fill_time = milestone_collection.getMilestones_set().get(i).getFill_time();
                fill_time_totals[i] = fill_time;

                if (current_time >= fill_time){
                    progress_percents[i] = 100;
                }
                else {
                    progress_percents[i] = (int)(((double) (current_time) / (double) fill_time) * 100);
                }
            }

            //change parameters for needed circles. NEEDED THOUGH IT SEEMS LIKE ITS NOT
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.donutProgress1.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress1.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress2.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress2.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress3.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress3.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress4.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress4.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress5.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress5.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress6.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress6.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress7.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress7.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress8.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress8.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress9.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress9.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress10.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress10.setLayoutParams(lp);

            //set percents/progress for each milestone
            holder.donutProgress1.setProgress(progress_percents[0]);
            holder.donutProgress2.setProgress(progress_percents[1]);
            holder.donutProgress3.setProgress(progress_percents[2]);
            holder.donutProgress4.setProgress(progress_percents[3]);
            holder.donutProgress5.setProgress(progress_percents[4]);
            holder.donutProgress6.setProgress(progress_percents[5]);
            holder.donutProgress7.setProgress(progress_percents[6]);
            holder.donutProgress8.setProgress(progress_percents[7]);
            holder.donutProgress9.setProgress(progress_percents[8]);
            holder.donutProgress10.setProgress(progress_percents[9]);

            //set rank name- hours
            holder.Rank1.setText("Rank I - " + Integer.toString(fill_time_totals[0] / 3600) + " Hours");
            holder.Rank2.setText("Rank II - " + Integer.toString(fill_time_totals[1] / 3600) + " Hours");
            holder.Rank3.setText("Rank III - " + Integer.toString(fill_time_totals[2] / 3600) + " Hours");
            holder.Rank4.setText("Rank IV - " + Integer.toString(fill_time_totals[3] / 3600) + " Hours");
            holder.Rank5.setText("Rank V - " + Integer.toString(fill_time_totals[4] / 3600) + " Hours");
            holder.Rank6.setText("Rank VI - " + Integer.toString(fill_time_totals[5] / 3600) + " Hours");
            holder.Rank7.setText("Rank VII - " + Integer.toString(fill_time_totals[6] / 3600) + " Hours");
            holder.Rank8.setText("Rank VIII - " + Integer.toString(fill_time_totals[7] / 3600) + " Hours");
            holder.Rank9.setText("Rank IX - " + Integer.toString(fill_time_totals[8] / 3600) + " Hours");
            holder.Rank10.setText("Rank X - " + Integer.toString(fill_time_totals[9] / 3600) + " Hours");

            //set progressbar
            if (current_time >= fill_time_totals[9]){
                holder.progressBar.setProgress(100);
            }
            else {
                holder.progressBar.setProgress((int)(((double) (current_time) / (double) (fill_time_totals[9])) * 100));
            }

        }
        else if(milestone_collection.size() == 5){

            progress_percents = new int[5];
            fill_time_totals = new int[5];
            holder.milestone_hours_complete.setText(Integer.toString(current_time / 3600) + " / "
                    + Integer.toString(milestone_collection.getMilestones_set().get(4).getFill_time() / 3600)
                    + " Hours");

            //Determine progress percent for each Milestone object. store percents in array.
            for (int i = 0; i < 5; i++) {
                current_time = milestone_collection.getMilestones_set().get(i).getCurrent_time();
                min_time = milestone_collection.getMilestones_set().get(i).get_min_time();
                fill_time = milestone_collection.getMilestones_set().get(i).getFill_time();
                fill_time_totals[i] = fill_time;

                if (current_time < min_time)
                    progress_percents[i] = 0;
                else if (current_time >= fill_time)
                    progress_percents[i] = 100;
                else {
                    progress_percents[i] = (int)(((double) (current_time) / (double) (fill_time)) * 100);
                }
            }
            //change parameters for needed circles. NEEDED THOUGH IT SEEMS LIKE ITS NOT
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.donutProgress1.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress1.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress2.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress2.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress3.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress3.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress4.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress4.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress5.getLayoutParams();
            lp.width = 210;
            lp.height = 210;
            holder.donutProgress5.setLayoutParams(lp);

            //set percents/progress for each milestone
            holder.donutProgress1.setProgress(progress_percents[0]);
            holder.donutProgress2.setProgress(progress_percents[1]);
            holder.donutProgress3.setProgress(progress_percents[2]);
            holder.donutProgress4.setProgress(progress_percents[3]);
            holder.donutProgress5.setProgress(progress_percents[4]);

            //change parameters to 0 for non needed progress circles
            lp = (LinearLayout.LayoutParams) holder.donutProgress6.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress6.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress7.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress7.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress8.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress8.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress9.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress9.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress10.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress10.setLayoutParams(lp);



            //set appropriate text for text views
            holder.Rank1.setText("Rank I - " + Integer.toString(fill_time_totals[0] / 3600) + " Hours");
            holder.Rank2.setText("Rank II - " + Integer.toString(fill_time_totals[1] / 3600) + " Hours");
            holder.Rank3.setText("Rank III - " + Integer.toString(fill_time_totals[2] / 3600) + " Hours");
            holder.Rank4.setText("Rank IV - " + Integer.toString(fill_time_totals[3] / 3600) + " Hours");
            holder.Rank5.setText("Rank V - " + Integer.toString(fill_time_totals[4] / 3600) + " Hours");
            holder.Rank6.setText("");
            holder.Rank7.setText("");
            holder.Rank8.setText("");
            holder.Rank9.setText("");
            holder.Rank10.setText("");

            //set progressbar
            if (current_time >= fill_time_totals[4]){
                holder.progressBar.setProgress(100);
            }
            else {
                holder.progressBar.setProgress((int)(((double) (current_time) / (double) (fill_time_totals[4])) * 100));
            }

        }
        else if(milestone_collection.size() == 1) {

            int progress;
            holder.milestone_hours_complete.setText(Integer.toString(current_time / 3600) + " / "
                    + Integer.toString(milestone_collection.getMilestones_set().get(0).getFill_time() / 3600)
                    + " Hours");
            //Determine progress percent for each Milestone object. store percents in array.
            current_time = milestone_collection.getMilestones_set().get(0).getCurrent_time();
            min_time = milestone_collection.getMilestones_set().get(0).get_min_time();
            fill_time = milestone_collection.getMilestones_set().get(0).getFill_time();

            if (current_time >= fill_time)
                progress = 100;
            else {
                progress = (int)(((double) (current_time) / (double) fill_time) * 100);
            }

            //set percents/progress for each milestone
            holder.donutProgress1.setProgress(progress);

            //change parameters to 0 for non needed progress circles
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.donutProgress2.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress2.setLayoutParams(lp);


            lp = (LinearLayout.LayoutParams) holder.donutProgress3.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress3.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress4.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress8.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress4.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress9.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress5.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress5.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress6.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress6.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress7.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress7.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress8.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress8.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress9.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress9.setLayoutParams(lp);

            lp = (LinearLayout.LayoutParams) holder.donutProgress10.getLayoutParams();
            lp.width = 0;
            lp.height = 0;
            holder.donutProgress10.setLayoutParams(lp);

            //Set Appropriate text for textviews
            holder.Rank1.setText("Rank I - " + Integer.toString(fill_time / 3600)  + " Hours");
            holder.Rank2.setText("");
            holder.Rank2.setText("");
            holder.Rank3.setText("");
            holder.Rank4.setText("");
            holder.Rank5.setText("");
            holder.Rank6.setText("");
            holder.Rank7.setText("");
            holder.Rank8.setText("");
            holder.Rank9.setText("");
            holder.Rank10.setText("");

            //set progressbar
            if (current_time >= fill_time){
                holder.progressBar.setProgress(100);
            }
            else {
                holder.progressBar.setProgress((int)(((double) (current_time) / (double) (fill_time)) * 100));
            }

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return SET_of_milestoneCollections.size();
    }
}