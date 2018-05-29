package com.ducklale.domain.converter.impl;

import com.ducklale.domain.converter.ConvertI;
import com.ducklale.domain.converter.DucklaleConvertI;
import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.utils.ReflectUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class BeanCopyConverterFactory {
    private Map<String,ConvertI> converterCache = new HashMap<String,ConvertI>();
    private Object lock = new Object();
    private BeanCopyConverterFactory(){

    }

    public  <E> E getConverter(Class d,Class p){
        String key = buildK(d,p);
        if(converterCache.containsKey(key)){
            return (E) converterCache.get(key);
        }
        synchronized (lock){
            if(!converterCache.containsKey(key)){
                ConvertI converter = new BeanCopyConverter();
                converterCache.put(key,  converter);
            }
        }

        return (E)converterCache.get(key);
    }

  /*  public <D,P> DucklaleConvertI<D,P> getConverterWith2GenericTypes(Object o){
        Class d = o.getClass();
        Class className0 = ReflectUtil.getSuperClassGenricType(d.getClass(),0);
        Class className1 = ReflectUtil.getSuperClassGenricType(d.getClass(),1);
        String key = buildK(className0,className1);
        return getConverterByKey(key);
    }*/
   /* protected <D,P> DucklaleConvertI<D,P> getConverterByKey(String key,Class d,Class p){
        if(converterCache.containsKey(key)){
            return (DucklaleConvertI<D, P>) converterCache.get(key);
        }
        synchronized (lock){
            if(!converterCache.containsKey(key)){
                converterCache.put(key,new BeanCopyConverter<D,P>());
            }
        }

        return (DucklaleConvertI<D, P>) converterCache.get(key);
    }*/
    private String buildK(Class d,Class p){
        String key = d.getName()+"_"+p.getName();
        return key;
    }
    public static BeanCopyConverterFactory getInstance(){
        return FactoryClassSub.INSTANCE;
    }
    private static class FactoryClassSub{
        private static final BeanCopyConverterFactory INSTANCE = new BeanCopyConverterFactory();
    }
}
