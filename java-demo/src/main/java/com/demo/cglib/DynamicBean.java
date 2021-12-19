package com.demo.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @author zys
 * @version 1.0.0
 * @date 2021/12/16 15:52
 */
public class DynamicBean {

        private Object target;
        private BeanMap beanMap;

        public DynamicBean(Class superclass, Map<String, Class> propertyMap) {
            this.target = generateBean(superclass, propertyMap);
            this.beanMap = BeanMap.create(this.target);
        }

        public void setValue(String property, Object value) {
            beanMap.put(property, value);
        }

        public Object getValue(String property) {
            return beanMap.get(property);
        }

        public Object getTarget() {
            return this.target;
        }
        /**
         * 根据属性生成对象
         *
         */
        private Object generateBean(Class superclass, Map<String, Class> propertyMap) {
            BeanGenerator generator = new BeanGenerator();
            if (null != superclass) {
                generator.setSuperclass(superclass);
            }
            BeanGenerator.addProperties(generator, propertyMap);
            return generator.create();
        }



}
