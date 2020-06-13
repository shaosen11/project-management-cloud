package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.Document;
import com.edu.lingnan.dao.DocumentDao;
import com.edu.lingnan.service.DocumentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Document)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:19:38
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Resource
    private DocumentDao documentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Document queryById(Integer id) {
        return this.documentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Document> queryAllByLimit(int offset, int limit) {
        return this.documentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document insert(Document document) {
        this.documentDao.insert(document);
        return document;
    }

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    @Override
    public Document update(Document document) {
        this.documentDao.update(document);
        return this.queryById(document.getId());
    }

}