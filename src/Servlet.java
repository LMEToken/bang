import com.bang.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tom on 2017/3/30.
 */
public class Servlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();



        SessionFactory ourSessionFactory;
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();

        } catch (Throwable ex) {
         //   throw new ExceptionInInitializerError(ex);

            writer.println(ex);
        }
        final Session session = Main.getSession();
        
        Transaction transaction = session.beginTransaction();//开启一个新的事务

        UserEntity userEntity = new UserEntity();
        userEntity.setIphonenum("13023132628");
        userEntity.setPassword("tom520099");
        session.save(userEntity);
        transaction.commit();//提交事务







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
