package com.edu.lingnan.dao;

import com.edu.lingnan.entity.PersistentLogins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (PersistentLogins)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 14:59:21
 */
@Mapper
@Repository
public interface PersistentLoginsDao extends BaseDao<PersistentLogins>{

    /**
     * 通过ID查询单条数据
     *
     * @param series 主键
     * @return 实例对象
     */
    PersistentLogins queryById(String series);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersistentLogins> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param persistentLogins 实例对象
     * @return 对象列表
     */
    List<PersistentLogins> queryAll(PersistentLogins persistentLogins);


}