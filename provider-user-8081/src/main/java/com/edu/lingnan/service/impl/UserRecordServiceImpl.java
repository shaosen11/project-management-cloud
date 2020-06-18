package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserRecord;
import com.edu.lingnan.dao.UserRecordDao;
import com.edu.lingnan.feign.UserRecordFeignService;
import com.edu.lingnan.service.UserRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:19:02
 */
@Service("userRecordService")
public class UserRecordServiceImpl implements UserRecordService {
    @Resource
    private UserRecordDao userRecordDao;


    /**
     * 新增数据
     *
     * @param userRecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(UserRecord userRecord) {
        this.userRecordDao.insert(userRecord);
        return true;
    }


}