package com.wyeye.eduservice.service.impl;

import com.wyeye.eduservice.entity.User;
import com.wyeye.eduservice.mapper.UserMapper;
import com.wyeye.eduservice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyeye
 * @since 2020-11-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
