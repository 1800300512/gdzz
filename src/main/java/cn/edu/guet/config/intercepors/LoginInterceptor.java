package cn.edu.guet.config.intercepors;

import cn.edu.guet.bean.Users;
import cn.edu.guet.mapper.loginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private cn.edu.guet.mapper.loginMapper loginMapper;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        String cookie1 = null;
        // 获取cookie里面的一些用户信息
        for (Cookie item : cookies) {
            if ("c1".equals(item.getName())) {
                cookie1 = item.getValue();
                break;
            }
        }
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("s1");
        if (null == obj) {
            // 根据用户登录账号获取数据库中的用户信息
            Users users = loginMapper.login(cookie1);
            // 将用户保存到session中
            session.setAttribute("s1", users);
        }
        // 已经登录
        return true;




//        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
//        HttpSession session = request.getSession();
//        //这里的User是登陆时放入session的
//        Users user = (Users) session.getAttribute("user");
//        //如果session中没有user，表示没登陆
//        if (user == null){
//            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
//            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            return false;
//        }else {
//            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
//        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
