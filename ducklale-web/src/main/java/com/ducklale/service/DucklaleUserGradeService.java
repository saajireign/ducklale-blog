package com.ducklale.service;

import com.ducklale.user.api.service.IRestfulUserGradeService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value="ducklale-user-service")
public interface DucklaleUserGradeService extends IRestfulUserGradeService{
}
