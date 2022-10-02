package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.entity.Bargain;

/**
 * xxx
 * @author wxy
 */

public interface IBargainService extends IService<Bargain> {

    /**
     * <p>添加交易成功的响应</p>
     *
     * @return 添加成功返回1, 否则0
     */
    int addBargain(Bargain bargain);
}
