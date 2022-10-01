package com.wxyql.flavorbackend.beans;

import com.wxyql.flavorbackend.entity.User;
import lombok.Data;

import java.util.List;
@Data
public class UsersInfo {
    private List<User> Users;
}
