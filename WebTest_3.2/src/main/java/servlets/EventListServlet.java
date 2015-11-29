package servlets;


import dao.OrderDAO;
import entity.Event;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class EventListServlet extends HttpServlet {
    @EJB
    public OrderDAO eventDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Event> allEnterprise = null;

        if (req.getParameter("name") != null) {
            System.out.println(req.getParameter("name"));
            allEnterprise = eventDAO.findByName(req.getParameter("name"));
        } else if (req.getParameter("type") != null) {
            System.out.println(req.getParameter("type"));
            allEnterprise = eventDAO.findByBranch(req.getParameter("type"));
        } else {
            allEnterprise = eventDAO.findAll();
        }

        req.setAttribute("enterprises", allEnterprise);
        req.setAttribute("role", (String)req.getSession().getAttribute("role"));

        req.getRequestDispatcher("./list.jsp").forward(req, resp);
    }

}
