package cn.edu.guet.controller;

import cn.edu.guet.bean.Users;
import cn.edu.guet.bean.seek;
import cn.edu.guet.service.seekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class testcontroller {
    @Autowired
    private seekService seekService;

    @RequestMapping("reward")
    public String toreward(){
        return "reward";
    }
    @RequestMapping("test")
    public String totest(){
        return "test";
    }


    @PostMapping("release")
    public String release(String name, String num, String classify, String describe,String price, HttpServletRequest request,MultipartFile pic){
        String fileName;
        if(pic==null){
            fileName="14940be4-2fb3-4498-ada0-21d6f3c236df.jpg";
        }else{
            fileName = pic.getOriginalFilename();//得到文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));//得到后缀名
            System.err.println("suffixName:" + suffixName);
            String filepath = "D:\\QQ\\2021-06-07\\boot\\src\\main\\resources\\static\\image\\";//指定图片上传到哪个文件夹的路径
            fileName = UUID.randomUUID() + suffixName;//重新命名图片，变成随机的名字
            System.err.println("fileName:" + fileName);
            File dest = new File(filepath + fileName);//在上传的文件夹处创建文件
            try {
                pic.transferTo(dest);//把上传的图片写入磁盘中
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(describe==null)
        {
            describe="无";
        }
        Date date = new Date();
        seek seek=new seek();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        HttpSession session = request.getSession();
        String userid=(String) session.getAttribute("userid");
        Users users= (Users) session.getAttribute("s1");
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        seek.setId(uuid);
        seek.setName(name);
        seek.setNum(Integer.parseInt(num));
        seek.setClassify(classify);
        seek.setDescribe(describe);
        seek.setC_time(dateFormat.format(date));
        seek.setS_id(userid);
        seek.setPrice(Integer.parseInt(price));
        seek.setState("1");
        seek.setPicpath(fileName);
        seek.setS_name(users.getUsername());
        seek.setUsers(users);
        seekService.insertseek(seek);
        return "test";
    }
    @RequestMapping("quest")
    public String quest(Model model,String curPage,HttpSession session){
        if (curPage==null||Integer.parseInt(curPage)<0){
            curPage="0";
        }
        int i=Integer.parseInt(curPage);
        model.addAttribute("Page",i);
        List<seek> seek=seekService.selectseek(Integer.parseInt(curPage)*5);
        System.out.println(seek);
        session.setAttribute("seekl",seek);
        model.addAttribute("seek",seek);
        System.out.println(seek.get(0).getUsers());
        return "reward";
    }
    @RequestMapping("rewardShow")
    public String rewardShow(String id,HttpServletRequest request,Model model ){
        HttpSession session = request.getSession();
        List<seek> seekList= (List<seek>) session.getAttribute("seekl");
        for(seek seek:seekList){
            if(seek.getId().equals(id)){
                seek seek1=seek;
                 model.addAttribute("seek1",seek1);
            }
        }
        int randomIndex=(int)(Math.random()*4);
        int rk=(int)(Math.random()*4);
        if(rk==randomIndex){
            rk=(int)(Math.random()*4);
        }
        seek seek=seekList.get(randomIndex);
        seek seek2=seekList.get(rk);
        model.addAttribute("seek2",seek);
        model.addAttribute("seek3",seek2);
        return "rewardShow";
    }
}
