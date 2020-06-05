package com.example.springboot.entity.system;

import com.example.springboot.common.Page;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Getter
@Setter
public class SysLog extends Page implements Serializable {

    /**日志id*/
    private Integer id;

    /**操作人*/
    private String username;

    /**执行操作*/
    private String operation;

    /**执行时间*/
    private Integer time;

    /**执行方法*/
    private String method;

    /**方法参数*/
    private String params;

    /**ip地址*/
    private String ip;

    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    /**浏览器及版本*/
    private String browser;

    /**操作系统*/
    private String userSystem;

    /**请求路径 */
    private String requestUrl;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("operation", operation)
                .add("time", time)
                .add("method", method)
                .add("params", params)
                .add("ip", ip)
                .add("createTime", createTime)
                .add("browser", browser)
                .add("userSystem", userSystem)
                .add("requestUrl", requestUrl)
                .toString();
    }
}
