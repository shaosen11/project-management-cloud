package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserRecord;
import com.edu.lingnan.dao.UserRecordDao;
import com.edu.lingnan.feign.UserRecordFeignService;
import com.edu.lingnan.service.UserRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:19:02
 */
@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Resource
    private UserRecordDao userRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRecord queryById(Integer id) {
        return this.userRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserRecord> queryAllByLimit(int offset, int limit) {
        return this.userRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord insert(UserRecord userRecord) {
        this.userRecordDao.insert(userRecord);
        return userRecord;
    }

    /**
     * 修改数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserRecord update(UserRecord userRecord) {
        this.userRecordDao.update(userRecord);
        return this.queryById(userRecord.getId());
    }

}