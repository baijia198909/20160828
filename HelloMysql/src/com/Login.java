package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 * @author baijia
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
      //��ǰ̨��ȡ�����û���
        String username = request.getParameter("username");
        //��ǰ̨��ȡ��������
        String pwd = request.getParameter("password");
        int res=MysqlDemo.msqlConnect(username, pwd);
        if( res>0)
        {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('��ϲ����¼�ɹ�');");
            out.println("history.back();");
            out.println("</script>");
            out.close();

        }else
        {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('�û��������������');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
