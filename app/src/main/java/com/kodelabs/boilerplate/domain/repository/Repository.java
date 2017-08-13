package com.kodelabs.boilerplate.domain.repository;

import com.kodelabs.boilerplate.domain.model.SampleModel;

/**
 * A sample repository with CRUD operations on a model.
 */
public interface Repository<T> {

    boolean insert(T model);

    boolean update(T model);

    T get(long id);

    boolean delete(T model);
}
