package com.edu.lingnan.service;

import com.edu.lingnan.entity.MyProject;
import com.edu.lingnan.entity.Project;
import java.util.List;

/**
 * (Project)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:24
 */
public interface ProjectService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Project queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Project> queryAllByLimit(int offset, int limit);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<Project> queryAll(Project project);

    /**
     * 新增数据
     *
     * @param project 实例对象
     * @return 实例对象
     */
    Boolean insert(Project project);

    /**
     * 修改数据
     * @param project 实例对象
     * @return 实例对象
     */
    Boolean update(Project project);

    /**
     * 查询所有已注销项目信息
     * @return list
     */
    List<Project> getAllDelProject();


    /**
     * 统计系统项目数量
     * @return
     */
    Integer projectCount();

    /**
     * 查询我所有的项目进度数量(饼图)
     * @return Integer
     */
    Integer getMyProjectNumBySchedule(Integer userId,Integer scheduleId);

    /**
     * 查询我负责的项目进度数量(饼图)
     * @return Integer
     */
    Integer getMyChargeProjectNumBySchedule(Integer userId,Integer scheduleId);

    /**
     * 查询我参加的项目进度数量(饼图)
     * @return Integer
     */
    Integer getMyJoinProjectNumBySchedule(Integer userId,Integer scheduleId);

    /**
     * 查询我所有的项目数量
     * @return Integer
     */
    Integer getMyAllProjectNum(Integer userId);

    /**
     * 查询我负责的项目数量
     * @return Integer
     */
    Integer getMyChargeProjectNum(Integer userId);

    /**
     * 查询我参加的项目数量
     * @return Integer
     */
    Integer getMyJoinProjectNum(Integer userId);

    /**
     * 分页--查询我的所有项目
     * @return
     */
    List<MyProject> getMyAllProjectPage(Integer userId, Integer offset, Integer pageSize);

    /**
     * 分页--查询我负责的项目
     * @return
     */
    List<MyProject> getMyChargeProjectPage(Integer userId,Integer offset,Integer pageSize);

    /**
     * 分页--查询我参与的项目
     * @return
     */
    List<MyProject> getMyJoinProjectPage(Integer userId,Integer offset,Integer pageSize);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByTypeOrSchedule(int offset, int limit,MyProject myProject,Integer userId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByTypeOrSchedule(MyProject myProject,Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByTypeOrSchedule2(int offset, int limit,MyProject myProject,Integer userId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByTypeOrSchedule2(MyProject myProject,Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByFuzzySearch(int offset,int limit,String content,Integer userId,Integer chargeUserId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByFuzzySearch(String content,Integer userId,Integer chargeUserId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyProject> queryMyProjectPageByFuzzySearch2(int offset,int limit,String content,Integer userId,Integer chargeUserId);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    List<MyProject> queryMyProjectByFuzzySearch2(String content,Integer userId,Integer chargeUserId);

    /**
     * 查询我收藏的项目的数量
     * @return
     */
    Integer getMyProjectStoreNumByUserId(Integer userId);

    /**
     * 分页查询我收藏的项目
     * @return
     */
    List<MyProject> getMyProjectStorePageByUserId(Integer userId, Integer offset, Integer pageSize);
}