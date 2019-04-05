package ro.siit.servlet;

import ro.siit.entity.Xo;
import ro.siit.model.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletAI")
public class ServletAI extends HttpServlet {

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* String position = req.getParameter("position");
        String[] positionXY = position.substring(1, position.length()-1).split(",");


        resp.setContentType("application/json");
        System.out.println(matrix);
        Xo xo = new Xo(matrix);

        PrintWriter out = resp.getWriter();
        out.println("{\"win\": " + xo.winningCondition()   + "}");

    } */
    }
}


