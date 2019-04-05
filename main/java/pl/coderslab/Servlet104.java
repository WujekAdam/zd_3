package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class Servlet104 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        response.getWriter().append("<a href = \"/Servlet10\"> link do strony 1</a><br>");
        response.getWriter().append("<a href = \"/Servlet102\"> link do strony 2</a><br>");
        response.getWriter().append("<a href = \"/Servlet103\"> link do strony 3</a><br>");
        HttpSession session = request.getSession();
        List<String> history = (List<String>) session.getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add("Strona 4");
        response.getWriter().append("Odwiedzane strony: <br>");
        for (String record : history) {
            response.getWriter().append(record + "<br>");
        }
        response.getWriter().append("<a href = \"/Servlet105\">Wyczyść historię:</a>");
        session.setAttribute("history", history);
    }
}