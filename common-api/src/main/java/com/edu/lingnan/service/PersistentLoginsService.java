package com.edu.lingnan.service;

import com.edu.lingnan.entity.PersistentLogins;
import java.util.List;

/**
 * (PersistentLogins)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:11:04
 */
public interface PersistentLoginsService {

    /**
     * 通过ID查询单条数据
     *
     * @param series 主键
     * @return 实例对象
     */
    PersistentLogins queryById(String series);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersistentLogins> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    PersistentLogins insert(PersistentLogins persistentLogins);

    /**
     * 修改数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    PersistentLogins update(PersistentLogins persistentLogins);

    /**
     * 通过主键删除数据
     *
     * @param series 主键
     * @return 是否成功
     */
    boolean deleteById(String series);

}