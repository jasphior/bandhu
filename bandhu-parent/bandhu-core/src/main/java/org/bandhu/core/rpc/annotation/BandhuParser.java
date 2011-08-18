package org.bandhu.core.rpc.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.bandhu.util.BandhuException;
import org.bandhu.util.BandhuUtil;

public class BandhuParser {
    public static <E> Object parseArray(Class<E> clazz, Object obj)
            throws Exception {
        if (obj.getClass().isArray()) {
            List<E> list = new ArrayList<E>();
            for (int i = 0; i < Array.getLength(obj); i++) {
                Object element = Array.get(obj, i);
                E parsed = (E) parse(clazz, element);
                list.add(parsed);
            }
            return list;
        } else {
            return parse(clazz, obj);
        }
    }

    public static <E> Object parse(Class<E> clazz, Object obj) throws Exception {
        if (obj.getClass().isArray()) {
            return parseArray(clazz, obj);
        } else {
            if (obj instanceof HashMap) {
                Map values = (Map) obj;
                E e = clazz.newInstance();
                Field[] fields = e.getClass().getFields();
                for (Field field : fields) {
                    Struct struct = field.getAnnotation(Struct.class);
                    String key = null;
                    if (BandhuUtil.hasText(struct.name())) {
                        key = struct.name();
                    } else {
                        key = field.getName();
                    }
                    Object value = values.get(key);
                    BeanUtils.setProperty(e, field.getName(), value);
                }
                return e;
            } else {
                return obj;
            }
        }
    }

    public static Map toStruct(Object obj) throws BandhuException {
        Map struct = new HashMap();
        try {
            struct = BeanUtils.describe(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BandhuException("Unable to convert " + obj.getClass());
        }
        for (Field field : obj.getClass().getFields()) {
            Struct annotation = field.getAnnotation(Struct.class);
            if (annotation == null) {
                struct.remove(field.getName());
            } else if (BandhuUtil.hasText(annotation.name())) {
                Object value = struct.remove(field.getName());
                struct.put(annotation.name(), value);
            }
        }
        return struct;
    }

}
