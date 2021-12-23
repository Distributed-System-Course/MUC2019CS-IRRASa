package com.example.java_muc2019csirrasa.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Email {
    // 随机验证码
    public static String achieveCode() {  //由于数字 1 、 0 和字母 O 、l 有时分不清楚，所以，没有数字 1 、 0
        String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z" };
        List<String> list = Arrays.asList(beforeShuffle);//将数组转换为集合
        Collections.shuffle(list);  //打乱集合顺序
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o); //将集合转化为字符串
        }
        return sb.toString().substring(3, 8);  //截取字符串第4到8
    }
    //发送邮件代码
    public static int sendAuthCodeEmail(String email, String authCode) {
        try {

            SimpleEmail mail = new SimpleEmail();
            mail.setHostName("smtp.qq.com");//发送邮件的服务器
            mail.setAuthentication("2994856495@qq.com","unmcesrozlfpdehc");//刚刚记录的授权码，是开启SMTP的密码
            mail.setFrom("2994856495@qq.com",email);  //发送邮件的邮箱和发件人
            mail.setSSLOnConnect(true); //使用安全链接
            mail.addTo(email);//接收的邮箱
            //System.out.println("email"+email);
            mail.setSubject("注册验证码");//设置邮件的主题
            mail.setMsg("尊敬的用户:你好!\n 注册验证码为:" + authCode+"\n"+"     (有效期为一分钟)");//设置邮件的内容
            mail.send();//发送
            return 1;
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return -1;
    }
    @Test
    public void test1(){
        sendAuthCodeEmail("1275884747@qq.com","123");
    }

}
