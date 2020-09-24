package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;

public interface BaseService<T> {

	boolean add(T t);

	JsonDomainArray<T> getAll(T t);

	Boolean lock(Integer... arr);

	Boolean unlock(Integer id);
}
