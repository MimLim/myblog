package com.marlee.myblog.dao;

import com.marlee.myblog.entity.UserContent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserContentDao {


    /**
     * 根据用户id查询出梦分类
     * @param uid
     * @return
     */
    List<UserContent> findCategoryByUid(@Param("uid")long uid);

    /**
     *  插入文章并返回主键id 返回类型只是影响行数  id在UserContent对象中
     * @param userContent
     * @return
     */
    int inserContent(UserContent userContent);

    /**
     * user_content与user连接查询
     * @return
     */
    List<UserContent> findByJoin(UserContent userContent);

}
