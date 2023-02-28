package com.example.employeemanagement.generics;

import java.util.List;

public interface ServiceInterface<T> {


    T addEntity(T entity);
    T updateEntity(Long id, T newEntity);
    List<T> findAllEntity();
    T findEntityById(Long id);
    void deleteById(Long id);




}
