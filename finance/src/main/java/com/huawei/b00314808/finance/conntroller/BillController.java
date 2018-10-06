package com.huawei.b00314808.finance.conntroller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huawei.b00314808.finance.domain.Bill;
import com.huawei.b00314808.finance.domain.BillMapper;

/**
 * 
 * @author baijia
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/bill")
public class BillController {
    @Autowired
    BillMapper billmapper;

    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map,HttpServletRequest request) {
        String username = request.getSession().getAttribute("username").toString();
        map.addAttribute("billList",billmapper.findAllByName(username));
        return "main";
    }
    /**
     * 创建 Bill
     * 处理 "/bill/create" 的 POST 请求，用来新建 bill信息
     * 
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String postBill(ModelMap map) {
        map.addAttribute("bill", new Bill());
        map.addAttribute("action", "create");
        return "billAdd";
    }
    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @ModelAttribute 绑定表单实体参数，也通过 @RequestParam 传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBill(@ModelAttribute Bill bill,HttpServletRequest request) {
        System.out.println("create");
        java.util.Date utilDate=new java.util.Date();
        bill.date=new Date(utilDate.getTime());
        
        String username = request.getSession().getAttribute("username").toString();
        bill.name=username;
        
        billmapper.insert(bill.name, bill.date, bill.item, bill.price, bill.remark);
        return "redirect:/bill";
    }
    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id) {
        billmapper.delete(id);
        return "redirect:/bill";
    }
}
