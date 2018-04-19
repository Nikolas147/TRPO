package Laba3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Read extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();

        dao.read();
        PrintWriter out = resp.getWriter();
        out.print("<head>\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">" +
                "<style type=\"text/css\">\n" +
                "        .tg {\n" +
                "        border-collapse: collapse;\n" +
                "        border-spacing: 0;\n" +
                "        border-color: #ccc;\n" +
                "        }\n" +
                "\n" +
                "        .tg td {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        padding: 10px 5px;\n" +
                "        border-style: solid;\n" +
                "        border-width: 1px;\n" +
                "        overflow: hidden;\n" +
                "        word-break: normal;\n" +
                "        border-color: #ccc;\n" +
                "        color: #333;\n" +
                "        background-color: #fff;\n" +
                "        }\n" +
                "\n" +
                "        .tg th {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        font-weight: normal;\n" +
                "        padding: 10px 5px;\n" +
                "        border-style: solid;\n" +
                "        border-width: 1px;\n" +
                "        overflow: hidden;\n" +
                "        word-break: normal;\n" +
                "        border-color: #ccc;\n" +
                "        color: #333;\n" +
                "        background-color: #f0f0f0;\n" +
                "        }\n" +
                "\n" +
                "        .tg .tg-4eph {\n" +
                "        background-color: #f9f9f9\n" +
                "        }\n" +
                "</style>\n" +
                "\n" +
                "</head>");
        out.print("<html><body>");
        out.print("<table border='1' class=\"tg\"");
        out.print("<tr>\n" +
                "<th width=\"80\">ID</th>\n" +
                "<th width=\"120\">Mark</th>\n" +
                "<th width=\"120\">Model</th>\n" +
                "<th width=\"120\">Year</th>\n" +
                "<th width=\"120\">Price</th>\n" +
                "</tr>");
        System.out.println(dao.getResponse());
        out.print(dao.getResponse());
        out.print("</table>");
        out.print("<button class=\"btn btn-secondary\"><a href=\"javascript:history.back()\">Back</a></button>");
        out.print("</body></html>");
    }
}
