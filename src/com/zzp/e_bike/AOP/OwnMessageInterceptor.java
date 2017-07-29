package com.zzp.e_bike.AOP;

import com.zzp.e_bike.pojo.OwnMessage;
import com.zzp.e_bike.util.ReturnMessage;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 验证还款录入信息
 *
 * @author ho
 * @create 2017-07-26 10:22
 */
public class OwnMessageInterceptor {
    public Object checkOwnMessage(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = null;
        OwnMessage ownMessage = null;
        boolean b = false;
        String result = null;
        try {
            args = joinPoint.getArgs();
            ownMessage = (OwnMessage) args[0];
            if (ownMessage.getSetDateStr() == null) {
                result = ReturnMessage.MESSAGE_EMPTY;
            }
            if (ownMessage.getOwnId() == 0) {
                result = ReturnMessage.SYSTEM_REEOR;
            }
            if (ownMessage.getMoney() < 0) {
                result = ReturnMessage.MONEY_ERROE;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ownMessage.setSetDate(simpleDateFormat.parse(ownMessage.getSetDateStr()));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期异常....");
            result = ReturnMessage.SYSTEM_REEOR;
            b = true;
        } finally {
            if (!b && result == null) {
                return joinPoint.proceed();
            } else {
                return result;
            }
        }
    }
}
