package com.edu.lingnan.dao;

import com.edu.lingnan.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Document)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:19:37
 */
@Mapper
@Repository
public interface DocumentDao extends BaseDao<Document>{

    Document getById(Integer id);

    Document getByProjectIdAndVersionAndName(
            @Param("projectId") Integer projectId,
            @Param("version") Integer version,
            @Param("name") String name);

    Document getByProjectIdAndVersionFlagAndName(
            @Param("projectId") Integer projectId,
            @Param("versionflag") Integer versionflag,
            @Param("name") String name);

    Integer getVersionByProjectIdAndName(
            @Param("projectId") Integer projectId,
            @Param("name") String name);

    boolean delete(Integer id);

    List<Document> getAllDeleteDocument();

    boolean undo(Integer id);


}