package com.servlet;

import com.bang.UserEntity;
import com.bang.model.ApiAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tom on 2017/3/30.
 */
public class BangServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html;charset=GBK";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter writer = response.getWriter();

        response.setContentType(CONTENT_TYPE);

        request.setCharacterEncoding("GBK");

        String apiName = request.getParameter("apiurl");

        String phonenum = request.getParameter("phonenum");

        String userPwd = request.getParameter("password");

        UserEntity userEntity = new UserEntity();

        userEntity.setIphonenum(phonenum);

        userEntity.setPassword(userPwd);
        if (apiName.equals(ApiAddress.API_LOGIN_USER))
        {
            writer.println(UserDBHelp.loginUser(userEntity,request.getSession()));

        }else  if(apiName.equals(ApiAddress.API_REGISTER_USER))
        {

            writer.println(UserDBHelp.registerUser(userEntity));

        }else   if(apiName.equals(ApiAddress.API_UPDATE_USER))
        {
            writer.println(UserDBHelp.updateuser(userEntity));
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
