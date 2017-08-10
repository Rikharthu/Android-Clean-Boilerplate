package com.kodelabs.boilerplate.storage.converters;


import com.kodelabs.boilerplate.storage.model.Message;

/**
 * Converts models between layers, such as {@link com.kodelabs.boilerplate.domain.model.Message}
 * to {@link com.kodelabs.boilerplate.storage.model.Message} and vice-versa
 */
public class StorageModelConverter {

    /**
     * Storage to Domain
     */
    public static com.kodelabs.boilerplate.domain.model.Message convertToDomainModel(Message message) {
        return new com.kodelabs.boilerplate.domain.model.Message(
                message.getId(), message.getDate(), message.getTitle(), message.getText(), message.getRecipient(), message.getSender());
    }

    public static Message convertToStorageModel(com.kodelabs.boilerplate.domain.model.Message message) {
        Message result = new Message();
        result.setId(message.getId());
        result.setDate(message.getDate());
        result.setRecipient(message.getRecipient());
        result.setSender(message.getSender());
        result.setText(message.getText());
        result.setTitle(message.getTitle());

        return result;
    }
}
