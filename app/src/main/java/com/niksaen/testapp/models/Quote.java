package com.niksaen.testapp.models;

import android.content.Intent;

import java.util.ArrayList;

public class Quote {
    String _id;
    public String getId() {return _id;}
    String content;
    public String getContent() {return content;}
    String author;
    public String getAuthor() {return author;}
    ArrayList<String> tags;
    public ArrayList<String> getTags() {return tags;}
    String authorSlug;
    public String getAuthorSlug() {return authorSlug;}
    Integer length;
    public Integer getLength() {return length;}
    String dataAdded;
    public String getDataAdded() {return dataAdded;}
    String dateModified;
    public String getDateModified() {return dateModified;}

    public Quote(String _id,
                 String content,
                 String author,
                 ArrayList<String> tags,
                 String authorSlug,
                 Integer length,
                 String dataAdded,
                 String dateModified)
    {
        this._id = _id;
        this.content = content;
        this.author = author;
        this.tags = tags;
        this.authorSlug = authorSlug;
        this.length = length;
        this.dataAdded = dataAdded;
        this.dateModified = dateModified;
    }
}
