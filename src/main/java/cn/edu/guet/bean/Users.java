package cn.edu.guet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String userid;
    private String usename;
    private String userpassword;
    private String realname;
    private String phone;
    private int roleid;
}
