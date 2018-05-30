package com.ducklale.user.api.service;

import com.ducklale.domain.Pagination;
import com.ducklale.user.api.dto.AchievementDTO;
import com.ducklale.user.api.dto.RelUserAchievementDTO;
import com.ducklale.user.api.dto.query.AchievementQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 成就微服务
 */
@RequestMapping("/ducklale-user-service")
public interface IRestfulAchievementService {
    /**
     * 分页查询出系统中所有的成就
     * @param query 字段： achievementName,achievementDescription,achievementGrade
     * @return
     */
    @RequestMapping(value = "/pageAchievements", method = RequestMethod.GET)
    Pagination<AchievementDTO> pageAchievements(AchievementQuery query);

    /**
     * 查询用户已达成的成就
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserAchievements", method = RequestMethod.GET)
    List<RelUserAchievementDTO> getUserAchievements(Long userId);

    /**
     * 批量插入用户的成就
     * @param dtos
     */
    @RequestMapping(value = "/addUserAchievements", method = RequestMethod.GET)
    void addUserAchievements(List<RelUserAchievementDTO> dtos);

}
