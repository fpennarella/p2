package it.unisa.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");

        if (page == null || isInvalidPage(page)) {
            // Reindirizza a una pagina di errore o alla home page
            response.sendRedirect("error.jsp");
        } else {
            // Procedi con la visualizzazione della pagina richiesta
            request.getRequestDispatcher("/" + page).forward(request, response);
        }
    }

    private boolean isInvalidPage(String page) {
        // Controlla se il percorso contiene "META-INF" o "WEB-INF"
        if (page.contains("META-INF/context.xml") || page.contains("WEB-INF/web.xml")) {
            return true;
        }

        // Aggiungi ulteriori controlli se necessario (es. pattern regex)
        return false;
    }
}
