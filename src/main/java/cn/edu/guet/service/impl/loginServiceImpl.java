package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Users;
import cn.edu.guet.mapper.loginMapper;
import cn.edu.guet.service.loginService;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private loginMapper loginMapper;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;


    @Override
    public Users login(String acount, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Users users=loginMapper.login(acount);
        session.setAttribute("s1", users);
        // 保存cookie，实现自动登录
        Cookie cookies = new Cookie("cookies", users.getPhone());
        // 设置cookie的持久化时间，30天
        cookies.setMaxAge(30 * 24 * 60 * 60);
        // 设置为当前项目下都携带这个cookie
        cookies.setPath(request.getContextPath());
        // 向客户端发送cookie
        response.addCookie(cookies);
        return users;
    }

    @Override
    public Users check(String phone) {
        return loginMapper.check(phone);
    }
    @Override
    public Boolean register(String id,String phone, String password) {

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            loginMapper.register(id,phone,password);
            dataSourceTransactionManager.commit(transactionStatus);
            return true;//手动提交
        }catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            return false;//事务回滚
        }
    }
}
