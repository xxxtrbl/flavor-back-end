package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.UsersInfo;
import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.mapper.IUserMapper;
import com.wxyql.flavorbackend.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 用户管理
 * @author yql
 */

@Service
public class UserService extends ServiceImpl<IUserMapper, User> implements IUserService {
    /**
     * <p>用户注册</p>
     *
     * @return 添加成功 1, 否则0
     */
    public int SignUp(User user){
        return 0;
    }

    /**
     * <p>用户登录</p>
     *
     * @return 成功 1, 否则 0
     */
    public int LogIn(String nickname, String password){
        return 0;
    }

    /**
     * <p>根据用户名获取对应用户信息</p>
     *
     * @return 用户信息
     */
    public User GetUserById(String nickname){
        return null;
    }

    /**
     * <p>修改用户密码</p>
     *
     * @return 成功 1, 否则0
     */
    public int RevisePassword(Integer id, String newPassword){
        return 0;
    }

    /**
     * <p>修改用户电话</p>
     *
     * @return 成功 1, 否则0
     */
    public int ReviseTelephone(Integer id, String newTelephone){
        return 0;
    }

    /**
     * <p>修改用户简介</p>
     *
     * @return 成功 1, 否则0
     */
    public int ReviseIntro(Integer id, String newIntro){
        return 0;
    }

    /**
     * <p>获取所有用户的信息</p>
     *
     * @return 用户信息
     */
    public UsersInfo GetAllUsers(){
        return null;
    }
}
