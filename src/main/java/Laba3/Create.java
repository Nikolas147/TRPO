package Laba3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Create extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car  = new Car();
        DAO dao = new DAO();

        car.setMark(req.getParameter("Mark"));
        car.setModel(req.getParameter("Model"));
        car.setYear(Integer.parseInt(req.getParameter("Year")));
        car.setPrice(Integer.parseInt(req.getParameter("Price")));
        dao.create(car);
        resp.setStatus(204);

        /*PrintWriter out = resp.getWriter();
        out.print("<html><script>window.history.back();</script></html>");*/
    }
}
