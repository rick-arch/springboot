package com.example.springboot.repository;

import java.util.List;

public interface BaseRepository<T> {

	Integer insert(T t);

	Integer delete(String id);

	Integer deleteInBatch(String... idArray);

	Integer update(T t);

	List<T> selectAll(T t);

	T getOne(String id);

	Integer count(T t);

	Integer disable(Integer... idArray);

	Integer enable(Integer id);

}
