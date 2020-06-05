package com.example.springboot.entity.system;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "testdb")//表明这是一个文档对象，名称为user，对应Mongo DB里的user表
//如果对象中的某个属性为非表字段，可以使用注解@Transient进行排除。
public class MongodbUser {
    @Id//标注主键字段，String类型的主键值在插入的时候Mongo DB会帮我们自动生成
    private String id;
    private String name;
    private Integer age;
    private String description;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("description", description)
                .toString();
    }
}
