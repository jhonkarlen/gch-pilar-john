/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author DanJoas
 */
public class GestorProgramaTest {

    GestorPrograma gestorPrograma;

    public GestorProgramaTest() {
    }

    @Before
    public void setUp() {

        gestorPrograma = new GestorPrograma();
    }

    @After
    public void tearDown() {
        gestorPrograma.borrarTodos();
    }

    @Test
    public void consultarProgramaPorCodigo() {
        // carga
        gestorPrograma.borrarTodos();
        Programa programa = new Programa("91", "Tecnicos Inductriales", "No definido");
        gestorPrograma.registrar(programa);
        // ejecuta
        System.out.print(gestorPrograma.consultarPorCodigo("91").getTitulo());
        assertEquals(programa, gestorPrograma.consultarPorCodigo("91"));
    }

    @Test
    public void registrarUnPrograma() {
        // carga
        gestorPrograma.borrarTodos();
        Programa programa = new Programa("91", "Tecnicos Inductriales", "No definido");
        // ejecuta
        gestorPrograma.registrar(programa);
        // verifica
        List<Programa> lstProgramas = gestorPrograma.listarTodos();
        assertEquals(1, lstProgramas.size());
    }

    /**
     * Test of listarTodos method, of class GestorPrograma.
     */
    @Test
    public void listarTodosLosProgramas() {
        // carga
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01", "Tecnicos Inductriales", "No definido");
        Programa p2 = new Programa("22", "Administradores", "No definido");
        gestorPrograma.registrar(p1);
        gestorPrograma.registrar(p2);
        // ejecuta
        List<Programa> lstProgramas = gestorPrograma.listarTodos();
        // verifica
        assertEquals(2, lstProgramas.size());
    }

    /**
     * Test of eliminarPorCodigo method, of class GestorPrograma.
     */
    @Test
    public void EliminarProgramaPorCodigo() {
        // carga
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01", "Tecnicos Inductriales", "No definido");
        gestorPrograma.registrar(p1);
        // ejecutar
        gestorPrograma.eliminarPorCodigo("01");
        // verificar
        List<Programa> lstProgramas = gestorPrograma.listarTodos();
        assertEquals(1, lstProgramas.size());
    }

    @Test
    public void BorrarTodosLosProgramas() {
        // carga
        Programa p1 = new Programa("01", "Tecnicos Inductriales", "No definido");
        Programa p2 = new Programa("22", "Administradores", "No definido");
        gestorPrograma.registrar(p1);
        gestorPrograma.registrar(p2);
        // ejecutar
        gestorPrograma.borrarTodos();
        // verificacion
        assertEquals(0, gestorPrograma.listarTodos().size());
    }

    @Test
    public void ListarProgramaSegun() {
        // carga
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01", "Tecnicos Inductriales", "No definido");
        Programa p2 = new Programa("22", "Administradores", "No definido");
        gestorPrograma.registrar(p1);
        gestorPrograma.registrar(p2);
        // ejectuar
        String titulo = "Tecnicos Industriales";
        String descripcion = "No definido";
        List<Programa> lstProgramas = gestorPrograma.listarSegun(titulo, descripcion, TipoBusqueda.Completa);
        assertEquals(p1.getTitulo(), lstProgramas.get(0).getTitulo());

    }
}
