package cn.edu.guet.bean;
public class Users {
    private String userid;
    private String username;
    private String userpassword;
    private String realname;
    private String phone;
    private String h_portrait;
    private int roleid;
    public String getH_portrait() {
        return h_portrait;
    }

    public void setH_portrait(String h_portrait) {
        this.h_portrait = h_portrait;
    }



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Users(String userid, String usename, String userpassword, String realname, String phone, int roleid,String h_portrait) {
        this.userid = userid;
        this.username = usename;
        this.userpassword = userpassword;
        this.realname = realname;
        this.phone = phone;
        this.roleid = roleid;
        this.h_portrait=h_portrait;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usename) {
        this.username = usename;
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


}
