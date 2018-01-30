package com.daily.controller;

import com.daily.domain.Account;
import com.daily.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjiangtao
 * @date 2017/12/28
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/getOrderInfo")
    public String getOrderInfo(@RequestParam String userId){
        Account account = accountMapper.selectByPrimaryKey(userId);
        return "用户ID:" + account.getUserId() + ", 总金额:" + account.getTotalMoney();
    }

    @RequestMapping("/getAccountId")
    public String getAccountId(){
        String accountId = accountMapper.getOrderInfo();
        return "用户电子账户ID:"+accountId;
    }
}
