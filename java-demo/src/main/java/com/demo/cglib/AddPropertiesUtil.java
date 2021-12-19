package com.demo.cglib;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;


import java.beans.PropertyDescriptor;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AddPropertiesUtil {

//    private static Logger logger = LoggerFactory.getLogger(AddPropertiesUtil.class);

    /**
     * 动态为对象增加属性
     *
     * @param dest            要增加属性的对象
     * @param addProperties   要增加的属性名及值，属性名可以和原有属性重名，但如果重名的话，值的类型必须一致，否则抛异常
     * @param discardOldValue 是否舍弃原有属性的值，如果true，则原有属性的值将都被置为默认值
     * @return 返回增加了属性的新对象
     */
    public static Object addProperties(Object dest, Map<String, Object> addProperties, boolean discardOldValue) {
        Map<String, Class> propertyMap = new HashMap<>();

        PropertyUtilsBean utilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = utilsBean.getPropertyDescriptors(dest);

        for (PropertyDescriptor desc : descriptors) {
            if (!"class".equalsIgnoreCase(desc.getName())) {
                propertyMap.put(desc.getName(), desc.getPropertyType());
            }
        }

        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));

        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);

        // 添加旧属性值
        if (!discardOldValue) {
            propertyMap.forEach((k, v) -> {
                try {
                    if (!addProperties.containsKey(k)) {
                        dynamicBean.setValue(k, utilsBean.getNestedProperty(dest, k));
                    }
                } catch (Exception e) {
                    throw new RuntimeException("对象添加旧属性失败，" + e.getMessage());
                }
            });
        }

        // 添加新属性值
        addProperties.forEach((k, v) -> {
            try {
                dynamicBean.setValue(k, v);
            } catch (Exception e) {
                throw new RuntimeException("对象添加新属性失败，" + e.getMessage());
            }
        });

        return dynamicBean.getTarget();
    }

    public static class DynamicBean {
        /**
         * 目标对象
         */
        private Object target;

        /**
         * 属性集合
         */
        private BeanMap beanMap;

        public DynamicBean(Class superClass, Map<String, Class> propertyMap) {
            this.target = generateBean(superClass, propertyMap);
            this.beanMap = BeanMap.create(this.target);
        }

        /**
         * 添加属性和值
         */
        public void setValue(String property, Object value) {
            beanMap.put(property, value);
        }

        /**
         * 获取属性值
         */
        public Object getValue(String property) {
            return beanMap.get(property);
        }

        /**
         * 获取对象
         */
        public Object getTarget() {
            return this.target;
        }

        /**
         * 根据属性生成对象
         */
        private Object generateBean(Class superClass, Map<String, Class> propertyMap) {
            BeanGenerator generator = new BeanGenerator();
            if (superClass != null) {
                generator.setSuperclass(superClass);
            }
            BeanGenerator.addProperties(generator, propertyMap);
            return generator.create();
        }
    }

    public static void main(String[] args) {

        User user = new User();
//        user.setName("Daisy");
//        System.out.println("User："+ JSON.toJSONString(user));
        Map<String,Object> propertiesMap = new HashMap<String,Object>();
        propertiesMap.put("age1", "12");
        propertiesMap.put("age2", "12");
        propertiesMap.put("age3", "12");

        Object obj = AddPropertiesUtil.addProperties(user, propertiesMap, false);
//        System.out.println(o);

        String  fileName = "D:\\study\\project\\easyexcel\\target\\test-classes\\demo\\demo.xlsx";

        EasyExcel.read(fileName, obj.getClass(), new DemoDataListener()).sheet().doRead();

    }
}