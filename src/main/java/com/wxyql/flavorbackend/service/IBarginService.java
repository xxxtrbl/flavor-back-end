package com.wxyql.flavorbackend.service;

import com.wxyql.flavorbackend.entity.Bargin;

public interface IBarginService {

    /**
     * <p>添加交易成功的响应</p>
     *
     * @return 添加成功返回1, 否则0
     */
    int AddBargin(Bargin bargin);
}
