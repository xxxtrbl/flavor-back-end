package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.beans.UsersInfo;
import com.wxyql.flavorbackend.entity.User;

public interface IUserService extends IService<User> {

    /**
     * <p>用户注册</p>
     *
     * @return 添加成功 1, 否则0
     */
    int SignUp(User user);

    /**
     * <p>用户登录</p>
     *
     * @return 成功 1, 否则 0
     */
    int LogIn(String nickname, String password);

    /**
     * <p>根据用户名获取对应用户信息</p>
     *
     * @return 用户信息
     */
    User GetUserById(String nickname);

    /**
     * <p>修改用户密码</p>
     *
     * @return 成功 1, 否则0
     */
    int RevisePassword(Integer id, String newPassword);

    /**
     * <p>修改用户电话</p>
     *
     * @return 成功 1, 否则0
     */
    int ReviseTelephone(Integer id, String newTelephone);

    /**
     * <p>修改用户简介</p>
     *
     * @return 成功 1, 否则0
     */
    int ReviseIntro(Integer id, String newIntro);

    /**
     * <p>获取所有用户的信息</p>
     *
     * @return 用户信息
     */
    UsersInfo GetAllUsers();
}
