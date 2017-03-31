package com.servlet;

import com.bang.UserEntity;
import com.bang.model.PostAuto;
import com.util.DBUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tom on 2017/3/31.
 */
public class UserDBHelp {

    public static  String registerUser(UserEntity userEntity)
    {
        Session session = DBUtil.getSession();

        try {
            Transaction transaction = session.beginTransaction();//开启一个新的事务
            UserEntity user = new UserEntity();
            user.setIphonenum(userEntity.getIphonenum());
            user.setPassword(userEntity.getPassword());
            int id = (Integer)session.save(user);
            transaction.commit();//提交事务
            PostAuto auto = new PostAuto();
            auto.postStatus = true;
            auto.errormsg  = "success";
            auto.code = 200;
            return   JSONObject.fromObject(auto).toString();
           // writer.println(JSONObject.fromObject(auto).toString());

        }catch (Exception e)
        {

            String sql = "select count(*) from UserEntity where iphonenum = :userphonenum and password = :userPwd";

            Long count = (Long)session.createQuery(sql)
                    .setParameter("userphonenum",userEntity.getIphonenum())
                    .setParameter("userPwd",userEntity.getPassword())
                    .uniqueResult();

            if (count>0)
            {

                PostAuto auto = new PostAuto();
                auto.postStatus = false;
                auto.errormsg  = "账号已注册";
                auto.code = 202;
                return  JSONObject.fromObject(auto).toString();

            }else
            {
                PostAuto auto = new PostAuto();
                auto.postStatus = false;
                auto.errormsg  = "请检查参数";
                auto.code = 203;
                return  JSONObject.fromObject(auto).toString();

            }

        }

    }

    public static String loginUser(UserEntity userEntity,HttpSession httpSession)
    {

        Session session = DBUtil.getSession();

        try {

            String sql = "select id,iphonenum,password,name,email,address,headurl from UserEntity where iphonenum = :userphonenum and password = :userPwd";

            List users = session.createQuery(sql)
                    .setParameter("userphonenum",userEntity.getIphonenum())
                    .setParameter("userPwd",userEntity.getPassword())
                    .list();


            httpSession.setMaxInactiveInterval(1296000);


            if (users.size()>0)
            {
                Object userObj = users.get(0);

                JSONArray jsonArray = JSONArray.fromObject(userObj);

                JSONObject object = new JSONObject();
                object.put("phonenum",jsonArray.get(1));
                object.put("passworld",jsonArray.get(2));
                object.put("name",jsonArray.get(3));
                object.put("email",jsonArray.get(4));
                object.put("address",jsonArray.get(5));
                object.put("headurl",jsonArray.get(6));

                PostAuto auto = new PostAuto();
                auto.postStatus = true;
                auto.code = 200;
                auto.successmsg = object.toString();
                auto.session = httpSession.getId();

                return  JSONObject.fromObject(auto).toString();

            }else
            {

                PostAuto auto = new PostAuto();
                auto.postStatus = true;
                auto.errormsg  = "账户名或密码错误";
                auto.code = 204;

                return  JSONObject.fromObject(auto).toString();


            }


        }catch (Exception e)
        {
            PostAuto auto = new PostAuto();
            auto.postStatus = true;
            auto.errormsg  = "账户名或密码错误";
            auto.code = 204;
            return  JSONObject.fromObject(auto).toString();
        }
    }

    public static String updateuser(UserEntity userEntity)
    {
        Session session = DBUtil.getSession();

        try {

            Transaction transaction = session.beginTransaction();//开启一个新的事务
            UserEntity user = new UserEntity();
            user.setIphonenum(userEntity.getIphonenum());
            user.setPassword(userEntity.getPassword());
            session.update(user);
            transaction.commit();//提交事务
            PostAuto auto = new PostAuto();
            auto.postStatus = true;
            auto.errormsg  = "success";
            auto.code = 200;

            return   JSONObject.fromObject(auto).toString();
            // writer.println(JSONObject.fromObject(auto).toString());

        }catch (Exception e)
        {


            PostAuto auto = new PostAuto();
            auto.postStatus = false;
            auto.errormsg  = "请检查参数";
            auto.code = 203;
            return  JSONObject.fromObject(auto).toString();

        }

    }
}
