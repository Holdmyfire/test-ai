package com.example.demo.util.sonar;

import com.google.common.base.Strings;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @ClassName: ParamUtil
 * @author: fang.xu
 * @date: 2023/6/24 11:50
 * @Copyright: 2018 www.dbappsecurity.com.cn. All rights reserved.
 * @Description:
 */
public class ParamUtil {
    public ParamUtil() {
    }

    public static boolean empty(Object o) {
        if (o == null) {
            return true;
        } else if (o instanceof String) {
            return Strings.isNullOrEmpty((String) o);
        } else {
            return o instanceof Collection ? CollectionUtils.isEmpty((Collection)o) : false;
        }
    }

    public static boolean notEmpty(Object o) {
        return !empty(o);
    }

    public static boolean empty(Object[] ar) {
        return ar == null || ar.length == 0;
    }

    public static boolean notEmpty(Object[] ar) {
        return !empty(ar);
    }
}
