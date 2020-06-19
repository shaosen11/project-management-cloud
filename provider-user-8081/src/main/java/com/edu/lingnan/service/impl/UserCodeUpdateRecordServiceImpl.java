package com.edu.lingnan.service.impl;

import com.edu.lingnan.entity.UserCodeUpdateRecord;
import com.edu.lingnan.dao.UserCodeUpdateRecordDao;
import com.edu.lingnan.feign.UserCodeUpdateRecordFeignService;
import com.edu.lingnan.service.UserCodeUpdateRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserCodeUpdateRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 21:18:43
 */
@Service("userCodeUpdateRecordService")
public class UserCodeUpdateRecordServiceImpl implements UserCodeUpdateRecordService {
    @Resource
    private UserCodeUpdateRecordDao userCodeUpdateRecordDao;


    @Override
    public List<UserCodeUpdateRecord> getAllByUserId(Integer userId) {
        return userCodeUpdateRecordDao.getAllByUserId(userId);
    }
}