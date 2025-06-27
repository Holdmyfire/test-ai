package com.example.demo.util.sonar;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StringUtil
 * @author: fang.xu
 * @date: 2024/7/11 15:00
 * @Copyright: 2018 www.dbappsecurity.com.cn. All rights reserved.
 * @Description:
 */
public class StringUtil {

    /**
     * 检查目标字符串是否包含指定的错误字符
     * @param errorMsg
     * @param targetStr
     * @return
     */
    public static Boolean checkError(String errorMsg, String targetStr) {
        if (Strings.isNullOrEmpty(errorMsg)) {
            return false;
        }
        String[] errorArray =  errorMsg.split(",");
        List<String> errorList = Arrays.asList(errorArray);
        for (String error : errorList) {
            if (targetStr.contains(error)) {
                return true;
            }
        }
        return false;
    }
}
