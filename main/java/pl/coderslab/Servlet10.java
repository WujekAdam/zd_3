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

@WebServlet("/Servlet10")
public class Servlet10 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("<a href = \"/Servlet102\"> link do strony 2</a><br>");
        response.getWriter().append("<a href = \"/Servlet103\"> link do strony 3</a><br>");
        response.getWriter().append("<a href = \"/history\"> link do strony 4</a>");
        HttpSession session = request.getSession();
        List<String> history = (List<String>) session.getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add("Strona 1");
        session.setAttribute("history", history);

    }
}


//Zadanie 10
//
//        1. Utwórz 5 stron, każda ze stron ma posiadać linki nawigacyjne do pozostałych.
//        Np.:
//        *   strona 1 będzie posiadać linki do stron 2,3,4.
//        *   strona 2 będzie posiadać linki do stron 1,3,4.
//        itd.
//
//        Mają również wyświetlać informacje o aktualnie odwiedzanej stronie w postaci:
//        ```html
//  Witaj na stronie 1
//  ```
//        2. Strona 4 powinna być dostępna pod adresem **/history**, ma wyświetlać historię odwiedzanych stron oraz link z możliwością wyczyszczenia historii.
//        3. Dane o odwiedzonych stronach przechowuj w sesji.
//
//        Przykład wyświetlanej historii:
//        ```
//Odwiedzałeś:
//Strona 1
//Strona 2
//Strona 3
//Strona 2
//Strona 4