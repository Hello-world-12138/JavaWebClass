import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * @description:监听器
 * @author:halation
 * @date:2025/3/23 14:51
 **/
@WebListener
public class MyListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int online=0;
        ServletContext context = se.getSession().getServletContext();
        if(context.getAttribute("ol")==null){
           online=online+1;
           context.setAttribute("ol",online);
        }else{
            online=(int)context.getAttribute("ol");
            online=online+1;
            context.setAttribute("ol",online);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context=se.getSession().getServletContext();
        int online=(int)context.getAttribute("ol");
        online=online-1;
        context.setAttribute("ol",online);
    }
}
