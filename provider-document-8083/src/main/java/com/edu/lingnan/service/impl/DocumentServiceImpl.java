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

    @Override
    public Document getById(Integer id) {
        return documentDao.getById(id);
    }

    @Override
    public Document getByProjectIdAndVersionAndName(Integer projectId, Integer version, String name) {
        return documentDao.getByProjectIdAndVersionAndName(projectId, version, name);
    }

    @Override
    public Document getByProjectIdAndVersionFlagAndName(Integer projectId, Integer versionflag, String name) {
        return documentDao.getByProjectIdAndVersionFlagAndName(projectId, versionflag, name);
    }

    @Override
    public Integer getVersionByProjectIdAndName(Integer projectId, String name) {
        return documentDao.getVersionByProjectIdAndName(projectId, name);
    }

    @Override
    public boolean insert(Document bean) {
        return documentDao.insert(bean) > 0;
    }

    @Override
    public boolean update(Document bean) {
        return documentDao.update(bean);
    }

    @Override
    public boolean delete(Integer id) {
        return documentDao.delete(id);
    }

    @Override
    public List<Document> getAllDeleteDocument() {
        return documentDao.getAllDeleteDocument();
    }

    @Override
    public boolean undo(Integer id) {
        return documentDao.undo(id);
    }
}