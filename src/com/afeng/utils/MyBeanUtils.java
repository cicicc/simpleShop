package com.afeng.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

public class MyBeanUtils  {

    //增强BeanUtils中的populate方法 使用反射技术 所以传递过来的参数应该有一个是参与此反射的bean类
    public static <T> T populate(Class<T> beanClass, Map<String,String[]> properties){
        try {
            //获取反射类的实例对象
            T bean = beanClass.newInstance();
            //创建时间转换器
            DateConverter dateConverter = new DateConverter();
            //设置转换器所需要的格式
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"});
            //注册转换器
            ConvertUtils.register(dateConverter,java.util.Date.class);
            //上述代码的功能就是为了当传递对象过来时 此方法自动将内部的数据转换为了我们想要的数据
            BeanUtils.populate(bean,properties);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }

}
