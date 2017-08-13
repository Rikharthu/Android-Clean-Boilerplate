package com.kodelabs.boilerplate.storage;

import android.content.Context;

import com.kodelabs.boilerplate.domain.repository.MessageRepository;
import com.kodelabs.boilerplate.storage.converters.StorageModelConverter;
import com.kodelabs.boilerplate.storage.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Implementations lies here since MessageRepository interface is declared in an Inner/Core layer
// But implementation has Android-specific code. This is Outer layer (Storage)
public class MessageRepositoryImpl implements MessageRepository {

    private Context mContext;

    private List<Message> mData;

    {
        // Generate some dummy data
        mData = new ArrayList<>();
        try {
            for (int i = 0; i < 24; i++) {
                mData.add(new Message(i, new Date(), "Greetings!", "Hello, World!", "Vasja", "Anton", true, new Date(), new Date()));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            ;
        }
    }

    public MessageRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    public List<com.kodelabs.boilerplate.domain.model.Message> getAllMessage() {
        List<com.kodelabs.boilerplate.domain.model.Message> result = new ArrayList<>();
        for (Message message : mData) {
            result.add(StorageModelConverter.convertToDomainModel(message));
        }
        return result.isEmpty() ? null : result;
    }

    @Override
    public boolean insert(com.kodelabs.boilerplate.domain.model.Message model) {
        // check if id is not reused
        for (Message message : mData) {
            if (message.getId() == model.getId()) {
                return false;
            }
        }
        mData.add(StorageModelConverter.convertToStorageModel(model));
        return true;
    }

    @Override
    public boolean update(com.kodelabs.boilerplate.domain.model.Message model) {
        for (int i = 0; i < mData.size(); i++) {
            Message message = mData.get(i);
            if (message.getId() == model.getId()) {
                mData.set(i, StorageModelConverter.convertToStorageModel(model));
                return true;
            }
        }
        return false;
    }

    @Override
    public com.kodelabs.boilerplate.domain.model.Message get(long id) {
        for (Message message : mData) {
            if (message.getId() == id) {
                return StorageModelConverter.convertToDomainModel(message);
            }
        }
        return null;
    }

    @Override
    public boolean delete(com.kodelabs.boilerplate.domain.model.Message model) {
        for (int i = 0; i < mData.size(); i++) {
            Message message = mData.get(i);
            if (message.getId() == model.getId()) {
                mData.remove(i);
                return true;
            }
        }
        return false;
    }
}
