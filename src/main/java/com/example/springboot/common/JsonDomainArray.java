package com.example.springboot.common;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static com.example.springboot.constant.Constant.MSG_SUCCESS;
import static com.example.springboot.constant.Constant.NUM_ZERO;

@Getter
@Setter
public final class JsonDomainArray<T> implements Serializable {

    private int code = NUM_ZERO;
    private String msg = MSG_SUCCESS;
    private int count = NUM_ZERO;
    private List<T> data = Lists.newArrayList();

    public JsonDomainArray() {
    }

    public JsonDomainArray(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public JsonDomainArray<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public JsonDomainArray<T> setCount(int count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("msg", msg)
                .add("count", count)
                .add("data", data)
                .toString();
    }
}
