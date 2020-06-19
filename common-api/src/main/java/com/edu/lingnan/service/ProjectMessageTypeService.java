package com.edu.lingnan.service;

import com.edu.lingnan.entity.ProjectMessageType;
import java.util.List;

/**
 * (ProjectMessageType)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:17:59
 */
public interface ProjectMessageTypeService {

    /**
     * 通过消息码得到消息类型
     * @param id
     * @return
     */
    ProjectMessageType getById(Integer id);


}