package com.marlee.myblog.dao;

import com.marlee.myblog.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserInfoDao extends Mapper<User>{
}

