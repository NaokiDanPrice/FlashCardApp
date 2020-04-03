package com.example.flashcardapp.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashcardapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Tip> tips;
    private Context context;
    public CustomRecyclerViewAdapter(ArrayList<Tip> tips, Context context){
        this.tips = tips;
        this.context = context;

    }

    public static Tip t;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                      final int viewType) {
        //Make the view that we want each list item to look like
       final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tips_recycler, null);
        //tip that view inside the ViewHolder

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        //Return the custom ViewHolder



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,
                                 final int position) {
        Tip tip = tips.get(position);
        ((CustomViewHolder)holder).name.setText(tip.getName());
        ((CustomViewHolder)holder).description.setText(tip.getDescription());
        ((CustomViewHolder)holder).link.setText(tip.getlink());
        t = tip;
    }

    @Override
    public int getItemCount() {
        if(tips != null){
            return tips.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView name;
        protected ImageView picture;
        protected TextView description;
        protected TextView link;
        protected String info;

        public CustomViewHolder(View view){
            super(view);
            this.name = view.findViewById(R.id.name);
            this.picture = view.findViewById(R.id.picture);
            this.link = view.findViewById(R.id.link);

            this.description = view.findViewById(R.id.description);

            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info = link.getText().toString();
                    //Picks intent based on starting integer
                    Integer type = parseInt(info.substring(0, 1));
                    System.out.println(type);
                    info = info.substring(1, link.length()-1);
                    if(type == 1) {
                        System.out.println("in");
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:"));
                        intent.putExtra(Intent.EXTRA_EMAIL, info);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                        intent.putExtra(Intent.EXTRA_TEXT, "Tell Us What You Think");
                        if (intent.resolveActivity(context.getPackageManager()) != null) {
                            context.startActivity(intent);
                        }

                    }
                }
            });
            view.setOnClickListener(this);
        }
        public void onClick(View v) {

        }

    }


}
