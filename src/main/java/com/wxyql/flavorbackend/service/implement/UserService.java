package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.UsersInfo;
import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.mapper.IUserMapper;
import com.wxyql.flavorbackend.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int addUser(User user){
        save(user);
        return 1;
    }

    /**
     * <p>用户登录</p>
     *
     * @return 成功 1, 否则 0
     */
    public int login(Integer id, String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);

        User user = getOne(wrapper);

        if(user == null){
            return 0;
        }
        else if(!user.getPassword().equals(password)){
            return 0;
        }
        return 1;
    }

    /**
     * <p>根据用户id获取对应用户信息</p>
     *
     * @return 用户信息
     */
    public User getUserById(Integer id){
        User user = getById(id);
        return user;
    }

    /**
     * <p>修改用户密码</p>
     *
     * @return 成功 1, 否则0
     */
    public int revisePassword(Integer id, String newPassword){
        User user = getById(id);

        if(user == null){
            return 0;
        }

        user.setPassword(newPassword);

        saveOrUpdate(user);

        return 1;
    }

    /**
     * <p>修改用户电话</p>
     *
     * @return 成功 1, 否则0
     */
    public int reviseTelephone(Integer id, String newTelephone){
        User user = getById(id);

        if(user == null){
            return 0;
        }

        user.setPhone(newTelephone);

        saveOrUpdate(user);

        return 1;
    }

    /**
     * <p>修改用户简介</p>
     *
     * @return 成功 1, 否则0
     */
    public int reviseIntro(Integer id, String newIntro){
        User user = getById(id);

        if(user == null){
            return 0;
        }

        user.setIntro(newIntro);

        saveOrUpdate(user);

        return 1;
    }

    /**
     * <p>获取所有用户的信息</p>
     *
     * @return 用户信息
     */
    public UsersInfo getAllUsers(){
        UsersInfo result = new UsersInfo();

        result.setUsers(list());

        return result;
    }
}
