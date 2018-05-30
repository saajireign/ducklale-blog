package com.ducklale.domain.service;

import com.ducklale.domain.dao.DucklaleDaoI;

import java.util.List;

public interface DucklaleServiceI<D,PK> {
    D getById(PK id) ;
    int deleteById(PK id) ;
    int insert(D p) ;
    int updateById(D p) ;
    Boolean insertBatch(List<D> dtos);
}
