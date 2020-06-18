package com.edu.lingnan.feign;

import com.edu.lingnan.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 20:14:41
 */
@Component
@FeignClient(value = "PRODIVER-USER")
public interface SysUserFeignService {

    @GetMapping("/sysUser/{id}")
    SysUser getSysUser(@PathVariable("id") Integer id);

    @GetMapping("/sysUser/getUserCount")
    Integer getUserCount();

//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<SysUser> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param sysUser 实例对象
//     * @return 实例对象
//     */
//    SysUser insert(SysUser sysUser);
//
//    /**
//     * 修改数据
//     *
//     * @param sysUser 实例对象
//     * @return 实例对象
//     */
//    SysUser update(SysUser sysUser);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}