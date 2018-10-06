package com.huawei.b00314808.finance.conntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.b00314808.finance.domain.Bill;
import com.huawei.b00314808.finance.domain.BillMapper;
import com.huawei.b00314808.finance.domain.Employee;
import com.huawei.b00314808.finance.domain.EmployeeMapper;

/**
 * 
 * @author baijia
 * @version V1.0.0
 */
@Controller
public class Login {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private BillMapper billMapper;
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Worldm";
    }
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response) {
        
      //从前台读取到的用户名
        String username = request.getParameter("user");
        //从前台读取到的密码
        String pwd = request.getParameter("password");
        int result= employeeMapper.insert(username, pwd);
        if(result>0) {
            return "index";
        }else
        {
            return "fail";
        }
       
    }
    @RequestMapping("/")
    public String index( ) {
        return "index";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String loginin(ModelMap map,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codes = request.getSession().getAttribute("codes").toString();
        //前台获取验证码
        String inputCcode = request.getParameter("checkcode");
        response.setContentType("text/html; charset=UTF-8");

        if(inputCcode.toUpperCase().equals(codes)){
            
        }else
        {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('wrong checkcode 验证码错误');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
            return null;
        }
        
        
        //从前台读取到的用户名
        String username = request.getParameter("username");
        //从前台读取到的密码
        String pwd = request.getParameter("password");
        int result= employeeMapper.findByNameAndPass(username,pwd);
        System.out.println(result);
        if(result>0){
            request.getSession().setAttribute("username", username);
            map.addAttribute("billList",billMapper.findAllByName(username));
            return "main";
        }else
        {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('请检查用户名和密码');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
            return null;
        }

    }
    
}
