package com.daily;

import com.daily.service.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();

    private final static String url = "http://localhost:8099/order/getOrderInfo?userId=p_273";

    private final static String url2 = "http://localhost:8099/order/getAccountId";

    private final static Integer bulletCount = 100;

    private CountDownLatch latch = new CountDownLatch(bulletCount);

    private CyclicBarrier cb = new CyclicBarrier(bulletCount);

    Executor executor = Executors.newFixedThreadPool(100);

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        for (int i = 0; i < bulletCount; i++) {
            executor.execute(new SendMessage());
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class SendMessage implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ready!");
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(restTemplate.getForEntity(url, String.class));
            rabbitSender.sendRabbitMsg("exchange.demo", "topic.order", "p_273");
        }
    }

}
