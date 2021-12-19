package com.demo.cglib;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/16 16:25
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        System.out.println("User："+ JSON.toJSONString(user));
        Map<String,Object> propertiesMap = new HashMap<String,Object>();
        propertiesMap.put("age", 18);
        Object obj = ReflectUtil.getObject(user, propertiesMap);
        System.out.println("动态为User添加age之后，User："+JSON.toJSONString(obj));



        // 动态创建bean
//        BeanGenerator generator = new BeanGenerator();
//        generator.addProperty("xxxId", Long.class);
//        generator.addProperty("xxxName", String.class);
//        generator.addProperty("xxxDescription", String.class);
//
//        Object obj = generator.create();
//        BeanMap beanMap = BeanMap.create(obj);
//        beanMap.put("xxxId", 2L);
//        beanMap.put("xxxName", "这是XXName");
//        beanMap.put("xxxDescription", "这是一个描述");
//        System.out.println(JSON.toJSONString(obj));
//        System.out.println("-----------------");
    }

}
