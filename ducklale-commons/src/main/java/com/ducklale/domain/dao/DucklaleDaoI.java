package com.ducklale.domain.dao;

import java.util.List;

public interface DucklaleDaoI<P,PK> {
    P selectById(PK id) throws Exception;
    int deleteById(String ids) throws Exception;
    int insert(P p) throws Exception;
    int updateById(P p) throws Exception;
    void insertBatch(List<P> pos)throws Exception;
}
