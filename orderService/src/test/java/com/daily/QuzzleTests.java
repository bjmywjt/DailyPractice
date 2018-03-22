package com.daily;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.daily.domain.Question;
import com.daily.mapper.QuestionMapper;
import com.daily.util.HttpClient;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuzzleTests {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void test() {
        Map map = new HashMap();
        int n = 1;
        map.put("page", n+ "");
        map.put("per_page", "100");
        String result = HttpClient.sendGetRequest("http://apis-puzzle-test.zaih.com/panel/questions",map,"utf-8");
        List<Question> questions = Lists.newArrayList();
        Question question = null;
        while (n < 210){
            map.put("page", n++ + "");
            result = HttpClient.sendGetRequest("http://apis-puzzle-test.zaih.com/panel/questions",map,"utf-8");
            List<Map> resutls = Lists.newArrayList();
            try {
                String reg = "(?<=\"content\": \")[\\s\\S]*?(?=\",\n" +
                        "\t\"creator\":)";
//                String reg2 = "(?<=\"tips\": \")[\\s\\S]*?(?=\")";
                Pattern pattern = Pattern.compile(reg);

                Matcher matcher = pattern.matcher(result);
                while (matcher.find()){
                    if (matcher.group(0).contains("\"")){
                        String replace = matcher.group(0).replace("\""," ");
                        result = result.replace(matcher.group(0), replace);
                    }
                }
                result = result.replace("\"tips\": \"\"", "\"tips\": \"123。\"");

                String reg2 = "(?<=\"tips\": \")[\\s\\S]*?(?=\"\\}, \\{\"content\")";
                Pattern pattern2 = Pattern.compile(reg2);
                Matcher matcher2 = pattern2.matcher(result);
                while (matcher2.find()){
                    if (matcher2.group(0).contains("\"")){
                        String replace = matcher2.group(0).replace("\""," ");
                        result = result.replace(matcher2.group(0), replace);
                    }
                }
                resutls = JSONObject.parseArray(result, Map.class);
                JSONArray ops = null;
                for (Map re : resutls){
                    question = new Question();
                    System.out.println(re.get("content"));
                    question.setQuestion(re.get("content").toString());
                    ops = (JSONArray) re.get("options");
                    Map os = (Map)ops.get(0);
                    System.out.println(os.get("value"));
                    question.setAnswer(os.get("value").toString());
                    questions.add(question);
                }
            } catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }
        if (! CollectionUtils.isEmpty(questions)){
            questionMapper.batchInsert(questions);
        }
    }

}
