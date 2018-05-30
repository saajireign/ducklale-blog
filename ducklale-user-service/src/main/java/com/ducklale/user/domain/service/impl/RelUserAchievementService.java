package com.ducklale.user.domain.service.impl;

import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.user.api.dto.RelUserAchievementDTO;
import com.ducklale.user.domain.dao.RelUserAchievementDao;
import com.ducklale.user.domain.entity.RelUserAchievementPO;
import com.ducklale.user.domain.service.IRelUserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class RelUserAchievementService extends DucklaleService<RelUserAchievementDTO,RelUserAchievementPO,Long> implements IRelUserAchievementService{
    @Autowired
    RelUserAchievementDao dao;

    @Override
    public RelUserAchievementDao getDao() {
        return dao;
    }


    public List<RelUserAchievementDTO> getByUserId(Long userId){
        return toDtoList(dao.selectByUserId(userId));
    }
}
