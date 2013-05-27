/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.cibertec.gch.servlets.RegistroProfesorServlet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
/**
 *
 * @author JAVA_MJ
 */
public class RegistroProfesorServletTest {
    
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private RegistroProfesorServlet registroProfesorServlet;
    
    public RegistroProfesorServletTest() {
    }
    
   
    @Before
    public void setUp() {
        registroProfesorServlet=new RegistroProfesorServlet();
        req = mock(HttpServletRequest.class);
        resp =mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void invocacionDoPost() throws Exception{
         llenarParametros(req);
         //registroProfesorServlet.doPost(req, resp);
         registroProfesorServlet.doPost(req, resp);
//         verify(resp).sendRedirect("listarProfesores");
         verify(req).setAttribute("mensaje", "Hay errores en los datos enviados");
     }
     
     private void llenarParametros(HttpServletRequest req1){
         when(req.getParameter("codigo")).thenReturn("001");
//         when(req.getParameter("nombres")).thenReturn("Steve");
         when(req.getParameter("apellidoPaterno")).thenReturn("Silva");
         when(req.getParameter("apellidoMaterno")).thenReturn("Bernedo");
         when(req.getParameter("direccion")).thenReturn("home");
         when(req.getParameter("referencia")).thenReturn("vecino");
         when(req.getParameter("telefono1")).thenReturn("987654321");
         when(req.getParameter("telefono2")).thenReturn("012345677");
         when(req.getParameter("telefono3")).thenReturn("");
         when(req.getParameter("email1")).thenReturn("stv_sb@gmail.com");
         when(req.getParameter("email2")).thenReturn("sb_stv@gmail.com");
         when(req.getParameter("email3")).thenReturn("");
         when(req.getParameter("fechaNacimiento")).thenReturn("04/06/1989");
         when(req.getParameter("sexo")).thenReturn("Masculino");
         when(req.getParameter("estadoCivil")).thenReturn("Soltero");
     }
}
