package com.example.springboot.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

import static com.example.springboot.constant.Constant.NUM_ZERO;

public class ShiroSession implements SessionListener {

    //原子类型的Integer对象，用于统计在线Session的数量。
    private final AtomicInteger sessionCount = new AtomicInteger(NUM_ZERO);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }
}
