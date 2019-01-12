package com.codingblocks.masterdetail;

import android.content.Context;

import java.io.Serializable;

public class Note implements Serializable {

    private String title,subtitle;

    public Note(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
