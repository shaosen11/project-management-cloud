package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectFunction;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * (ProjectFunction)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:40
 */
public interface ProjectFunctionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectFunction queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimit(int offset, int limit,ProjectFunction projectFunction);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryAll(ProjectFunction projectFunction);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimitByUserId(int offset, int limit,ProjectFunction projectFunction);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByUserId(ProjectFunction projectFunction);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryDelByLimitByUserId(int offset, int limit,ProjectFunction projectFunction);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryDelByUserId(ProjectFunction projectFunction);

    /**
     * 新增数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    ProjectFunction insert(ProjectFunction projectFunction);

    /**
     * 修改数据
     *
     * @param projectFunction 实例对象
     * @return 实例对象
     */
    ProjectFunction update(ProjectFunction projectFunction);

    /**
     * 删除项目功能点信息通过ProjectsId
     * @return boolean
     */
    boolean deleteProjectFunctionByProjectsId(Integer id);

    /**
     * 查询项目功能点数量
     * @return int
     */
    Integer countProjectFunctionByProjectId(Integer id);

    /**
     * 通过项目id和功能点状态查询功能点数量
     * @return Integer
     */
    Integer countByProjectIdAndStatus(Integer id, Integer functionStatus);

    /**
     * 通过项目id查询全部已取消功能点数量
     * @return
     */
    Integer countDelByProjectId(Integer id);


    /**
     * 分页--通过项目id获得项目计划
     * @return
     */
    List<ProjectFunction> getProjectPlanFunctionsPage(Integer projectsId,Integer offset,Integer pageSize);

    /**
     * 通过项目id查询指派给我的的功能（不分页）
     * @param projectsId
     * @param realizeUserId
     * @param functionStatus
     * @return
     */
    List<ProjectFunction> getFunctionByProjectIdAndRealizeUserId(Integer projectsId,Integer realizeUserId,Integer functionStatus);



}