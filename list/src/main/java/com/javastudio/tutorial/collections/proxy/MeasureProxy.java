package com.javastudio.tutorial.collections.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MeasureProxy implements InvocationHandler {

    final Object object;

    public MeasureProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
