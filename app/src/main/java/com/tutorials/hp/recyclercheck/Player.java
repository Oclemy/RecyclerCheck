package com.tutorials.hp.recyclercheck;

/**
 * Created by Hp on 3/21/2016.
 */
public class Player {
    private String name,position;
    private int image;

    public Player(String name, String position, int image) {
        this.name = name;
        this.position = position;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
