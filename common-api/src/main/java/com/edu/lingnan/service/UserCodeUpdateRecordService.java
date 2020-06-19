package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserCodeUpdateRecord;
import java.util.List;

/**
 * (UserCodeUpdateRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:36
 */
public interface UserCodeUpdateRecordService {

    /**
     * 查找用户所有贡献图
     * @param userId
     * @return
     */
    List<UserCodeUpdateRecord> getAllByUserId(Integer userId);


}