package com.daily.mapper;

import com.alicp.jetcache.anno.Cached;
import com.daily.domain.Account;

/**
 * @author wangjiangtao
 * @date 2017/12/28
 **/
public interface AccountMapper {

    @Cached(expire = 60)
    Account selectByPrimaryKey(String userId);

    String getOrderInfo();
}
