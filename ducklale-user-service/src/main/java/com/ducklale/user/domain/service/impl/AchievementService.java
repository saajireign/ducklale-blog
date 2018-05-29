package com.ducklale.user.domain.service.impl;

import com.ducklale.domain.Pagination;
import com.ducklale.domain.Query;
import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.user.domain.dao.AchievementDao;
import com.ducklale.user.domain.dto.AchievementDTO;
import com.ducklale.user.domain.entity.AchievementPO;
import com.ducklale.user.domain.query.AchievementQuery;
import com.ducklale.user.domain.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService extends DucklaleService<AchievementDTO,AchievementPO,Integer> implements IAchievementService {
    @Autowired
    AchievementDao achievementDao;
    public AchievementDao getDao(){
        return achievementDao;
    }
    public Pagination<AchievementDTO> pageAchievementByQuery(AchievementQuery query){
        query.calcOffsetAndLimit();
        Integer count = achievementDao.queryPageCount(query);
        List<AchievementPO> achievements = achievementDao.queryPage(query);
        List<AchievementDTO> dtos = toDtoList(achievements);
        Pagination<AchievementDTO> page = new Pagination<>();
        page.setTotalPages(count);
        page.setPageSize(query.getPageSize());
        page.setPageNo(query.getPageNo());
        page.setRecords(dtos);
        return page;
    }
    public List<AchievementDTO> getUserAchievements(Long userId){
        return toDtoList(achievementDao.getUserAchievements(userId));
    }

}
