package com.ducklale.domain.dao;

public interface DucklaleDaoI<P,PK> {
    P selectById(PK id) throws Exception;
    int deleteById(String ids) throws Exception;
    int insert(P p) throws Exception;
    int updateById(P p) throws Exception;
}
