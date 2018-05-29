package com.ducklale.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * use java reflect interface to transfer the array from kafka to java bean.
 * @author Reign.Gao
 *
 */
public class ReflectUtil {
	private ReflectUtil(){
		
	}

	public static Object getter(Object obj,String attr){
		Method met;
		try {
			met = obj.getClass().getMethod("get" + initStr(attr));
			return met.invoke(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param obj object to be invoked setting concrete values in this object
	 * @param att the method name after the word "set",whose first word would be uppercase
	 * @param value the value to be setted
	 * @param type the type of the setting field.
	 */
	public static void setter(Object obj, String att, String value, Class<?> type) {
		try {
			Method met = obj.getClass().getMethod("set" + initStr(att), type);
			met.invoke(obj, getObjectByString(type,value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Object getObjectByString(Class<?> type, String value) {
		if( value==null || value.trim().equals("") || value.trim().equalsIgnoreCase("null")){
			return null;
		}
		Object obj = null;
		try {
			Constructor<?> constrct = type.getConstructor(String.class);
			obj = constrct.newInstance(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public static String initStr(String oldString) {
		String newString = oldString.substring(0, 1).toUpperCase()
				+ oldString.substring(1);
		return newString;
	}
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}

		return (Class) params[index];
	}
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}
}
