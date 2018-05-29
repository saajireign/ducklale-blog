package com.ducklale.user.domain.service.impl;

import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.user.domain.dao.RelUserAchievementDao;
import com.ducklale.user.domain.dto.RelUserAchievementDTO;
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

    @Transactional
    @Override
    public void insertBatch(List<RelUserAchievementDTO> dtos){
        int batchSize = 1000;
        int nowSize = 0;
        if(dtos!=null){
            List<RelUserAchievementPO> dtoInsert = new ArrayList<>();
            Iterator<RelUserAchievementDTO> iterDto = dtos.iterator();
            while(iterDto.hasNext()){
                if(nowSize==batchSize){
                    dao.insertBatch(dtoInsert);
                    dtoInsert = new ArrayList<>();
                    nowSize = 0;
                }
                dtoInsert.add(fromDto(iterDto.next()));
                nowSize++;
            }
            if(dtoInsert!=null && !dtoInsert.isEmpty()){
                dao.insertBatch(dtoInsert);
            }
        }
    }
}
