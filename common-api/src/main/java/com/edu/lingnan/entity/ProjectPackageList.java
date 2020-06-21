package com.edu.lingnan.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 11:13 2020/6/20
 */
@Data
public class ProjectPackageList {
    private Integer projectId;
    private Integer packageId;
    private String packageName;
    private List<ProjectPackage> projectPackageList;
}
