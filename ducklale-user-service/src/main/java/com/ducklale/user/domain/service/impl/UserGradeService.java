package com.ducklale.user.domain.service.impl;

import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.user.api.dto.UserGradeDTO;
import com.ducklale.user.api.service.IRestfulUserGradeService;
import com.ducklale.user.domain.dao.UserGradeDao;
import com.ducklale.user.domain.entity.UserGradePO;
import com.ducklale.user.domain.service.IUserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserGradeService extends DucklaleService<UserGradeDTO,UserGradePO,Long> implements IUserGradeService,IRestfulUserGradeService{
    @Autowired
    UserGradeDao dao;

    @Override
    public List<UserGradeDTO> getAll() {
        return toDtoList(dao.getAll());
    }

    @Override
    public UserGradeDao getDao() {
        return dao;
    }
}
