package com.huawei.b00314808.finance.conntroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author baijia
 * @version V1.0.0
 */
@Controller
public class ImageCode {
    private static final long LEN = 4;   

    @RequestMapping("/ImageCodeServlet")
    protected void getImageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        BufferedImage image = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        
        Graphics paint = image.getGraphics();
        Color c = new Color(200,150,255);

        paint.setColor(c);

        paint.fillRect(0, 0, 68, 22);
        
        StringBuffer codes = new StringBuffer();

        char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890".toCharArray();
        Random r = new Random(); 
        int index;
        for(int i=0;i<LEN;i++){
            index = r.nextInt(ch.length);
            paint.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            paint.drawString(ch[index]+"", (i*16)+3, 18);
            codes.append(ch[index]);
        }
        request.getSession().setAttribute("codes", codes);
        
        
        ImageIO.write(image, "JPG", response.getOutputStream()); 
    }
    
}
