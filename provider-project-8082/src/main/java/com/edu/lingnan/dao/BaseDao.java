package com.edu.lingnan.dao;

import com.edu.lingnan.util.MySqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:26 2020/6/3
 */
public interface BaseDao<T> {
    @InsertProvider(type = MySqlProvider.class, method = MySqlProvider.INSERT)
    int insert(T bean);

    @UpdateProvider(type = MySqlProvider.class, method = MySqlProvider.UPDATE)
    boolean update(T bean);

}
