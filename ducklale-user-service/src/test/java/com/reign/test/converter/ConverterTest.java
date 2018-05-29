package com.reign.test.converter;

import com.ducklale.domain.converter.DucklaleConvertI;
import com.ducklale.domain.converter.impl.BeanCopyConverterFactory;
import com.ducklale.user.domain.dto.UserDTO;
import com.ducklale.user.domain.entity.UserPO;
import com.ducklale.user.domain.service.impl.UserService;
import com.ducklale.utils.ReflectUtil;
import com.reign.BaseTestCase;
import org.junit.Test;

import java.util.HashMap;

public class ConverterTest {
    @Test
    public void testConverterFactory(){
        UserService service = new UserService();

    }
}
