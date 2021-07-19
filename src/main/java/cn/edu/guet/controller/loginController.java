package cn.edu.guet.controller;

import cn.edu.guet.bean.Users;
import cn.edu.guet.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class loginController {

    @Autowired
    private loginService loginService;

    @ResponseBody
    @PostMapping("login")
    public Map<String, Boolean> login(String acount, String password, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Users user=loginService.login(acount,session,request,response);
        System.out.println(user);
        Map<String , Boolean> map=new HashMap<String, Boolean>();
        System.out.println(password);
        if(user!=null&&password.equals(user.getUserpassword())){
            map.put("YON",true);
            return map;
        }else {
            map.put("YON",false);
            return map;
        }

    }
    @GetMapping("login.html")
    public String tologin(HttpServletRequest request, HttpServletResponse response){

        return "login";
    }

    @ResponseBody
    @PostMapping("check")
    public Map<String,Boolean> check(String phone)
    {
        Users user=loginService.check(phone);
        System.out.println(user);
        Map<String , Boolean> map=new HashMap<String, Boolean>();
        if(user!=null){
            map.put("YON",true);
            return map;
        }else {

            map.put("YON",false);
            return map;
        }
    }
    @ResponseBody
    @PostMapping("checkpassword")
    public Map<String,String> checkpassword(String password)
    {
        Map<String , String> map=new HashMap<String, String>();
        if(password.length()<8){
            map.put("YON","true");
            map.put("msg","密码过短，最少8位");
        }else if(isValid(password)){
            map.put("YON","true");
            map.put("msg","格式错误，最少2个数字或字符，包含特殊符号");
        }else{
            map.put("YON","no");
            map.put("msg","密码符合要求");
        }
        return map;
    }
    @ResponseBody
    @PostMapping("register")
    public Map<String,Boolean> register(String phone,String password){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
        Map<String , Boolean> map=new HashMap<String, Boolean>();
        Boolean f=loginService.register(uuid, phone, password);
        map.put("YON",f);
        return map;
    }


    public static boolean isValid(String password) {
        if(password.length() < 8) {
            return false;
        } else {
            int numberCounter = 0;
            for(int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if(!Character.isLetterOrDigit(c)) {
                    return false;
                }
                if(Character.isDigit(c)) {
                    numberCounter++;
                }
            }
            if(numberCounter < 2) {
                return false;
            }
        }
        return true;
    }
}

