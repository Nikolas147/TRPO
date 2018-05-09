package Laba4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;





public class Main {
    public static void main(String[] args)  {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(82);//порт
        server.addConnector(connector);
        //contextHandler (обработчик) - сюда добавляем сервлеты, потом ставим корреной путь и к серверу этот Handel
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);
        contextHandler.addServlet(EventServlet.class,"/connection/");//как на страничке отображаются пути
        contextHandler.addServlet(Servlet.class, "/");//добавляет servlets
        //запуск сервлетов
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
