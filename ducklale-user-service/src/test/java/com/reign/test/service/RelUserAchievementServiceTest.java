package com.reign.test.service;

import com.ducklale.user.domain.dto.AchievementDTO;
import com.ducklale.user.domain.dto.RelUserAchievementDTO;
import com.ducklale.user.domain.service.IAchievementService;
import com.ducklale.user.domain.service.IRelUserAchievementService;
import com.reign.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelUserAchievementServiceTest  extends BaseTestCase{
    @Autowired
    IRelUserAchievementService service;
    @Autowired
    IAchievementService achievementService;
    @Test
    @Rollback(true)
    public void testBatch(){
        List<RelUserAchievementDTO> dtos =new ArrayList<>();
        for(Integer i=0;i<10;i++){
            RelUserAchievementDTO dto = new RelUserAchievementDTO();
            dto.setAchievementId(1);
            dto.setUserId(Long.parseLong(i.toString()));
            dto.setAchievementDate(new Date());
            dtos.add(dto);
        }
        service.insertBatch(dtos);
        List<AchievementDTO> achieves = achievementService.getUserAchievements(1L);
        System.out.println("");
    }
}
