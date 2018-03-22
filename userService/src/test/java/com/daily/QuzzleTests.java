package com.daily;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.daily.quzzle.HttpClient;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuzzleTests {


    @Test
    public void test() {
        Map map = new HashMap();
        int n = 1;
        map.put("page", n+ "");
        map.put("per_page", "10");
        String result = HttpClient.sendGetRequest("http://apis-puzzle-test.zaih.com/panel/questions",map,"utf-8");
        while (! StringUtils.isEmpty(result)){
            map.put("page", n++ + "");
            result = HttpClient.sendGetRequest("http://apis-puzzle-test.zaih.com/panel/questions",map,"utf-8");
            List<Map> resutls = Lists.newArrayList();
            try {
                resutls = JSONObject.parseArray(result, Map.class);
                JSONArray ops = null;
                for (Map re : resutls){
                    System.out.println(re.get("content"));
                    ops = (JSONArray) re.get("options");
                    Map os = (Map)ops.get(0);
                    System.out.println(os.get("value"));
                }
            } catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }

}
