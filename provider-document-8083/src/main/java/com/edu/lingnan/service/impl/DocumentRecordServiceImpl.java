package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.DocumentRecord;
import com.edu.lingnan.dao.DocumentRecordDao;
import com.edu.lingnan.feign.DocumentRecordFeignService;
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

    @Override
    public List<DocumentRecord> getAllByProjectId(Integer projectId) {
        return documentRecordDao.getAllByProjectId(projectId);
    }

    @Override
    public boolean delete(Integer id) {
        return documentRecordDao.delete(id);
    }

    @Override
    public boolean update(DocumentRecord documentRecord) {
        return documentRecordDao.update(documentRecord);
    }

    @Override
    public boolean insert(DocumentRecord documentRecord) {
        return documentRecordDao.insert(documentRecord) > 0;
    }

    @Override
    public List<DocumentRecord> getAllDeleteDocumentRecord() {
        return documentRecordDao.getAllDeleteDocumentRecord();
    }

    @Override
    public boolean undo(Integer id) {
        return documentRecordDao.undo(id);
    }

    @Override
    public Integer getDocumentRecordCountByProjectId(Integer projectId) {
        return documentRecordDao.getDocumentRecordCountByProjectId(projectId);
    }

    @Override
    public Integer getDocumentRecordCountByProjectIdAndUserId(Integer projectId, Integer userId) {
        return documentRecordDao.getDocumentRecordCountByProjectIdAndUserId(projectId, userId);
    }

    @Override
    public List<DocumentRecord> getDocumentRecordPageByProjectId(Integer projectId, Integer offset, Integer pageSize) {
        return documentRecordDao.getDocumentRecordPageByProjectId(projectId, offset, pageSize);
    }

    @Override
    public List<DocumentRecord> getDocumentRecordPageByProjectIdAndUserId(Integer projectId, Integer userId, Integer offset, Integer pageSize) {
        return documentRecordDao.getDocumentRecordPageByProjectIdAndUserId(projectId, userId, offset, pageSize);
    }
}