package com.ducklale.domain.converter.impl;

import com.ducklale.utils.ReflectUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BeanCopyConverter<D,O> extends Converter<D, O> {
	Class<D> entityClassD;
	Class<O> entityClassO;
	public BeanCopyConverter(Class d,Class p){
		if(entityClassD==null) {
//			entityClassD = ReflectUtil.getSuperClassGenricType(getClass(), 0);
			entityClassD = d;
		}
		if(entityClassO==null){
//			entityClassO = ReflectUtil.getSuperClassGenricType(getClass(),1);
			entityClassO = p;
		}
		System.out.println("starting copy creating");
	}

	public BeanCopyConverter(){
		if(entityClassD==null) {
			entityClassD = ReflectUtil.getSuperClassGenricType(getClass(), 0);
		}
		if(entityClassO==null){
			entityClassO = ReflectUtil.getSuperClassGenricType(getClass(),1);
		}
		System.out.println("starting copy creating");
	}
	@SuppressWarnings("unchecked")
	@Override
	public D toDto(O obj) {
		if(obj==null){
			return null;
		}

		D dto=null;
		try {
			dto = entityClassD.newInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		try {
			BeanUtils.copyProperties(dto, obj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public O fromDto(D obj) {
		if(obj==null){
			return null;
		}
		O dto=null;
		try {
			dto = entityClassO.newInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		try {
			BeanUtils.copyProperties(dto, obj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		} 
		return dto;
	}

}
