/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author DanJoas
 */
public class ReenvioRegistroProgramaServletTest {

    ReenvioRegistroProfesorServlet reenvioRegistroProfesorServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDistpatDispatcher;

    @Before
    public void setUp() {

        reenvioRegistroProfesorServlet = new ReenvioRegistroProfesorServlet();
        requestDistpatDispatcher = mock(RequestDispatcher.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGet() throws Exception {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDistpatDispatcher);
        reenvioRegistroProfesorServlet.doGet(request, response);
    }
}
