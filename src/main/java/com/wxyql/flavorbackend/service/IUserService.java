package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.beans.UsersInfo;
import com.wxyql.flavorbackend.entity.User;

/**
 * xxx
 * @author wxy
 */

public interface IUserService extends IService<User> {

    /**
     * <p>用户注册</p>
     *
     * @return 添加成功 1, 否则0
     */
    int addUser(User user);

    /**
     * <p>用户登录</p>
     *
     * @return 成功 1, 否则 0
     */
    int login(Integer id, String password);

    /**
     * <p>根据用户id获取对应用户信息</p>
     *
     * @return 用户信息
     */
    User getUserById(Integer id);

    /**
     * <p>修改用户密码</p>
     *
     * @return 成功 1, 否则0
     */
    int revisePassword(Integer id, String newPassword);

    /**
     * <p>修改用户电话</p>
     *
     * @return 成功 1, 否则0
     */
    int reviseTelephone(Integer id, String newTelephone);

    /**
     * <p>修改用户简介</p>
     *
     * @return 成功 1, 否则0
     */
    int reviseIntro(Integer id, String newIntro);

    /**
     * <p>获取所有用户的信息</p>
     *
     * @return 用户信息
     */
    UsersInfo getAllUsers();
}
