package com.reign.test.thread;

import com.ducklale.domain.converter.ConvertI;
import com.ducklale.domain.converter.DucklaleConvertI;
import com.ducklale.domain.converter.impl.BeanCopyConverterFactory;
import com.ducklale.user.domain.dto.UserDTO;
import com.ducklale.user.domain.entity.UserPO;

public class TestManyThreads {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            Thread r = new Thread(new subThread());
            r.start();
        }
    }

    private static final class subThread implements Runnable{

        @Override
        public void run() {
            DucklaleConvertI<UserDTO,UserPO> c = (DucklaleConvertI<UserDTO,UserPO> )BeanCopyConverterFactory.getInstance().getConverter(UserDTO.class,UserPO.class);
           System.out.println( c.toDto(new UserPO()));
        }
    }
}
