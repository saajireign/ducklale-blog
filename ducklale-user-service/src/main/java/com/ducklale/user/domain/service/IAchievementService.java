package com.ducklale.user.domain.service;

import com.ducklale.domain.Pagination;
import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.user.api.dto.AchievementDTO;
import com.ducklale.user.api.dto.query.AchievementQuery;

import java.util.List;

public interface IAchievementService  extends DucklaleServiceI<AchievementDTO,Integer> {
    Pagination<AchievementDTO> pageAchievementByQuery(AchievementQuery query);
}
