package com.daily.mapper;

import com.daily.domain.Account;

/**
 * @author wangjiangtao
 * @date 2017/12/28
 **/
public interface AccountMapper {

    Account selectByPrimaryKey(String userId);

    String getOrderInfo();
}
