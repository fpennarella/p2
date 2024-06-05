package it.unisa.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorControl")
public class ErrorControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Codice che può generare un'eccezione
        } catch (Exception e) {
            // Log dell'eccezione per la revisione interna
            log("Errore interno del server", e);
            // Redireziona alla pagina di errore
            response.sendRedirect("500.html");
        }
    }
}