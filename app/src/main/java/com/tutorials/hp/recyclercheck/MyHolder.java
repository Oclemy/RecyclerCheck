package com.tutorials.hp.recyclercheck;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hp on 3/21/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView nameTxt,posTxt;
    CheckBox chk;

    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        posTxt= (TextView) itemView.findViewById(R.id.posTxt);
        img= (ImageView) itemView.findViewById(R.id.playerImage);
        chk= (CheckBox) itemView.findViewById(R.id.chk);

        chk.setOnClickListener(this);

    }


    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
}
