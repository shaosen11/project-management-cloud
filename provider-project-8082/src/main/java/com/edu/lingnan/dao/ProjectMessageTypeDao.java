package com.edu.lingnan.dao;

import com.edu.lingnan.entity.ProjectMessageType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (ProjectMessageType)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:17:07
 */
@Mapper
@Repository
public interface ProjectMessageTypeDao extends BaseDao<ProjectMessageType>{

    /**
     * 通过消息码得到消息类型
     * @param id
     * @return
     */
    ProjectMessageType getById(Integer id);


}