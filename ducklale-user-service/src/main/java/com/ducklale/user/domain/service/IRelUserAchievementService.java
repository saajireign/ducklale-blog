package com.ducklale.user.domain.service;

import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.user.api.dto.RelUserAchievementDTO;

import java.util.List;

public interface IRelUserAchievementService extends DucklaleServiceI<RelUserAchievementDTO,Long> {
    void insertBatch(List<RelUserAchievementDTO> dtos);
    List<RelUserAchievementDTO> getByUserId(Long userId);
}
