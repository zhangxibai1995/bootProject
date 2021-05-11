package com.bootproject.service.user;

import com.bootproject.core.model.PageData;
import com.bootproject.core.model.PageWrap;
import com.bootproject.dao.user.model.User;
import java.util.List;

/**
 * 示例Service定义
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
public interface UserService {

    /**
     * 创建
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    Integer create(User user);

    /**
     * 主键删除
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    void updateById(User user);

    /**
     * 批量主键更新
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    void updateByIdInBatch(List<User> users);

    /**
     * 主键查询
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    User findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    User findOne(User user);

    /**
     * 条件查询
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    List<User> findList(User user);

    /**
     * 分页查询
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    PageData<User> findPage(PageWrap<User> pageWrap);
    /**
     * 条件统计
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    long count(User user);
}