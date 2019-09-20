package com.nekolr.example.util;

import com.nekolr.example.entity.SmsEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nekolr
 */
@Slf4j
public class SmsUtils {
    public static void sendSms(SmsEntity smsEntity) {
        // 模拟发送短信
        log.info("短信: {} 发送成功.", smsEntity);
    }
}
