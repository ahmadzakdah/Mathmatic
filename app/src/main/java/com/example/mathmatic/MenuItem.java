package com.example.mathmatic;

import androidx.annotation.NonNull;

public class MenuItem {
    private String name;
    private String category;

    public MenuItem(){}

    public MenuItem(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NonNull
    @Override
    public String toString() {
        String msg = getName();
        return msg;
    }
}
