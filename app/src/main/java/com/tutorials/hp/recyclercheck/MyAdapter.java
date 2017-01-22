package com.tutorials.hp.recyclercheck;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by Hp on 3/21/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Player> players;
    ArrayList<Player> checkedPlayers=new ArrayList<>();

    public MyAdapter(Context c, ArrayList<Player> players) {
        this.c = c;
        this.players = players;
    }

    //VIEWHOLDER IS INITIALIZED
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    //DATA IS BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(players.get(position).getName());
        holder.posTxt.setText(players.get(position).getPosition());
        holder.img.setImageResource(players.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox chk= (CheckBox) v;

                //CKE IF ITS CHECKED OR NOT
                if(chk.isChecked())
                {
                    checkedPlayers.add(players.get(pos));
                }else  if(!chk.isChecked())
                {
                     checkedPlayers.remove(players.get(pos));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
