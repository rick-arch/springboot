package com.example.springboot.controller.other;

import com.example.springboot.entity.system.MongodbUser;
import com.example.springboot.service.MongodbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mongodb/user")
public class MongodbUserController {

    @Autowired
    private MongodbUserService mongodbUserService;

    @GetMapping("/list")//localhost:8080/mongodb/user/list
    public List<MongodbUser> getUserList() {
        return mongodbUserService.getUserList();
    }

    @PostMapping("/createUser")//localhost:8080/mongodb/user/createUser?name=6666&age=20&description=这个人名字是666，年龄是20
    public MongodbUser createUser(MongodbUser sysUser) {
        return mongodbUserService.createUser(sysUser);
    }

    @DeleteMapping("/delete/{id}")//localhost:8080/mongodb/user/delete/5dd5e98eb436f16d339fe7e8
    public void deleteUser(@PathVariable String id) {
        mongodbUserService.deleteUser(id);
    }

    @GetMapping("/getUserById/{id}")//localhost:8080/mongodb/user/getUserById/5dd5e98eb436f16d339fe7e8
    public MongodbUser getUserById(@PathVariable String id) {
        return mongodbUserService.getUserById(id).orElse(null);
    }

    @PutMapping("/updateUser/{id}")
//localhost:8080/mongodb/user/updateUser/5dd5e98eb436f16d339fe7e8?name=777&age=21&description=这个人姓名777，年龄21
    public void updateUser(@PathVariable String id, MongodbUser user) {
        mongodbUserService.updateUser(id, user);
    }
}
