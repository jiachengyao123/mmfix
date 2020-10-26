package com.buba;

import com.alibaba.fastjson.JSON;
import com.buba.mapper.UserMapper;
import com.buba.pojo.User;
import com.buba.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeseOne {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Test
    public void update(){
        User user = new User();
        user.setId(5L).setUserName("贾成遥222");
        userService.saveOrUpdate(user);
    }
    @Test
    public void insert(){
        User user = new User();
        user.setUserName("潘超");
        userMapper.insert(user);
        Set set=new HashSet();
        List<Object> list = new ArrayList<>();
        list.forEach(item->{
            System.out.println(item);
        });
        Map<Object, Object> hash = new HashMap<>();
        for (Map.Entry<Object, Object> entry : hash.entrySet()) {

        }
    }
    @Test
    public void test01(){
        String s1="a";
        String  s2="b";
        String s3="ab";
        String s4=s1+s2;
        String s5="a"+"b";
        System.out.println(s3==s4);
        System.out.println(s4==s5);
        System.out.println(s3==s5);
    }
    @Test
    public void test02(){
        //int[] ary={0,1,1,2,3,5,8,13,21,3};
       
            //字符串倒序
       String strA="123abcedfadbf abc321";
//        System.out.println(new StringBuffer(strA).reverse().toString());

        char[] chars = strA.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(chars[i]==chars[j]){
                    System.out.println(chars[j]);
                    break;
                }
            }
        }
    }

    @Test
    public void test03(){

        Integer A=500;
        Integer b=500;
        System.out.println(A==b);

    }


    public static void main(String[] args) {
        //统计字符出现次数
//        String str = "asdfsbrgregadnajfjsfjiwekfsnffsffnslkjfi";
//        char[] ch = str.toCharArray();
//        Map<String, Integer> map = new HashMap<>();
//        for(int i=0;i<ch.length;i++){
//            String ch1 = String.valueOf(ch[i]);
//            //  map.getOrDefault(ch1, 0)  意思就是当Map集合中有这个key时，
//            //  就获取这个key值，如果没有就使用默认值defaultValue
//            map.put(ch1, map.getOrDefault(ch1, 0)+1);
//        }
//        map.forEach((k,v)->System.out.println(k+"出现了"+v+"次"));

        String jsonString2 = "{\"AAA\":\"1\",\"CCC\":\"3\",\"BBB\":\"2\"}";
        Map<String,String> map = JSON.parseObject(jsonString2, Map.class);
        for (Map.Entry<String,String> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }


    }

}
