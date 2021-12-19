package com.demo.cglib;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.Map;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/16 16:14
 */
public class ReflectUtil {

    public static Object getObject(Object dest, Map<String, Object> addProperties) {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class> propertyMap = Maps.newHashMap();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        addProperties.forEach((k, v) -> {
            String sclass = v.getClass().toString();
            if(sclass.equals("class java.util.Date")) {//对日期进行处理
                propertyMap.put(k, Long.class);
            }else {
                propertyMap.put(k, v.getClass());
            }

        });
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        propertyMap.forEach((k, v) -> {
            try {
                if (!addProperties.containsKey(k)) {
                    dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(dest, k));
                }
            } catch (Exception e) {


//                log.error("动态添加字段出错", e);
            }
        });
        addProperties.forEach((k, v) -> {
            try {
                String sclass = v.getClass().toString();
                if(sclass.equals("class java.util.Date")) {//动态添加的字段为date类型需要进行处理
                    Date date = (Date) v;
                    dynamicBean.setValue(k, date.getTime());
                }else {
                    dynamicBean.setValue(k, v);
                }
            } catch (Exception e) {
  //              logger.error("动态添加字段值出错", e);
            }
        });
        Object obj = dynamicBean.getTarget();
        return obj;
    }
}
