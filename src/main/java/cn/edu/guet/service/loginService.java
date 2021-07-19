package cn.edu.guet.service;

import cn.edu.guet.bean.Users;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface loginService {
    Users login(String acount, HttpSession session, HttpServletRequest request, HttpServletResponse response);
    Users check(String phone);
    Boolean register(String id,String phone,String password);
}
