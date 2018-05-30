package com.ducklale.user.domain.dao;
import com.ducklale.domain.dao.DucklaleDaoI;
import com.ducklale.user.api.dto.query.AchievementQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.lang.Exception;
import java.util.List;

import com.ducklale.user.domain.entity.AchievementPO;
/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Repository
@Mapper
public interface AchievementDao extends DucklaleDaoI<AchievementPO,Integer> {
    Integer queryPageCount(AchievementQuery query);
    List<AchievementPO> queryPage(AchievementQuery query);
    List<AchievementPO> getUserAchievements(Long userId);
}