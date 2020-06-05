package com.example.springboot.common;

import java.util.HashMap;
import java.util.Map;

import static com.example.springboot.constant.Constant.*;

public final class ResponseBo extends HashMap<String, Object> {
    private static final long serialVersionUID = LONG1L;

    public ResponseBo() {
        put(CODE, NUM_ZERO);
        put(MSG, MSG_SUCCESS);
    }

    public static ResponseBo error() {
        return error(NUM_ONE, MSG_FAIL);
    }

    public static ResponseBo error(String msg) {
        return error(NUM_FIVE_HUNDRED, msg);
    }

    public static ResponseBo error(int code, String msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put(CODE, code);
        responseBo.put(MSG, msg);
        return responseBo;
    }

    public static ResponseBo ok(String msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put(MSG, msg);
        return responseBo;
    }

    public static ResponseBo ok(Map<String, Object> map) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.putAll(map);
        return responseBo;
    }

    public static ResponseBo ok() {
        return new ResponseBo();
    }

    @Override
    public ResponseBo put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
