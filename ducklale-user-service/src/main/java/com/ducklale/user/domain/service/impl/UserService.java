package com.ducklale.user.domain.service.impl;

import com.ducklale.domain.service.DucklaleServiceI;
import com.ducklale.domain.service.impl.DucklaleService;
import com.ducklale.user.domain.dao.UserDao;
import com.ducklale.user.domain.dto.UserDTO;
import com.ducklale.user.domain.entity.UserPO;
import com.ducklale.user.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends DucklaleService<UserDTO,UserPO,Long> implements IUserService{
    @Autowired
    UserDao userDao;
    public UserDao getDao(){
        return userDao;
    }

}
