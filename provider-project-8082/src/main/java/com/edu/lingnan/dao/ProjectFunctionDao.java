package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectFunction)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:16:42
 */
@Mapper
@Repository
public interface ProjectFunctionDao extends BaseDao<ProjectFunction> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProjectFunction queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("projectFunction") ProjectFunction projectFunction);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryAll(ProjectFunction projectFunction);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByLimitByUserId(@Param("offset") int offset, @Param("limit") int limit,@Param("projectFunction") ProjectFunction projectFunction);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryAllByUserId(@Param("projectFunction")ProjectFunction projectFunction);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProjectFunction> queryDelByLimitByUserId(@Param("offset") int offset, @Param("limit") int limit,@Param("projectFunction") ProjectFunction projectFunction);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param projectFunction 实例对象
     * @return 对象列表
     */
    List<ProjectFunction> queryDelByUserId(@Param("projectFunction")ProjectFunction projectFunction);

    /**
     * 删除项目功能点信息通过ProjectsId
     * @return
     */
    Integer deleteProjectFunctionByProjectsId(Integer id);

    /**
     * 查询项目功能点数量
     * @return int
     */
    Integer countProjectFunctionByProjectId(Integer id);

    /**
     * 通过项目id查询功能点数量
     * @return
     */
    Integer countByProjectIdAndStatus(@Param("id")Integer id,@Param("functionStatus")Integer functionStatus);

    /**
     * 通过项目id查询全部已取消功能点数量
     * @return
     */
    Integer countDelByProjectId(@Param("id")Integer id);

    /**
     * 分页--通过项目id获得项目计划
     * @return
     */
    List<ProjectFunction> getProjectPlanFunctionsPage(@Param("projectsId")Integer projectsId, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);


}