package com.example.springboot.service;

import com.example.springboot.entity.system.MongodbUser;
import com.example.springboot.repository.MongodbUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongodbUserService {

    @Autowired
    private MongodbUserDao mongodbUserDao;

    public List<MongodbUser> getUserList() {
        return mongodbUserDao.findAll();
    }

    public Optional<MongodbUser> getUserById(String id) {
        return mongodbUserDao.findById(id);
    }

    /**
     * 新增和修改都是save方法，
     * id存在为修改，不存在为新增
     *
     * @param sysUser
     */
    public MongodbUser createUser(MongodbUser sysUser) {
        sysUser.setId(null);
        return mongodbUserDao.save(sysUser);
    }

    public void deleteUser(String id) {
        mongodbUserDao.findById(id).ifPresent(sysUser -> mongodbUserDao.delete(sysUser));
    }

    public void updateUser(String id, MongodbUser sysUser) {
        mongodbUserDao.findById(id).
                ifPresent(
                        user -> {
                            user.setName(sysUser.getName());
                            user.setAge(sysUser.getAge());
                            user.setDescription(sysUser.getDescription());
                            mongodbUserDao.save(user);
                        }
                );
    }
}
