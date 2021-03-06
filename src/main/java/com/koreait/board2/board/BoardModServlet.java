package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(MyUtils.isLogout(req)) {
            res.sendRedirect("/user/login");
            return;
        }
        if(req.getAttribute("data") == null) {
            int iboard = MyUtils.getParameterInt(req, "pk");
            BoardVO param = new BoardVO();
            param.setIboard(iboard);
            req.setAttribute("data", BoardDAO.selBoardDetail(param));
        }
        MyUtils.disForward(req, res, "board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "pk");
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(MyUtils.getLoginUserPk(req));
        int result = BoardDAO.updBoard(param);
        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?pk=" + iboard);
                break;
            default:
                req.setAttribute("err", "수정에 실패하였습니다.");
                req.setAttribute("data", param);
                doGet(req, res);
                break;
        }

    }
}