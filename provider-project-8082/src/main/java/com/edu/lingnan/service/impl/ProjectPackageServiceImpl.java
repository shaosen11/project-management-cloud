package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.dao.ProjectPackageDao;
import com.edu.lingnan.entity.ProjectPackageList;
import com.edu.lingnan.feign.ProjectPackageFeignService;
import com.edu.lingnan.service.ProjectPackageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectPackage)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@Service("projectPackageService")
public class ProjectPackageServiceImpl implements ProjectPackageService {
    @Resource
    private ProjectPackageDao projectPackageDao;

    @Override
    public ProjectPackage getById(Integer id) {
        return projectPackageDao.getById(id);
    }

    @Override
    public List<ProjectPackage> getAllPackagesByProject(Integer projectId) {
        return projectPackageDao.getAllPackagesByProject(projectId);
    }

    @Override
    public List<ProjectPackage> getAllDocumentsByProjectsAndPackage(Integer projectId, Integer packageId) {
        return projectPackageDao.getAllDocumentsByProjectsAndPackage(projectId, packageId);
    }

    @Override
    public ProjectPackage getPackageIdByProjectId(Integer projectId) {
        return projectPackageDao.getPackageIdByProjectId(projectId);
    }

    @Override
    public ProjectPackage getPackageByProjectIdAndPackageName(Integer projectId, String PackageName) {
        return projectPackageDao.getPackageByProjectIdAndPackageName(projectId, PackageName);
    }

    @Override
    public ProjectPackage getDocumentNameByProjectIdAndPackageNameAndDocumentName(Integer projectId, String paacageName, String documentName) {
        return projectPackageDao.getDocumentNameByProjectIdAndPackageNameAndDocumentName(projectId, paacageName, documentName);
    }

    @Override
    public boolean delete(Integer id) {
        return projectPackageDao.delete(id);
    }

    @Override
    public boolean update(ProjectPackage bean) {
        return projectPackageDao.update(bean);
    }

    @Override
    public boolean insert(ProjectPackage bean) {
        return projectPackageDao.insert(bean) > 0;
    }

    @Override
    public ProjectPackage getDocumentNameByProjectIdAndDocumentName(Integer projectId, String documentName) {
        return projectPackageDao.getDocumentNameByProjectIdAndDocumentName(projectId, documentName);
    }

    @Override
    public List<ProjectPackageList> getAllPackagesListByProjectId(Integer projectId) {
        return projectPackageDao.getAllPackagesListByProjectId(projectId);
    }
}