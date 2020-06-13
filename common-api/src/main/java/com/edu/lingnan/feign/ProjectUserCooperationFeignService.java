package com.edu.lingnan.feign;

import com.edu.lingnan.entity.ProjectUserCooperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (ProjectUserCooperation)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:14
 */
@Component
@FeignClient(value = "PROVIDER-PROJECT")
public interface ProjectUserCooperationFeignService {

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    ProjectUserCooperation queryById(Integer id);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<ProjectUserCooperation> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param projectUserCooperation 实例对象
//     * @return 实例对象
//     */
//    ProjectUserCooperation insert(ProjectUserCooperation projectUserCooperation);
//
//    /**
//     * 修改数据
//     *
//     * @param projectUserCooperation 实例对象
//     * @return 实例对象
//     */
//    ProjectUserCooperation update(ProjectUserCooperation projectUserCooperation);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}