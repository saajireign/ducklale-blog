package com.ducklale.user.api.service;

import com.ducklale.user.api.dto.BehaviorOrdersDTO;
import com.ducklale.user.api.dto.UserBehaviorDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/ducklale-user-service")
public interface IRestfulUserBehaviorService {
    @RequestMapping(value = "/getUserBehaviors", method = RequestMethod.GET)
    List<UserBehaviorDTO> getUserBehaviors(Long userId);

    @RequestMapping(value = "/updateUserBehaviors", method = RequestMethod.GET)
    void updateUserBehaviors(List<UserBehaviorDTO> behaviors);

    @RequestMapping(value = "/getBehaviorOrders", method = RequestMethod.GET)
    List<BehaviorOrdersDTO> getBehaviorOrders();

    @RequestMapping(value = "/addBehaviorOrder", method = RequestMethod.GET)
    void addBehaviorOrder(BehaviorOrdersDTO order);

    @RequestMapping(value = "/updateBehaviorOrder", method = RequestMethod.GET)
    void updateBehaviorOrder(BehaviorOrdersDTO order);
}
