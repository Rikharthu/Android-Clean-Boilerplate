package com.kodelabs.boilerplate.storage.model;

import java.util.Date;

// Similar to domain/model, but has database-specific fields not used by business object (for implementation purposes)
public class Message {
    private long mId;
    private Date mDate;
    private String mText;
    private String mRecipient;
    private String mSender;
    private String mTitle;

    // custom fields for database/implementation logic
    private boolean mIsSynced;
    private Date mLastUpdatedAt;
    private Date mCreatedAt;

    public Message() {
    }

    public Message(long id, Date date, String title, String text, String recipient, String sender, boolean isSynced, Date lastUpdatedAt, Date createdAt) {
        mId = id;
        mDate = date;
        mText = text;
        mRecipient = recipient;
        mSender = sender;
        mTitle = title;
        mIsSynced = isSynced;
        mLastUpdatedAt = lastUpdatedAt;
        mCreatedAt = createdAt;
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

    public boolean isSynced() {
        return mIsSynced;
    }

    public void setSynced(boolean synced) {
        mIsSynced = synced;
    }

    public Date getLastUpdatedAt() {
        return mLastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        mLastUpdatedAt = lastUpdatedAt;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }
}
