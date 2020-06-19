package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectUserDuty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectUserDuty)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:59
 */
@Mapper
@Repository
public interface ProjectUserDutyDao extends BaseDao<ProjectUserDuty>{

    ProjectUserDuty getById(Integer id);


}