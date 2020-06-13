package com.edu.lingnan.feign;

import com.edu.lingnan.entity.UserLike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (UserLike)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:15:04
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface UserLikeFeignService {

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    UserLike queryById(Integer id);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<UserLike> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param userLike 实例对象
//     * @return 实例对象
//     */
//    UserLike insert(UserLike userLike);
//
//    /**
//     * 修改数据
//     *
//     * @param userLike 实例对象
//     * @return 实例对象
//     */
//    UserLike update(UserLike userLike);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}