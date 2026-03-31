package com.otp.controller;

import javax.servlet.*;
import javax.servlet.http.*;



import java.io.IOException;

import com.otp.entity.User;
import com.otp.service.EmailService;
import com.otp.service.OtpService;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        String otp = OtpService.generateOtp();

        HttpSession session = req.getSession();
        session.setAttribute("otp", otp);
        session.setAttribute("user", user);

        EmailService.sendOtp(email, otp);

        res.sendRedirect("otp.jsp");
    }
}
