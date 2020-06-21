package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.entity.ProjectPackageList;

import java.util.List;

/**
 * (ProjectPackage)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:18:05
 */
public interface ProjectPackageService {

    ProjectPackage getById(Integer id);

    List<ProjectPackage> getAllPackagesByProject(Integer projectId);

    List<ProjectPackage> getAllDocumentsByProjectsAndPackage(Integer projectId, Integer packageId);

    ProjectPackage getPackageIdByProjectId(Integer projectId);

    ProjectPackage getPackageByProjectIdAndPackageName(Integer projectId, String PackageName);

    ProjectPackage getDocumentNameByProjectIdAndPackageNameAndDocumentName(Integer projectId, String packageName, String documentName);

    boolean delete(Integer id);

    boolean update(ProjectPackage bean);

    boolean insert(ProjectPackage bean);

    ProjectPackage getDocumentNameByProjectIdAndDocumentName(Integer projectId, String documentName);

    List<ProjectPackageList> getAllPackagesListByProjectId(Integer projectId);
}