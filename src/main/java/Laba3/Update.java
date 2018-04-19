package Laba3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();

        dao.update(req.getParameter("Model"), req.getParameter("Price"));
        resp.setStatus(204);

        /*PrintWriter out = resp.getWriter();
        out.print("<html><script>window.history.back();</script></html>");*/
    }
}

