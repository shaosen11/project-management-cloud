package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.PersistentLogins;
import com.edu.lingnan.dao.PersistentLoginsDao;
import com.edu.lingnan.feign.PersistentLoginsFeignService;
import com.edu.lingnan.service.PersistentLoginsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersistentLogins)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 14:59:21
 */
@Service("persistentLoginsService")
public class PersistentLoginsServiceImpl implements PersistentLoginsService {
    @Resource
    private PersistentLoginsDao persistentLoginsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param series 主键
     * @return 实例对象
     */
    @Override
    public PersistentLogins queryById(String series) {
        return this.persistentLoginsDao.queryById(series);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PersistentLogins> queryAllByLimit(int offset, int limit) {
        return this.persistentLoginsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    @Override
    public PersistentLogins insert(PersistentLogins persistentLogins) {
        this.persistentLoginsDao.insert(persistentLogins);
        return persistentLogins;
    }

    /**
     * 修改数据
     *
     * @param persistentLogins 实例对象
     * @return 实例对象
     */
    @Override
    public PersistentLogins update(PersistentLogins persistentLogins) {
        this.persistentLoginsDao.update(persistentLogins);
        return this.queryById(persistentLogins.getSeries());
    }

}