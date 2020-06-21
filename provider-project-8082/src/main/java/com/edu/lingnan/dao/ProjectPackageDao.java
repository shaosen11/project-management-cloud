package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.entity.ProjectPackageList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectPackage)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@Mapper
@Repository
public interface ProjectPackageDao extends BaseDao<ProjectPackage> {

    ProjectPackage getById(Integer id);

    List<ProjectPackage> getAllPackagesByProject(Integer projectId);

    List<ProjectPackage> getAllDocumentsByProjectsAndPackage(@Param("projectId") Integer projectId, @Param("packageId") Integer packageId);

    ProjectPackage getPackageIdByProjectId(Integer projectId);

    ProjectPackage getPackageByProjectIdAndPackageName(@Param("projectId") Integer projectId, @Param("packageName") String packageName);

    ProjectPackage getDocumentNameByProjectIdAndPackageNameAndDocumentName(
            @Param("projectId") Integer projectId,
            @Param("packageName") String packageName,
            @Param("documentName") String documentName);

    boolean delete(Integer id);

    ProjectPackage getDocumentNameByProjectIdAndDocumentName(@Param("projectId") Integer projectId, @Param("documentName") String documentName);

    List<ProjectPackageList> getAllPackagesListByProjectId(Integer projectId);


}