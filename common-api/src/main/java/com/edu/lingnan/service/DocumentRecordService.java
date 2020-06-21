package com.edu.lingnan.service;

import com.edu.lingnan.entity.DocumentRecord;
import java.util.List;

/**
 * (DocumentRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:58
 */
public interface DocumentRecordService {

    List<DocumentRecord> getAllByProjectId(Integer projectId);

    boolean delete(Integer id);

    boolean update(DocumentRecord bean);

    boolean insert(DocumentRecord bean);

    List<DocumentRecord> getAllDeleteDocumentRecord();

    boolean undo(Integer id);

    Integer getDocumentRecordCountByProjectId(Integer projectId);

    Integer getDocumentRecordCountByProjectIdAndUserId(Integer projectId, Integer userId);

    List<DocumentRecord> getDocumentRecordPageByProjectId(Integer projectId, Integer offset, Integer pageSize);

    List<DocumentRecord> getDocumentRecordPageByProjectIdAndUserId(Integer projectId, Integer userId, Integer offset, Integer pageSize);


}