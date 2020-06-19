package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserClick;
import java.util.List;

/**
 * (UserClick)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:31
 */
public interface UserClickService {

    /**
     * 查询一条点击记录
     *
     * @return
     */
    UserClick getUserClickByUserIdAndProjectId(Integer userId, Integer projectId);


    /**
     * 删除点击记录
     *
     * @return
     */
    boolean deleteUserClick(Integer userId, Integer projectId);

    /**
     * 还原点击记录
     *
     * @return
     */
    boolean reductionUserClick(Integer userId, Integer projectId);

    /**
     * 查询项目点击次数
     *
     * @return
     */
    Integer getCountProjectByClick(Integer id);

    /**
     * 新增数据
     *
     * @param userClick 实例对象
     * @return 实例对象
     */
    Boolean insert(UserClick userClick);


}