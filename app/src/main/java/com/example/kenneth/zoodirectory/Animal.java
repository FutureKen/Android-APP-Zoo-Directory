package com.example.kenneth.zoodirectory;

/**
 * Created by Kenneth on 2/5/2016.
 */
public class Animal {
    private String name;
    private String filename;
    private String description;
    private Boolean fav;

    public Animal(String name, String filename, String description, Boolean fav) {
        this.name = name;
        this.filename = filename;
        this.description = description;
        this.fav = fav;
    }

    public String getName() { return name; }

    public String getFilename() {
        return filename;
    }

    public Boolean isFav() {
        return fav;
    }

    public void changeFav() {
        this.fav = !fav;
    }

    public String getDescription() {
        return description;
    }


}
