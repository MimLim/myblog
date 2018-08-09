package com.marlee.myblog.service.impl;

import com.marlee.myblog.common.PageHelper;
import com.marlee.myblog.entity.Comment;
import com.marlee.myblog.entity.UserContent;
import com.marlee.myblog.service.UserContentService;

public class UserContentServiceImpl implements UserContentService {
    @Override
    public PageHelper.Page<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public PageHelper.Page<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public PageHelper.Page<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize) {
        return null;
    }
}
