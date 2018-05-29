package com.ducklale.user.domain.service;

import com.ducklale.domain.Pagination;
import com.ducklale.domain.Query;
import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.user.domain.dto.AchievementDTO;
import com.ducklale.user.domain.entity.AchievementPO;
import com.ducklale.user.domain.query.AchievementQuery;

import java.util.List;

public interface IAchievementService  extends DucklaleServiceI<AchievementDTO,Integer> {
    Pagination<AchievementDTO> pageAchievementByQuery(AchievementQuery query);
    List<AchievementDTO> getUserAchievements(Long userId);
}
