package com.edu.lingnan.dao;

import com.edu.lingnan.entity.UserCodeUpdateRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserCodeUpdateRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:18:43
 */
@Mapper
@Repository
public interface UserCodeUpdateRecordDao extends BaseDao<UserCodeUpdateRecord>{

    /**
     * 查找用户所有贡献图
     * @param userId
     * @return
     */
    List<UserCodeUpdateRecord> getAllByUserId(@Param("userId") Integer userId);


}