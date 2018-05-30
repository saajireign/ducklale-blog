package com.ducklale.domain.service.impl;

import com.ducklale.domain.converter.DucklaleConvertI;
import com.ducklale.domain.converter.impl.BeanCopyConverter;
import com.ducklale.domain.converter.impl.BeanCopyConverterFactory;
import com.ducklale.domain.dao.DucklaleDaoI;
import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.utils.ReflectUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    }
    @Transactional
    @Override
    public Boolean insertBatch(List<D> dtos){
        int batchSize = 1000;
        int nowSize = 0;
        Boolean flag = true;
        if(dtos!=null){
            List<P> dtoInsert = new ArrayList<>();
            Iterator<D> iterDto = dtos.iterator();
            while(iterDto.hasNext()){
                if(nowSize==batchSize){
                    try {
                        getDao().insertBatch(dtoInsert);
                    }catch(Exception ex){
                        ex.printStackTrace();
                        flag = false;
                    }
                    dtoInsert = new ArrayList<>();
                    nowSize = 0;
                }
                dtoInsert.add(fromDto(iterDto.next()));
                nowSize++;
            }
            if(dtoInsert!=null && !dtoInsert.isEmpty()){
                try {
                    getDao().insertBatch(dtoInsert);
                }catch(Exception ex){
                    ex.printStackTrace();
                    flag = false;
                }
            }
        }
        return flag;
    }
}
