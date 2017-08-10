package com.kodelabs.boilerplate.domain.model;

import java.util.Date;

// Domain model
public class Message {

    private long mId;
    private Date mDate;
    private String mText;
    private String mRecipient;
    private String mSender;
    private String mTitle;

    public Message() {
    }

    public Message(long id, Date date, String title, String text, String recipient, String sender) {
        mId = id;
        mDate = date;
        mText = text;
        mRecipient = recipient;
        mSender = sender;
        mTitle = title;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getRecipient() {
        return mRecipient;
    }

    public void setRecipient(String recipient) {
        mRecipient = recipient;
    }

    public String getSender() {
        return mSender;
    }

    public void setSender(String sender) {
        mSender = sender;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
