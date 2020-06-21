package com.edu.lingnan.service;

import com.edu.lingnan.entity.Document;
import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:50
 */
public interface DocumentService {

    Document getById(Integer id);

    Document getByProjectIdAndVersionAndName(Integer projectId, Integer version, String name);

    Document getByProjectIdAndVersionFlagAndName(Integer projectId, Integer versionflag, String name);

    Integer getVersionByProjectIdAndName(Integer projectId, String name);

    boolean delete(Integer id);

    boolean update(Document bean);

    boolean insert(Document bean);

    List<Document> getAllDeleteDocument();

    boolean undo(Integer id);

}