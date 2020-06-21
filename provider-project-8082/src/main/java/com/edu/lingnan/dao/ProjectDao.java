package com.edu.lingnan.dao;

import com.edu.lingnan.entity.MyProject;
import com.edu.lingnan.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Project)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:15:21
 */
@Mapper
@Repository
public interface ProjectDao extends BaseDao<Project>{

    /**
     * 查询一条项目信息
     * @return
     */
    Project getById(Integer id);

    /**
     * 查询一条没有被注销项目信息
     * @return
     */
    Project getByIdAndNoDel(Integer id);

    /**
     * 查询所有项目信息
     * @return
     */
    Project queryById(Integer id);

    /**
     * 查询所有项目信息
     * @return
     */
    List<Project> getProjectList();

    /**
     * 通过userId查询所有项目
     * @return
     */
    List<Project> getProjectListByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Project> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 删除项目
     * @return
     */
    boolean deleteProject(Integer id);


    /**
     * 还原项目
     * @return
     */
    boolean reductionProject(Integer id);

    /**
     * 查询所有已注销项目信息
     * @return
     */
    List<Project> getDelProjectList();

    /**
     * 查找项目负责人
     * @param userId
     * @param projectId
     * @return
     */
    Project getAdminByUserIdAndProjectId(Integer userId, Integer projectId);

    /**
     * 通过实体作为筛选条件查询
     * @param project 实例对象
     * @return 对象列表
     */
    List<Project> queryAll(Project project);

    /**
     * 统计项目数量
     * @return
     */
    Integer projectCount();
    /**
     * 查询所有已注销项目信息
     * @return
     */
    List<Project> getAllDelProject();

    /**
     * 统计项目数量
     * @return
     */
    Integer getProjectCount();
    /**
     * 查询我所有的项目进度数量(饼图1)
     *
     * @return
     */
    Integer getMyProjectNumBySchedule(@Param("userId") Integer userId, @Param("scheduleId") Integer scheduleId);

    /**
     * 查询我负责的项目进度数量(饼图1)
     *
     * @return
     */
    Integer getMyChargeProjectNumBySchedule(@Param("userId") Integer userId, @Param("scheduleId") Integer scheduleId);

    /**
     * 查询我参加的项目进度数量(饼图1)
     *
     * @return
     */
    Integer getMyJoinProjectNumBySchedule(@Param("userId") Integer userId, @Param("scheduleId") Integer scheduleId);

    /**
     * 查询我所有的项目数量
     * @return Integer
     */
    Integer getMyAllProjectNum(@Param("userId")Integer userId);

    /**
     * 查询我负责的项目数量
     * @return Integer
     */
    Integer getMyChargeProjectNum(@Param("userId")Integer userId);

    /**
     * 查询我参加的项目数量
     * @return Integer
     */
    Integer getMyJoinProjectNum(@Param("userId")Integer userId);

    /**
     * 分页--查询我的所有项目(user)
     * @return
     */
    List<MyProject> getMyAllProjectPage(@Param("userId")Integer userId, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    /**
     * 分页--查询我负责的项目
     * @return
     */
    List<MyProject> getMyChargeProjectPage(@Param("userId")Integer userId, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    boolean updateProjectClickNumber(Integer projectId);
    /**
     * 分页--查询我参加的项目
     * @return
     */
    List<MyProject> getMyJoinProjectPage(@Param("userId")Integer userId, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByTypeOrSchedule(@Param("offset")int offset, @Param("limit")int limit,@Param("myProject")MyProject myProject,@Param("userId")Integer userId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByTypeOrSchedule(@Param("myProject")MyProject myProject,@Param("userId")Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByTypeOrSchedule2(@Param("offset")int offset, @Param("limit")int limit,@Param("myProject")MyProject myProject,@Param("userId")Integer userId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByTypeOrSchedule2(@Param("myProject")MyProject myProject,@Param("userId")Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByFuzzySearch(@Param("offset")int offset, @Param("limit")int limit,@Param("content")String content,@Param("userId")Integer userId,@Param("chargeUserId")Integer chargeUserId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByFuzzySearch(@Param("content")String content,@Param("userId")Integer userId,@Param("chargeUserId")Integer chargeUserId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByFuzzySearch2(@Param("offset")int offset, @Param("limit")int limit,@Param("content")String content,@Param("userId")Integer userId,@Param("chargeUserId")Integer chargeUserId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByFuzzySearch2(@Param("content")String content,@Param("userId")Integer userId,@Param("chargeUserId")Integer chargeUserId);

    /**
     * 查询我收藏的项目的数量
     * @param userId
     * @return
     */
    Integer getMyProjectStoreNumByUserId(@Param("userId")Integer userId);

    /**
     * 分页查询我收藏的项目
     * @param userId
     * @param offset
     * @param pageSize
     * @return
     */
    List<MyProject> getMyProjectStorePageByUserId(@Param("userId")Integer userId, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);
}