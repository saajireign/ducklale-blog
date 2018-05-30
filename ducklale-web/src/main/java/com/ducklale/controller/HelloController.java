package com.ducklale.controller;

import com.ducklale.service.DucklaleUserGradeService;
import com.ducklale.service.DucklaleWebTestService;
import com.ducklale.user.api.dto.UserGradeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    DucklaleUserGradeService gradeService;
//    @Autowired
//    DucklaleWebTestService service;
    /*@ResponseBody
    @RequestMapping(value = "/")
    String home() {
       return service.getTest();
    }*/
@RequestMapping(value = "/hello")
@ResponseBody
public List<UserGradeDTO> home() {
//    GsonBuilder gb = new GsonBuilder();
//    Gson gson = gb.create();
    List<UserGradeDTO> dtos = gradeService.getAll();
    return dtos;
}

}
