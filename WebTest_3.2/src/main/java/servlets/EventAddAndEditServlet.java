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

@WebServlet("/add")
public class EventAddAndEditServlet extends HttpServlet {
    @EJB
    public OrderDAO eventDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null){
            int id = Integer.valueOf(req.getParameter("id"));
            Event enterprise = eventDAO.read(id);

            req.setAttribute("enterprise", enterprise);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String mdate = req.getParameter("mdate");

        Event enterprise = null;

        if (!req.getParameter("id").equals("")) {
            int id = Integer.valueOf(req.getParameter("id"));

            enterprise = eventDAO.read(id);
            enterprise.setName(name);
            enterprise.setType(type);
            enterprise.setMdate(mdate);
            eventDAO.update(enterprise);
        } else {
            enterprise = new Event(name, type, mdate);
            eventDAO.create(enterprise);
        }
        resp.sendRedirect("list");
    }
}
