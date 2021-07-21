package cn.edu.guet.bean;
public class Users {
    private String userid;
    private String usename;
    private String userpassword;
    private String realname;
    private String phone;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Users(String userid, String usename, String userpassword, String realname, String phone, int roleid) {
        this.userid = userid;
        this.usename = usename;
        this.userpassword = userpassword;
        this.realname = realname;
        this.phone = phone;
        this.roleid = roleid;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    private int roleid;
}
