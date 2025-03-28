
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private void generateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        char sc = 'a';
        for (int i = 0; i <= 4; i++) {
            int str = random.nextInt(62);
            if (str < 10) {
                sb.append(str);
            } else if (str < 36) {
                sc = (char) ((str - 10) + 'a');
                sb.append(sc);
            } else {
                sc = (char) ((str - 36) + 'A');
                sb.append(sc);
            }
        }

        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setColor(Color.blue);
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 18));
        graphics.drawString(sb.toString(), 3, 17);
        graphics.dispose();
        ImageIO.write(image, "JPG", response.getOutputStream());
        System.out.println("生成的验证码：" + sb);

        // 将验证码保存到session
        request.getSession().setAttribute("code", sb.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型为图片
        response.setContentType("image/jpeg");
        // 生成验证码
        generateCode(request, response);
    }

    /**
     * 处理POST请求，处理用户注册
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户提交的表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userCode = request.getParameter("code"); // 用户输入的验证码

        // 获取Session中保存的验证码
        String sessionCode = (String) request.getSession().getAttribute("code");

        // 验证验证码是否正确
        if (userCode == null || !userCode.equalsIgnoreCase(sessionCode)) {
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 验证码正确，处理注册逻辑
        // 这里可以添加将用户信息保存到数据库的逻辑
        System.out.println("注册成功，用户名：" + username + "，密码：" + password);

        // 重定向到登录页面或其他页面
        response.sendRedirect("login.jsp");
    }
}
