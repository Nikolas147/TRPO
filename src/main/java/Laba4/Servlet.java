package Laba4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        InputStream stream = new FileInputStream("src/main/webapp/index4.html");
        copyStream(stream, resp.getOutputStream());
    }

    //читает html файл и отправляет его
    public static void copyStream(InputStream input, OutputStream output) throws IOException {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
            builder.append("\n");
        }
        output.write(builder.toString().getBytes());
    }
}