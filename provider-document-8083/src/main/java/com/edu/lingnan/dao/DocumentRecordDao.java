package com.edu.lingnan.dao;

import com.edu.lingnan.entity.DocumentRecord;
import com.edu.lingnan.entity.MyUserDetails;
import com.edu.lingnan.entity.ProjectUser;
import com.edu.lingnan.entity.ProjectUserDuty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DocumentRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:20:06
 */
@Mapper
@Repository
public interface DocumentRecordDao extends BaseDao<DocumentRecord> {

    DocumentRecord getById(@Param("id") Integer id);

    List<DocumentRecord> getAllByProjectId(@Param("projectId") Integer projectId);

    boolean delete(@Param("id") Integer id);

    List<DocumentRecord> getAllDeleteDocumentRecord();

    boolean undo(@Param("id") Integer id);

    Integer getDocumentRecordCountByProjectId(@Param("projectId") Integer projectId);

    Integer getDocumentRecordCountByProjectIdAndUserId(
            @Param("projectId") Integer projectId,
            @Param("userId") Integer userId);

    List<DocumentRecord> getDocumentRecordPageByProjectId(
            @Param("projectId") Integer projectId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);

    List<DocumentRecord> getDocumentRecordPageByProjectIdAndUserId(
            @Param("projectId") Integer projectId,
            @Param("userId") Integer userId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);

    MyUserDetails getSimpleMyUserDetailsByUserId(@Param("id") Integer id);

    ProjectUser getProjectUserByUserIdAndProjectId(
            @Param("userId") Integer userId,
            @Param("projectId") Integer projectId);

    ProjectUserDuty getProjectUserDutyById(@Param("id") Integer id);
}