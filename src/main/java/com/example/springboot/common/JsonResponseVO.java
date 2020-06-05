package com.example.springboot.common;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static com.example.springboot.constant.Constant.MSG_SUCCESS;

@Getter
@Setter
public final class JsonResponseVO implements Serializable {
    private boolean success = true;
    private String msg = MSG_SUCCESS;

    public JsonResponseVO(boolean success) {
        this.success = success;
    }

    public JsonResponseVO(String msg) {
        this.msg = msg;
    }


    public JsonResponseVO() {
    }

    public JsonResponseVO(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResponseVO setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public JsonResponseVO setMsg(String msg) {
        this.msg = msg;
        return this;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("success", success)
                .add("msg", msg)
                .toString();
    }
}
