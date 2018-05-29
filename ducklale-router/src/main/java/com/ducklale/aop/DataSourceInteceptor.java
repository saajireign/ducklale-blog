package com.ducklale.aop;

import com.ducklale.annotation.DucklaleRouter;
import com.ducklale.enums.SourceType;
import com.ducklale.metadata.dao.ShardingDao;
import com.ducklale.router.DataSourceKeyThreadLocal;
import com.ducklale.utils.ReflectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute after Transaction
public class DataSourceInteceptor {
    @Autowired
    ShardingDao dao;
    @Pointcut("execution(* com.ducklale..*.service..*(..))")
    public void metatdatacut(){
    };
    @Before("metatdatacut()")
    public void before(JoinPoint jp){
        MethodSignature signature = (MethodSignature) jp.getSignature();
        DucklaleRouter router = signature.getMethod().getAnnotation(DucklaleRouter.class);
        if( router !=null ) {
            SourceType type = router.readOrWrite();
            String attr = router.idAttribute();
            Class<?> clazz = router.routerClass();
            Object[] args = jp.getArgs();
            Object arg = null;
            Long id = null;
            if(router.isNeedReflectId()) {
                if (args != null && args.length > 0) {
                    int length = args.length;
                    for (int i = 0; i < length; i++) {
                        if (clazz.isInstance(args[i])) {
                            arg = args[i];
                            break;
                        }
                    }
                }
                if (arg != null) {
                    id = (Long) ReflectUtil.getter(arg, attr);
                }
            }else{
                if( args!=null && args.length==1 ){
                    id = (Long)args[0];
                }else{
                    int length = args.length;
                    for (int i = 0; i < length; i++) {
                        if (args[i] instanceof Long) {
                            id = (Long)args[i];
                            break;
                        }
                    }
                }
            }
            if (id != null) {
                String key = dao.searchShardNameByIdAndSourceType(id, type);
                if( key!=null && !key.equals("") ) {
                    DataSourceKeyThreadLocal.setKey(key);
                    return;
                }
            }
        }
        DataSourceKeyThreadLocal.resetKey();
    }

}
