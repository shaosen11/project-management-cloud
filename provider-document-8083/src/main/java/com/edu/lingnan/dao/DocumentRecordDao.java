package com.edu.lingnan.dao;

import com.edu.lingnan.entity.DocumentRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DocumentRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 21:20:06
 */
@Mapper
@Repository
public interface DocumentRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocumentRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DocumentRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param documentRecord 实例对象
     * @return 对象列表
     */
    List<DocumentRecord> queryAll(DocumentRecord documentRecord);

    /**
     * 新增数据
     *
     * @param documentRecord 实例对象
     * @return 影响行数
     */
    int insert(DocumentRecord documentRecord);

    /**
     * 修改数据
     *
     * @param documentRecord 实例对象
     * @return 影响行数
     */
    int update(DocumentRecord documentRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}