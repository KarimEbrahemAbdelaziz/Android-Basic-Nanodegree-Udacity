package com.example.pc.booklistingapp;

/**
 * Created by PC on 12/06/2017.
 */

public class Book {
    private String mBookTitle;
    private String[] mBookAuthors;
    private String mBookDescription;
    private String mBookInfoLink;

    public Book(String bookTitle, String[] bookAuthors, String bookDescription, String bookInfoLink) {
        mBookTitle = bookTitle;
        mBookAuthors = bookAuthors;
        mBookDescription = bookDescription;
        mBookInfoLink = bookInfoLink;
    }

    public String getBookTitle() {
        return mBookTitle;
    }

    public String[] getAuthors() {
        return mBookAuthors;
    }

    public String getStringAuthors() {
        String sAuthors = "";
        for(int i=0;i<mBookAuthors.length;i++) {
            if(i == mBookAuthors.length-1)
                sAuthors += mBookAuthors[i];
            else
                sAuthors += mBookAuthors[i] + ", ";
        }
        return sAuthors;
    }

    public String getBookDescription() {
        return mBookDescription;
    }

    public String getBookInfoLink() {
        return mBookInfoLink;
    }
}

