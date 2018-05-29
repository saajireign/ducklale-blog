package com.ducklale.domain.service.impl;

import com.ducklale.domain.converter.DucklaleConvertI;
import com.ducklale.domain.converter.impl.BeanCopyConverter;
import com.ducklale.domain.converter.impl.BeanCopyConverterFactory;
import com.ducklale.domain.dao.DucklaleDaoI;
import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.utils.ReflectUtil;

public abstract class DucklaleService<D,P,PK> extends BeanCopyConverter<D,P> implements DucklaleServiceI<D,PK> {

    protected abstract DucklaleDaoI<P,PK> getDao();
     public D getById(PK id) {
         D d = null;
         try {
             P p = getDao().selectById(id);
             return toDto(p);
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
    }

    public int deleteById(PK id) {
         try {
             return this.getDao().deleteById(id.toString());
         }catch(Exception e){
             e.printStackTrace();
         }
         return -1;
     };
    public int insert(D p) {
        if(p==null){
            return -1;
        }
        try{
            return this.getDao().insert(fromDto(p));
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public int updateById(D p){
        if(p==null){
            return -1;
        }
        try{
            return this.getDao().updateById(fromDto(p));
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    };

}
