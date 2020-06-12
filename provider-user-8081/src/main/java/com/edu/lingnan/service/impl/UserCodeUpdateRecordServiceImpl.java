package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserCodeUpdateRecord;
import com.edu.lingnan.dao.UserCodeUpdateRecordDao;
import com.edu.lingnan.service.UserCodeUpdateRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserCodeUpdateRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:18:43
 */
@Service("userCodeUpdateRecordService")
public class UserCodeUpdateRecordServiceImpl implements UserCodeUpdateRecordService {
    @Resource
    private UserCodeUpdateRecordDao userCodeUpdateRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserCodeUpdateRecord queryById(Integer id) {
        return this.userCodeUpdateRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserCodeUpdateRecord> queryAllByLimit(int offset, int limit) {
        return this.userCodeUpdateRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userCodeUpdateRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserCodeUpdateRecord insert(UserCodeUpdateRecord userCodeUpdateRecord) {
        this.userCodeUpdateRecordDao.insert(userCodeUpdateRecord);
        return userCodeUpdateRecord;
    }

    /**
     * 修改数据
     *
     * @param userCodeUpdateRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserCodeUpdateRecord update(UserCodeUpdateRecord userCodeUpdateRecord) {
        this.userCodeUpdateRecordDao.update(userCodeUpdateRecord);
        return this.queryById(userCodeUpdateRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userCodeUpdateRecordDao.deleteById(id) > 0;
    }
}