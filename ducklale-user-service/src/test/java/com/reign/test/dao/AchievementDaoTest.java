package com.reign.test.dao;

import com.ducklale.user.DucklaleUserController;
import com.ducklale.user.domain.dao.AchievementDao;
import com.ducklale.user.domain.entity.AchievementPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DucklaleUserController.class)
public class AchievementDaoTest {
    @Autowired
    AchievementDao testservice;
    @Test
    public void testFindById(){
        try {
            AchievementPO po = testservice.selectById(1);
            Assert.assertNotNull(po);
            System.out.println(po.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
