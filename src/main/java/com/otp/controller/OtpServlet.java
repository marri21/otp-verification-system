package com.otp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import com.otp.dao.UserDAO;
import com.otp.entity.User;

public class OtpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String enteredOtp = req.getParameter("otp");

        HttpSession session = req.getSession();
        String sessionOtp = (String) session.getAttribute("otp");
        User user = (User) session.getAttribute("user");

        if (enteredOtp.equals(sessionOtp)) {

            boolean result = new UserDAO().saveUser(user);

            if (result) {
                res.sendRedirect("success.jsp");
            } else {
                res.sendRedirect("error.jsp");
            }

        } else {
            res.sendRedirect("otp.jsp?msg=wrong");
        }
    }
}