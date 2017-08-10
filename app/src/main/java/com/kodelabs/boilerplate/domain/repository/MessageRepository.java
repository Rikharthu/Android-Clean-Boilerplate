package com.kodelabs.boilerplate.domain.repository;

import com.kodelabs.boilerplate.domain.model.Message;

public interface MessageRepository {
    boolean insert(Message model);

    boolean update(Message model);

    Message get(long id);

    boolean delete(Message model);
}
