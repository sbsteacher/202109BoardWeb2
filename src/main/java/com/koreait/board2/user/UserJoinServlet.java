package com.koreait.board2.user;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "user/join");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");
        String nm = req.getParameter("nm");
        int gender = MyUtils.getParameterInt(req, "gender");

        UserVO param = new UserVO();
        param.setUid(uid);
        param.setUpw(upw);
        param.setNm(nm);
        param.setGender(gender);
    }
}