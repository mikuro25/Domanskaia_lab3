package servlets;

import dao.OrderDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class EventDeleteServlet extends HttpServlet {
    @EJB
    public OrderDAO eventDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            int id = Integer.valueOf(req.getParameter("id"));
            eventDAO.delete(id);
        }

        resp.sendRedirect("list");
    }
}
