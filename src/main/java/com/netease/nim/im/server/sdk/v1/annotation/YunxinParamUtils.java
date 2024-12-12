package com.netease.nim.im.server.sdk.v1.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caojiajun on 2024/12/12
 */
public class YunxinParamUtils {

    private static final Map<Class<?>, Field[]> cache = new HashMap<>();

    public static Map<String, String> convert(Object obj) {
        if (obj == null) {
            return new HashMap<>();
        }
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = cache.get(clazz);
        if (fields == null) {
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
            }
            cache.put(clazz, fields);
        }
        for (Field field : fields) {
            YunxinParam annotation = field.getAnnotation(YunxinParam.class);
            if (annotation != null) {
                try {
                    Object value = field.get(obj);
                    if (value != null) {
                        map.put(annotation.value(), value.toString());
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
        return map;
    }
}
