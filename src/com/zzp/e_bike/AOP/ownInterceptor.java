package com.zzp.e_bike.AOP;

import com.zzp.e_bike.pojo.Own;
import com.zzp.e_bike.util.ReturnMessage;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;

/**
 * 用于验证Own信息是否正确的AOP
 *
 * @author ho
 * @create 2017-07-24 11:10
 */
public class ownInterceptor {
    public Object checkOwn(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = null;
        Own own = null;
        boolean b = true;
        String result = null;
        try {
            objects = joinPoint.getArgs();
            own = (Own) objects[0];
            if (own.getName() == null || own.getName().equals("")) {
                result = ReturnMessage.NAME_EMPTY;
            }
            if (own.getPhone() == null || own.getPhone().equals("")) {
                result = ReturnMessage.PHONE_EMPTY;
            }
            if (own.getMoney() <= 0) {
                result = ReturnMessage.MONEY_ERROE;
            }
            if (own.getBikeId() == 0) {
                result = ReturnMessage.BIKE_EMPTY;
            }
            if (own.getAddressId() == 0) {
                result = ReturnMessage.ADDRESS_EMPTY;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            own.setSellDate(simpleDateFormat.parse(own.getSellDateStr()));
        } catch (Exception e) {
            e.printStackTrace();
            result = ReturnMessage.SYSTEM_REEOR;
            b = false;
        } finally {
            if (b && result == null) {
                return joinPoint.proceed();
            } else {
                return result;
            }
        }
    }
}
