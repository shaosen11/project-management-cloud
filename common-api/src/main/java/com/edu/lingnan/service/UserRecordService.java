package com.edu.lingnan.service;

import com.edu.lingnan.entity.UserRecord;
import java.util.List;

/**
 * (UserRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 11:16:56
 */
public interface UserRecordService {



    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    boolean insert(UserRecord userRecord);



}