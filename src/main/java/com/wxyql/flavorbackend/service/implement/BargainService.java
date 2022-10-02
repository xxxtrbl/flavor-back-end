package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.mapper.IBargainMapper;
import com.wxyql.flavorbackend.service.IBargainService;
import org.springframework.stereotype.Service;

/**
 * 交易管理
 * @author yql
 */

@Service
public class BargainService extends ServiceImpl<IBargainMapper, Bargain> implements IBargainService {
    @Override
    public int addBargain(Bargain bargain) {
        save(bargain);
        return 1;
    }
}
