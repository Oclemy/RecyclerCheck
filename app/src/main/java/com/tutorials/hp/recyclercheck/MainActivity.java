package com.tutorials.hp.recyclercheck;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.SupportActionModeWrapper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    StringBuffer sb=null;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter=new MyAdapter(this,getPlayers());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb=new StringBuffer();

                for(Player p : adapter.checkedPlayers)
                {
                    sb.append(p.getName());
                    sb.append("\n");
                }

                if(adapter.checkedPlayers.size()>0)
                {
                    Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this,"Please Check Players",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //RECYCLER
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //SET ADAPTER
        rv.setAdapter(adapter);


    }

    private ArrayList<Player> getPlayers() {
        ArrayList<Player> players=new ArrayList<>();
        Player p=new Player("John Doe","Striker",R.drawable.herera);
        players.add(p);

        p=new Player("Roy Keane","Midfielder",R.drawable.carrick);
        players.add(p);


        p=new Player("JJ Abram","Midfielder",R.drawable.degea);
        players.add(p);


        p=new Player("John Mo","Defender",R.drawable.oscar);
        players.add(p);

        p=new Player("Jerry Joe","Midfielder",R.drawable.mata);
        players.add(p);

        p=new Player("J.S Ajira","Defender",R.drawable.costa);
        players.add(p);


        return players;
    }


}
