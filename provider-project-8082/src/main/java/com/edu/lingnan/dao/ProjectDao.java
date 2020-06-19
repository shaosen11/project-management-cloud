package com.edu.lingnan.dao;

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
    List<Project> getProjectList();

    /**
     * 通过userId查询所有项目
     * @return
     */
    List<Project> getProjectListByUserId(Integer userId);


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
     * 查询所有已注销项目信息
     * @return
     */
    List<Project> getAllDelProject();

    /**
     * 统计项目数量
     * @return
     */
    Integer getProjectCount();

    boolean updateProjectClickNumber(Integer projectId);

//    /**
//     * 查询所有项目主页信息
//     * @return
//     */
//    List<ProjectRecommendation> getProject(Integer userId, Integer pageNum, Integer pageSize);
//
//    /**
//     * 查询当前推荐商品信息
//     * @return
//     */
//    List<ProjectRecommendation> getRecommendedCommodities(Integer userId,Integer projectId);
//
//
//
//    /**
//     * 获得今日点击量最多的项目信息。
//     * @return
//     */
//    List<Project> getTodayProject();
//
//    /**
//     * 获得本周点击量以及收藏人数最多的项目信息。
//     * @return
//     */
//    List<Project> getWeekProject();
//
//    /**
//     * 统计项目的记录数
//     * @return
//     */
//    Integer countProjectRecommendation();
//
//    /**
//     * 查询所有指定类型的项目
//     * @return
//     */
//    List<ProjectRecommendation> getProjectByType(Integer pageNum, Integer pageSize,String type);
//
//    /**
//     * 统计指定类型的项目数
//     * @return
//     */
//    Integer countProjectNumberByType(String type);
//

//
//    /**
//     * 根据关键字模糊查询项目名
//     * @return
//     */
//    List<String> getProjectNameByWord(String word);
//
//    /**
//     * 根据关键字模糊查询项目类型
//     * @return
//     */
//    List<String> getTypeByWord(String word);
//
//    /**
//     * 根据关键字模糊查询用户名
//     * @return
//     */
//    List<String> getUserNameByWord(String word);
//
//    /**
//     * 根据关键字统计项目数
//     * @return
//     */
//    Integer countProjectByWord(String word);
//
//    /**
//     * 根据关键字模糊查询所有项目
//     * @return
//     */
//    List<ProjectRecommendation> getMyProjectByWord(String word,Integer pageNum, Integer pageSize);
}