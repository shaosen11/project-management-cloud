package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserRecord;
import java.util.List;

/**
 * (UserRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:56
 */
public interface UserRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    UserRecord insert(UserRecord userRecord);

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    UserRecord update(UserRecord userRecord);


}