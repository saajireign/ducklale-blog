package com.ducklale.user.api.service;

import com.ducklale.user.domain.dto.UserGradeDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/ducklale-user-service")
public interface IRestFulUserGradeService {
    @RequestMapping(value = "/getAllUserGrades", method = RequestMethod.GET)
    List<UserGradeDTO> getAll();
}
