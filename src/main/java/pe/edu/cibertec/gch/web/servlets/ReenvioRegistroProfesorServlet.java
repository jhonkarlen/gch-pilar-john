package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para reenviar al registro de profesor
 */
@WebServlet(name = "ReenvioRegistroProfesor", urlPatterns = {"/irRegistroProfesor"})
public class ReenvioRegistroProfesorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GchServletUtils.reenviarAModulo("profesor", req, resp);
    }
}
