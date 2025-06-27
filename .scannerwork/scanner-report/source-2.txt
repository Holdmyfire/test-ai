package com.example.demo.util.sonar;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lj
 * @date 2023/9/18
 */
@Slf4j
public class SqlUtil {

    /**
     * 敏感字符 正则匹配字符串
     */
    public static final String badStr = "\\b(and|exec|execute|insert|select|delete|update|count|drop|chr|mid|master|truncate|" +
            "char|declare|sitename|xp_cmdshell|table|from|grant|use|group_concat|column_name" +
            "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|master|truncate|char|declare)\\b" +
            "|(-|\\+|,|\\||\\/|\\\\|%|#|\\$)";

    /**
     * sql敏感词检查
     * @throws Exception
     */
    public static Boolean check(String text) throws Exception {
        if(StrUtil.isEmpty(text)){
            return true;
        }
        text = text.toLowerCase();
        if(ReUtil.contains(badStr, text)){
            log.error("查询文本存在敏感字符：" + text);
            return false;
        }else {
            return true;
        }
    }


}