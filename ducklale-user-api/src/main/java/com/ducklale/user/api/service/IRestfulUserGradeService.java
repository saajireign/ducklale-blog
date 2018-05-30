package com.ducklale.user.api.service;

import com.ducklale.user.api.dto.LightingChargeDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ducklale.user.api.dto.UserGradeDTO;
import java.util.List;

@RequestMapping("/ducklale-user-service")
public interface IRestfulUserGradeService {
    @RequestMapping(value = "/getAllUserGrades", method = RequestMethod.GET)
    List<UserGradeDTO> getAll();

    @RequestMapping(value = "/chargeUserLighting", method = RequestMethod.GET)
    void chargeUserLighting(List<LightingChargeDTO> lightings);
}
