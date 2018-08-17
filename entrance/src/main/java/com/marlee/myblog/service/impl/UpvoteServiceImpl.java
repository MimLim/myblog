package com.marlee.myblog.service.impl;

import com.marlee.myblog.entity.Upvote;
import com.marlee.myblog.service.UpvoteService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Liming
 * @Date: 2018/8/16 15:36
 * @Description:
 */
@Service
public class UpvoteServiceImpl implements UpvoteService{

    @Override
    public Upvote findByUidAndConId(Upvote upvote) {
        return null;
    }

    @Override
    public int add(Upvote upvote) {
        return 0;
    }

    @Override
    public Upvote getByUid(Upvote upvote) {
        return null;
    }

    @Override
    public void update(Upvote upvote) {

    }

    @Override
    public void deleteByContentId(Long cid) {

    }
}
