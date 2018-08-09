package com.marlee.myblog.service;

import com.marlee.myblog.common.PageHelper;
import com.marlee.myblog.entity.Comment;
import com.marlee.myblog.entity.UserContent;

public interface UserContentService {

    /**
     * 查询所有Content并分页
     * @param content
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<UserContent> findAll(UserContent content, Integer pageNum, Integer pageSize);
    PageHelper.Page<UserContent> findAll(UserContent content, Comment comment, Integer pageNum, Integer pageSize);
    PageHelper.Page<UserContent> findAllByUpvote(UserContent content, Integer pageNum, Integer pageSize);
}
