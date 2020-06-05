package com.example.springboot.entity.user;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserOnline implements Serializable {

    private String userId;

    private String id;

    private String username;

    private String status;

    private String chinaName;

    // session创建时间
    private String startTimestamp;

    // session最后访问时间
    private String lastAccessTime;

    // 用户主机地址
    private String host;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("id", id)
                .add("username", username)
                .add("status", status)
                .add("chinaName", chinaName)
                .add("startTimestamp", startTimestamp)
                .add("lastAccessTime", lastAccessTime)
                .add("host", host)
                .toString();
    }
}
