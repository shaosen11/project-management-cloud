package com.edu.lingnan.feign;

import com.edu.lingnan.entity.SysRoleMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (SysRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:36
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface SysRoleMenuFeignService {

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    SysRoleMenu queryById(Integer id);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<SysRoleMenu> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param sysRoleMenu 实例对象
//     * @return 实例对象
//     */
//    SysRoleMenu insert(SysRoleMenu sysRoleMenu);
//
//    /**
//     * 修改数据
//     *
//     * @param sysRoleMenu 实例对象
//     * @return 实例对象
//     */
//    SysRoleMenu update(SysRoleMenu sysRoleMenu);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}