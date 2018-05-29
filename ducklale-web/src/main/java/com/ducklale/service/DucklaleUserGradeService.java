package com.ducklale.service;

import com.ducklale.user.api.service.IRestFulUserGradeService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="ducklale-user-service")
public interface DucklaleUserGradeService extends IRestFulUserGradeService{
}
