package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectPackage;
import com.edu.lingnan.entity.ProjectPackageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (ProjectPackage)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:13:47
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectPackageFeignService {

    @GetMapping("/projectPackage/{id}")
    ProjectPackage getById(@RequestParam("id") Integer id);

    @GetMapping("/projectPackage/getAllPackagesByProject/{projectId}")
    List<ProjectPackage> getAllPackagesByProject(@RequestParam("projectId") Integer projectId);

    @GetMapping("/projectPackage/getAllDocumentsByProjectsAndPackage/{projectId}/{packageId}")
    List<ProjectPackage> getAllDocumentsByProjectsAndPackage(@RequestParam("projectId") Integer projectId, @RequestParam("packageId") Integer packageId);

    @GetMapping("/projectPackage/getPackageIdByProjectId/{projectId}")
    ProjectPackage getPackageIdByProjectId(@RequestParam("projectId") Integer projectId);

    @GetMapping("/projectPackage/getPackageByProjectIdAndPackageName/{projectId}/{packageName}")
    ProjectPackage getPackageByProjectIdAndPackageName(@RequestParam("projectId") Integer projectId, @RequestParam("packageName") String packageName);

    @GetMapping("/projectPackage/getPackageByProjectIdAndPackageName/{projectId}/{packageName}")
    ProjectPackage getDocumentsNameByProjectIdAndPackageNameAndDocumentsName(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("packageName") String packageName,
            @RequestParam("documentName") String documentName);

    @DeleteMapping("/projectPackage/")
    boolean delete(Integer id);

    @PutMapping("/projectPackage/")
    boolean update(ProjectPackage projectPackage);

    @PostMapping("/projectPackage/")
    boolean insert(ProjectPackage projectPackage);

    @GetMapping("/projectPackage/getDocumentNameByProjectIdAndDocumentName/{projectId}/{documentName}")
    ProjectPackage getDocumentNameByProjectIdAndDocumentName(
            @RequestParam("projectId") Integer projectId,
            @RequestParam("documentName") String documentName);

    @GetMapping("/projectPackage/getAllPackagesListByProjectId/{projectId}")
    List<ProjectPackageList> getAllPackagesListByProjectId(@RequestParam("projectId") Integer projectId);
}