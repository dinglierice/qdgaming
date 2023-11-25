package com.qdgaming.domain.biz.user.service;

import com.qdgaming.domain.biz.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;
}
