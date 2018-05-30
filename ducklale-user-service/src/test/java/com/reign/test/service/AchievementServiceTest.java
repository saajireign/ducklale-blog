package com.reign.test.service;

import com.ducklale.domain.Pagination;
import com.ducklale.user.api.dto.AchievementDTO;
import com.ducklale.user.api.dto.query.AchievementQuery;
import com.ducklale.user.api.service.IRestFulAchievementService;
import com.ducklale.user.domain.service.IAchievementService;
import com.reign.BaseTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AchievementServiceTest extends BaseTestCase{
    @Autowired
    IRestFulAchievementService service;
/*    @Test
    public void testGetById(){
        AchievementDTO dto = service.getById(1);
        Assert.assertNotNull(dto);
        System.out.println(dto.toString());
    }*/
    @Test
    public void testPage(){
        AchievementQuery query = new AchievementQuery();
        query.setAchievementDescription("个");
        Pagination<AchievementDTO> page = service.pageAchievementByQuery(query);
        Assert.assertNotNull(page.getRecords());
        Assert.assertTrue(!page.getRecords().isEmpty());
    }
   /* @Test
    public void testUserAchievements(){
       List<AchievementDTO> dtos = service.getUserAchievements(1L);
        Assert.assertEquals(dtos.size(),1);
    }*/
}
