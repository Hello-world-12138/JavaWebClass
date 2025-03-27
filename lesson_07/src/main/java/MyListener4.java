import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * @description:4
 * @author:halation
 * @date:2025/3/23 15:11
 **/
@WebListener
public class MyListener4 implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("新的请求对象创建了");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("对象销毁了");
    }
}
