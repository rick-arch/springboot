package com.example.springboot.repository;

import com.example.springboot.entity.system.MongodbUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongodbUserDao extends MongoRepository<MongodbUser, String> {

}
