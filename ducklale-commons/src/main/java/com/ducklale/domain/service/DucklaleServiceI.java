package com.ducklale.domain.service;

import com.ducklale.domain.dao.DucklaleDaoI;

public interface DucklaleServiceI<D,PK> {
    D getById(PK id) ;
    int deleteById(PK id) ;
    int insert(D p) ;
    int updateById(D p) ;
}
