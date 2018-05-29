package com.ducklale.user.domain.service;

import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.user.domain.dto.RelUserAchievementDTO;

import java.util.List;

public interface IRelUserAchievementService extends DucklaleServiceI<RelUserAchievementDTO,Long> {
    public void insertBatch(List<RelUserAchievementDTO> dtos);
}
