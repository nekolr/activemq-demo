package com.nekolr.example.util;

import com.nekolr.example.entity.EmailEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 邮件工具类
 */
@Slf4j
public class EmailUtils {

    public static void sendEmail(EmailEntity emailEntity) {
        // 模拟发送邮件
        log.info("邮件: {} 发送成功.", emailEntity);
    }

}
