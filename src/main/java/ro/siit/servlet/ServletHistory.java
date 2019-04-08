package ro.siit.servlet;

import ro.siit.model.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ServletHistory")                               //Server
public class ServletHistory extends HttpServlet{

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String lastThreeMatches =  databaseManager.getLastThreeMatches().toString();
       System.out.println(lastThreeMatches);
       resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println(lastThreeMatches);
    }
}
