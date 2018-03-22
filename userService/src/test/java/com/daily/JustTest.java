package com.daily;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 仅仅是test
 *
 * @author wangjiangtao
 * @date 2018/01/31
 **/
public class JustTest {

    @Test
    public void test(){
        String jsonStr = "[{\n" +
                "\t\"content\": \"在《LoveLive!Sunshine!!》中，偶像组合\"\n" +
                "\tSaint Snow \"来自哪个城市？\",\n" +
                "\t\"creator\": {},\n" +
                "\t\"creator_id\": \"1\",\n" +
                "\t\"date_created\": \"2018-01-26T10:52:46.153635+00:00\",\n" +
                "\t\"id\": \"6038080396984273\",\n" +
                "\t\"is_hidden\": false,\n" +
                "\t\"level\": 3,\n" +
                "\t\"operator_id\": \"1\",\n" +
                "\t\"options\": [{\n" +
                "\t\t\"is_checked\": true,\n" +
                "\t\t\"value\": \"函馆\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"札幌\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"东京\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"沼津\"\n" +
                "\t}],\n" +
                "\t\"status\": \"succeed\",\n" +
                "\t\"themes\": [{\n" +
                "\t\t\"creator_id\": \"1\",\n" +
                "\t\t\"date_created\": \"2018-02-06T11:05:00.138539+00:00\",\n" +
                "\t\t\"icon\": \"https://medias.zaih.com/88e24c923457c75dad8ceb3e0d32_261x261.png\",\n" +
                "\t\t\"id\": \"338063573227399\",\n" +
                "\t\t\"name\": \"军事\",\n" +
                "\t\t\"order_score\": 4987,\n" +
                "\t\t\"settings\": {\n" +
                "\t\t\t\"dan_grades\": [{\n" +
                "\t\t\t\t\"name\": \"勤奋书生\",\n" +
                "\t\t\t\t\"share_desc\": \"天生我材必有用，什么时候用得上不一定。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"聪慧秀才\",\n" +
                "\t\t\t\t\"share_desc\": \"天下才有一石，你独占八斗。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文武状元\",\n" +
                "\t\t\t\t\"share_desc\": \"数英雄人物，还是你骚。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"专精大师\",\n" +
                "\t\t\t\t\"share_desc\": \"术业有专攻，这块你最凶。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"万卷宗师\",\n" +
                "\t\t\t\t\"share_desc\": \"行走的书橱，人肉的题库。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"旷世奇才\",\n" +
                "\t\t\t\t\"share_desc\": \"才华过人年纪轻，天下谁人不识君。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"无双国士\",\n" +
                "\t\t\t\t\"share_desc\": \"良才不隐世，天才难低调。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文曲下凡\",\n" +
                "\t\t\t\t\"share_desc\": \"绝世独孤，但求一败。\"\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"grades\": [{\n" +
                "\t\t\t\t\"award\": 100000,\n" +
                "\t\t\t\t\"end_num\": 5,\n" +
                "\t\t\t\t\"name\": \"一等奖\",\n" +
                "\t\t\t\t\"start_num\": 1\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 50000,\n" +
                "\t\t\t\t\"end_num\": 10,\n" +
                "\t\t\t\t\"name\": \"二等奖\",\n" +
                "\t\t\t\t\"start_num\": 6\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 1000,\n" +
                "\t\t\t\t\"end_num\": 500,\n" +
                "\t\t\t\t\"name\": \"三等奖\",\n" +
                "\t\t\t\t\"start_num\": 11\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"is_show_dan\": true,\n" +
                "\t\t\t\"numbers\": 100,\n" +
                "\t\t\t\"share_icon\": \"https://medias.zaih.com/009dda961b91f9a99e81b3266c0a_500x400.png\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": \"release\"\n" +
                "\t}],\n" +
                "\t\"tips\": \"\"\n" +
                "},{\n" +
                "\t\"content\": \"在《LoveLive!Sunshine!!》中，偶像组合\"\n" +
                "\tSaint Snow \"来自哪个城市？\",\n" +
                "\t\"creator\": {},\n" +
                "\t\"creator_id\": \"1\",\n" +
                "\t\"date_created\": \"2018-01-26T10:52:46.153635+00:00\",\n" +
                "\t\"id\": \"6038080396984273\",\n" +
                "\t\"is_hidden\": false,\n" +
                "\t\"level\": 3,\n" +
                "\t\"operator_id\": \"1\",\n" +
                "\t\"options\": [{\n" +
                "\t\t\"is_checked\": true,\n" +
                "\t\t\"value\": \"函馆\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"札幌\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"东京\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"沼津\"\n" +
                "\t}],\n" +
                "\t\"status\": \"succeed\",\n" +
                "\t\"themes\": [{\n" +
                "\t\t\"creator_id\": \"1\",\n" +
                "\t\t\"date_created\": \"2018-02-06T11:05:00.138539+00:00\",\n" +
                "\t\t\"icon\": \"https://medias.zaih.com/88e24c923457c75dad8ceb3e0d32_261x261.png\",\n" +
                "\t\t\"id\": \"338063573227399\",\n" +
                "\t\t\"name\": \"军事\",\n" +
                "\t\t\"order_score\": 4987,\n" +
                "\t\t\"settings\": {\n" +
                "\t\t\t\"dan_grades\": [{\n" +
                "\t\t\t\t\"name\": \"勤奋书生\",\n" +
                "\t\t\t\t\"share_desc\": \"天生我材必有用，什么时候用得上不一定。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"聪慧秀才\",\n" +
                "\t\t\t\t\"share_desc\": \"天下才有一石，你独占八斗。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文武状元\",\n" +
                "\t\t\t\t\"share_desc\": \"数英雄人物，还是你骚。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"专精大师\",\n" +
                "\t\t\t\t\"share_desc\": \"术业有专攻，这块你最凶。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"万卷宗师\",\n" +
                "\t\t\t\t\"share_desc\": \"行走的书橱，人肉的题库。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"旷世奇才\",\n" +
                "\t\t\t\t\"share_desc\": \"才华过人年纪轻，天下谁人不识君。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"无双国士\",\n" +
                "\t\t\t\t\"share_desc\": \"良才不隐世，天才难低调。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文曲下凡\",\n" +
                "\t\t\t\t\"share_desc\": \"绝世独孤，但求一败。\"\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"grades\": [{\n" +
                "\t\t\t\t\"award\": 100000,\n" +
                "\t\t\t\t\"end_num\": 5,\n" +
                "\t\t\t\t\"name\": \"一等奖\",\n" +
                "\t\t\t\t\"start_num\": 1\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 50000,\n" +
                "\t\t\t\t\"end_num\": 10,\n" +
                "\t\t\t\t\"name\": \"二等奖\",\n" +
                "\t\t\t\t\"start_num\": 6\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 1000,\n" +
                "\t\t\t\t\"end_num\": 500,\n" +
                "\t\t\t\t\"name\": \"三等奖\",\n" +
                "\t\t\t\t\"start_num\": 11\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"is_show_dan\": true,\n" +
                "\t\t\t\"numbers\": 100,\n" +
                "\t\t\t\"share_icon\": \"https://medias.zaih.com/009dda961b91f9a99e81b3266c0a_500x400.png\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": \"release\"\n" +
                "\t}],\n" +
                "\t\"tips\": \"\"\n" +
                "}, {\n" +
                "\t\"content\": \"在《LoveLive!》中，以下哪个角色不是A-RISE的成员？\",\n" +
                "\t\"creator\": {},\n" +
                "\t\"creator_id\": \"1\",\n" +
                "\t\"date_created\": \"2018-01-26T10:52:46.153635+00:00\",\n" +
                "\t\"id\": \"6038080396983253\",\n" +
                "\t\"is_hidden\": false,\n" +
                "\t\"level\": 3,\n" +
                "\t\"operator_id\": \"1\",\n" +
                "\t\"options\": [{\n" +
                "\t\t\"is_checked\": true,\n" +
                "\t\t\"value\": \"鹿角圣良\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"绮罗翼\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"统堂英玲奈\"\n" +
                "\t}, {\n" +
                "\t\t\"is_checked\": false,\n" +
                "\t\t\"value\": \"优木杏树\"\n" +
                "\t}],\n" +
                "\t\"status\": \"succeed\",\n" +
                "\t\"themes\": [{\n" +
                "\t\t\"creator_id\": \"1\",\n" +
                "\t\t\"date_created\": \"2018-02-06T11:05:00.138539+00:00\",\n" +
                "\t\t\"icon\": \"https://medias.zaih.com/88e24c923457c75dad8ceb3e0d32_261x261.png\",\n" +
                "\t\t\"id\": \"338063573227399\",\n" +
                "\t\t\"name\": \"军事\",\n" +
                "\t\t\"order_score\": 4987,\n" +
                "\t\t\"settings\": {\n" +
                "\t\t\t\"dan_grades\": [{\n" +
                "\t\t\t\t\"name\": \"勤奋书生\",\n" +
                "\t\t\t\t\"share_desc\": \"天生我材必有用，什么时候用得上不一定。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"聪慧秀才\",\n" +
                "\t\t\t\t\"share_desc\": \"天下才有一石，你独占八斗。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文武状元\",\n" +
                "\t\t\t\t\"share_desc\": \"数英雄人物，还是你骚。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"专精大师\",\n" +
                "\t\t\t\t\"share_desc\": \"术业有专攻，这块你最凶。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"万卷宗师\",\n" +
                "\t\t\t\t\"share_desc\": \"行走的书橱，人肉的题库。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"旷世奇才\",\n" +
                "\t\t\t\t\"share_desc\": \"才华过人年纪轻，天下谁人不识君。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"无双国士\",\n" +
                "\t\t\t\t\"share_desc\": \"良才不隐世，天才难低调。\"\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"name\": \"文曲下凡\",\n" +
                "\t\t\t\t\"share_desc\": \"绝世独孤，但求一败。\"\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"grades\": [{\n" +
                "\t\t\t\t\"award\": 100000,\n" +
                "\t\t\t\t\"end_num\": 5,\n" +
                "\t\t\t\t\"name\": \"一等奖\",\n" +
                "\t\t\t\t\"start_num\": 1\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 50000,\n" +
                "\t\t\t\t\"end_num\": 10,\n" +
                "\t\t\t\t\"name\": \"二等奖\",\n" +
                "\t\t\t\t\"start_num\": 6\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"award\": 1000,\n" +
                "\t\t\t\t\"end_num\": 500,\n" +
                "\t\t\t\t\"name\": \"三等奖\",\n" +
                "\t\t\t\t\"start_num\": 11\n" +
                "\t\t\t}],\n" +
                "\t\t\t\"is_show_dan\": true,\n" +
                "\t\t\t\"numbers\": 100,\n" +
                "\t\t\t\"share_icon\": \"https://medias.zaih.com/009dda961b91f9a99e81b3266c0a_500x400.png\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": \"release\"\n" +
                "\t}],\n" +
                "\t\"tips\": \"\"\n" +
                "}]";
        String reg = "(?<=\"content\": \")[\\s\\S]*?(?=\",\n" +
                "\t\"creator\":)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(jsonStr);
        while (matcher.find()){
            if (matcher.group(0).contains("\"")){
                String replace = matcher.group(0).replace("\""," ");
                jsonStr = jsonStr.replace(matcher.group(0), replace);
            }
        }

        System.out.println(jsonStr);
        List<Map> resutls = JSONObject.parseArray(jsonStr, Map.class);
        JSONArray ops = null;
        for (Map re : resutls){
            System.out.println(re.get("content"));
            ops = (JSONArray) re.get("options");
            Map os = (Map)ops.get(0);
            System.out.println(os.get("value"));
        }
    }

    @Test
    public void test2(){
        String jsonStr = "";
        System.out.println(jsonStr);
        System.out.println(jsonString(jsonStr));
    }



    private static String jsonString(String s){
        char[] temp = s.toCharArray();
        int n = temp.length;
        for(int i =0;i<n;i++){
            if(temp[i]==':'&&temp[i+1]=='"'){
                for(int j =i+2;j<n;j++){
                    if(temp[j]=='"'){
                        if(temp[j+1]!=',' &&  temp[j+1]!='}'){
                            temp[j]='”';
                        }else if(temp[j+1]==',' ||  temp[j+1]=='}'){
                            break ;
                        }
                    }
                }
            }
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        int i = 100;
        while (i<1000){
            int x = i/100;
            int y = i%100/10;
            int z = i%10;
            int n = (2012 +i)/6;
            int x2 = n/100;
            int y2 = n%100/10;
            int z2 = n%10;

            if (x+y+z == x2+y2+z2 )
            {
                System.out.println(i);
            }
            i++;
        }
    }
}
