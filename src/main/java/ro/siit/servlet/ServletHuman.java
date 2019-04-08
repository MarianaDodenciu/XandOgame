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

@WebServlet("/ServletHuman")
public class ServletHuman extends HttpServlet {

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String matrix = req.getParameter("matrix");
        resp.setContentType("application/json");
        System.out.println(matrix);
        Xo xo = new Xo(matrix);


      PrintWriter out = resp.getWriter();
         try {
            if(xo.winningCondition()){
                databaseManager.add(matrix);
            }
        } catch (Exception e) {
             e.printStackTrace();
            out.println("{\"error\": " + e.toString() + "}");
        }

        out.println("{\"win\": " + xo.winningCondition()  + "}");
    }


}


