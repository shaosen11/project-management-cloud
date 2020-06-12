package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.DocumentRecord;
import com.edu.lingnan.dao.DocumentRecordDao;
import com.edu.lingnan.service.DocumentRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DocumentRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:20:06
 */
@Service("documentRecordService")
public class DocumentRecordServiceImpl implements DocumentRecordService {
    @Resource
    private DocumentRecordDao documentRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public DocumentRecord queryById(Integer id) {
        return this.documentRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<DocumentRecord> queryAllByLimit(int offset, int limit) {
        return this.documentRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param documentRecord 实例对象
     * @return 实例对象
     */
    public DocumentRecord insert(DocumentRecord documentRecord) {
        this.documentRecordDao.insert(documentRecord);
        return documentRecord;
    }

    /**
     * 修改数据
     *
     * @param documentRecord 实例对象
     * @return 实例对象
     */
    public DocumentRecord update(DocumentRecord documentRecord) {
        this.documentRecordDao.update(documentRecord);
        return this.queryById(documentRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.documentRecordDao.deleteById(id) > 0;
    }
}