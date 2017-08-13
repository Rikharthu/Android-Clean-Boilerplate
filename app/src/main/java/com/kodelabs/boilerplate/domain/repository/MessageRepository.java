package com.kodelabs.boilerplate.domain.repository;

import com.kodelabs.boilerplate.domain.model.Message;

import java.util.List;

public interface MessageRepository extends Repository<Message> {

    List<Message> getAllMessage();
}
