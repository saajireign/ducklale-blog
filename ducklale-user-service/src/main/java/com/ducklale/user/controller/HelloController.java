package com.ducklale.user.controller;

import com.ducklale.user.domain.dao.AchievementDao;
import com.ducklale.user.domain.dto.UserGradeDTO;
import com.ducklale.user.domain.entity.AchievementPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/")
public class HelloController {
    @Autowired
    AchievementDao testservice;
    @ResponseBody
    @RequestMapping(value = "/test")
    String home() {
        AchievementPO rtn = null;
        try {
             rtn = testservice.selectById(1);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(rtn!=null){
            return "Hello Ducklale!";
        }
        return "hello World!";
    }
    @ResponseBody
    @RequestMapping(value = "/add")
    String achievementAdd(String name,String description,Integer point) {
        AchievementPO rtn = new AchievementPO();
        rtn.setAchievementName(name);
        rtn.setAchievementDescription(description);
        rtn.setAchievementPoints(point);
        try {
            testservice.insert(rtn);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(rtn!=null){
            return "Hello Ducklale!";
        }
        return "hello World!";
    }
  

}
