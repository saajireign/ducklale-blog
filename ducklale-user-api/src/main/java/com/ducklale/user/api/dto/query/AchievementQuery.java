package com.ducklale.user.api.dto.query;

import com.ducklale.domain.Query;

public class AchievementQuery extends Query{
    private String achievementName;
    private String achievementDescription;
    private Integer achievementGrade;
    public Integer getAchievementGrade() {
        return achievementGrade;
    }

    public void setAchievementGrade(Integer achievementGrade) {
        this.achievementGrade = achievementGrade;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;



    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    public void setAchievementDescription(String achievementDescription) {
        this.achievementDescription = achievementDescription;
    }

}
