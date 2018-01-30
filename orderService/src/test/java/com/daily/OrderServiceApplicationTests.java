package com.daily;

import com.daily.domain.Account;
import com.daily.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceApplicationTests {

	@Autowired
	private AccountMapper accountMapper;

	@Test
	public void contextLoads() {
		Account account = accountMapper.selectByPrimaryKey("p_273");
		System.out.println(account.getTotalMoney());
	}

	public long addMyself(long x){
		if (x == 1 || x == 2) return 1;
		return addMyself(x-1) + addMyself(x -2);
	}

	@Test
	public void test(){
		System.out.println(addMyself(3));
		System.out.println(addMyself(4));
		System.out.println(addMyself(5));

		for (int i = 1; i < 100; i++) {
			System.out.println("i === " + i + " f(i) ====" + addMyself(i));
		}
	}

}
