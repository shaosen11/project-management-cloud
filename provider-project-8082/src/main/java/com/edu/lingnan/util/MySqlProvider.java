package com.edu.lingnan.util;

import com.edu.lingnan.annotation.Id;
import com.edu.lingnan.annotation.Table;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:27 2020/6/3
 */
public class MySqlProvider {
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";

    public static String insert(Object obj) {
        Map<String, String> map = new HashMap<>();
        String tableName = getTableName(obj);
        System.out.println("1111");
        getMap(obj, map);
        return new SQL() {
            {
                INSERT_INTO(tableName);//insert into table
                for (String key : map.keySet()) {
                    VALUES(key, map.get(key));
                }
            }
        }.toString();
    }

    public static String update(Object obj) {
        Map<String, String> map = new HashMap<>();
        String tableName = getTableName(obj);
        String idName = getMap(obj, map);
        if (StringUtil.isEmpty(idName)) {
            throw new RuntimeException("实体类->" + obj.getClass().getCanonicalName() + "必须有@Id注解");
        }
        return new SQL() {
            {
                UPDATE(tableName);//update
                for (String key : map.keySet()) {
                    SET(key + "=" + map.get(key));
                }
                WHERE(idName + "=" + map.get(idName));
            }
        }.toString();
    }



    public static String getTableName(Object obj) {
        Class c = obj.getClass();
        Table annotation = (Table) c.getAnnotation(Table.class);
        if (annotation != null) {
            return annotation.value();
        }
        return c.getSimpleName();
    }

    private static String getIdName(Field obj) {
        Class c = obj.getClass();
        Id id = (Id) c.getAnnotation(Id.class);
        if (id != null && !StringUtil.isEmpty(id.value())) {
            return id.value();
        }

        return StringUtil.underscoreName(obj.getName());
    }

    private static String getMap(Object obj, Map<String, String> map) {
        Class c = obj.getClass();
        //获取所有属性
        Field[] fs = c.getDeclaredFields();
        String idName = null;
        for (Field item : fs) {
            String key = item.getName();
            item.setAccessible(true);
            //如果找到过id的值，就不为空，不然就一直找
            if (idName == null) {
                idName = getIdName(item);
            }
            try {
                //通过反射获取值，如果不为空就添加进map
                if (item.get(obj) != null) {
                    map.put(StringUtil.underscoreName(key), "#{" + key + "}");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return idName;
    }

}
