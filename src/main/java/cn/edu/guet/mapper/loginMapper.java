package cn.edu.guet.mapper;

import cn.edu.guet.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginMapper {
    Users login(String acount);
    Users check(String phone);
    Boolean register(String id,String phone,String password);
}
