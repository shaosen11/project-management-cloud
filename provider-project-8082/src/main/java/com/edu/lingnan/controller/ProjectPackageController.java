package com.edu.lingnan.controller;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.entity.ProjectPackageList;
import com.edu.lingnan.feign.ProjectPackageFeignService;
import com.edu.lingnan.service.ProjectPackageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectPackage)表控制层
 *
 * @author makejava
 * @since 2020-06-11 21:17:14
 */
@RestController
@RequestMapping("projectPackage")
public class ProjectPackageController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectPackageService projectPackageService;

    @GetMapping("/{id}")
    ProjectPackage getById(@PathVariable("id") Integer id) {
        return projectPackageService.getById(id);
    }

    @GetMapping("getAllPackagesByProject/{projectId}")
    List<ProjectPackage> getAllPackagesByProject(@PathVariable("projectId") Integer projectId) {
        return projectPackageService.getAllPackagesByProject(projectId);
    }

    @GetMapping("getAllDocumentsByProjectsAndPackage/{projectId}/{packageId}")
    List<ProjectPackage> getAllDocumentsByProjectsAndPackage(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("packageId") Integer packageId) {
        return projectPackageService.getAllDocumentsByProjectsAndPackage(projectId, packageId);
    }

    @GetMapping("getPackageIdByProjectId/{projectId}")
    ProjectPackage getPackageIdByProjectId(@PathVariable("projectId") Integer projectId) {
        return projectPackageService.getPackageIdByProjectId(projectId);
    }

    @GetMapping("getPackageByProjectIdAndPackageName/{projectId}/{packageName}")
    ProjectPackage getPackageByProjectIdAndPackageName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("packageName") String packageName) {
        return projectPackageService.getPackageByProjectIdAndPackageName(projectId, packageName);
    }

    @GetMapping("getDocumentsNameByProjectIdAndPackageNameAndDocumentsName/{projectId}/{packageName}/{documentName}")
    ProjectPackage getDocumentsNameByProjectIdAndPackageNameAndDocumentsName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("packageName") String packageName,
            @PathVariable("documentName") String documentName) {
        return projectPackageService.getDocumentNameByProjectIdAndPackageNameAndDocumentName(projectId, packageName, documentName);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Integer id) {
        return projectPackageService.delete(id);
    }

    @PutMapping("/")
    boolean update(ProjectPackage projectPackage) {
        return projectPackageService.update(projectPackage);
    }

    @PostMapping("/")
    boolean insert(ProjectPackage projectPackage) {
        return projectPackageService.insert(projectPackage);
    }

    @GetMapping("getDocumentNameByProjectIdAndDocumentName/{projectId}/{documentName}")
    ProjectPackage getDocumentNameByProjectIdAndDocumentName(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("documentName") String documentName) {
        return projectPackageService.getDocumentNameByProjectIdAndDocumentName(projectId, documentName);
    }

    @GetMapping("getAllPackagesListByProjectId/{projectId}")
    List<ProjectPackageList> getAllPackagesListByProjectId(
            @PathVariable("projectId") Integer projectId) {
        return projectPackageService.getAllPackagesListByProjectId(projectId);
    }

}