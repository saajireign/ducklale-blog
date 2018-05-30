package com.ducklale.user.adapter;

import com.ducklale.domain.Pagination;
import com.ducklale.user.api.dto.AchievementDTO;
import com.ducklale.user.api.dto.RelUserAchievementDTO;
import com.ducklale.user.api.dto.query.AchievementQuery;
import com.ducklale.user.api.service.IRestfulAchievementService;
import com.ducklale.user.domain.service.IAchievementService;
import com.ducklale.user.domain.service.IRelUserAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementAdapter implements IRestfulAchievementService {
    @Autowired
    IRelUserAchievementService relUserAchievementService;
    @Autowired
    IAchievementService achievementService;
    @Override
    public List<RelUserAchievementDTO> getUserAchievements(Long userId){
        return relUserAchievementService.getByUserId(userId);
    }
    @Override
    public void addUserAchievements(List<RelUserAchievementDTO> dtos){
        relUserAchievementService.insertBatch(dtos);
    }

    @Override
    public Pagination<AchievementDTO> pageAchievements(AchievementQuery query) {
        return achievementService.pageAchievementByQuery(query);
    }
}
