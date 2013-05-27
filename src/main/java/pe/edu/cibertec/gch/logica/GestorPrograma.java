/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
public class GestorPrograma implements GestorBase<Programa> {

    private static ArrayList<Programa> progr = new ArrayList<Programa>();

    @Override
    public Programa consultarPorCodigo(final String codigo) {
        /* 
         * Programa programa = new Programa() {{setCodigo(codigo);}};
         * No devuelve el indx correcto ( -1 )
         */
        Programa programa = new Programa(codigo);
        return progr.get(progr.indexOf(programa));
    }

    @Override
    public void registrar(Programa programa) {

        progr.add(programa);
        System.out.println("Cantidad de Programas registrados : " + progr.size());
    }

    @Override
    public List<Programa> listarTodos() {
        return progr;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        Programa programa = consultarPorCodigo(codigo);
        programa.setEstado(EstadoActividad.Obsoleto);
    }

    protected void borrarTodos() {
        progr.clear();
    }

    public List<Programa> listarSegun(String titulo, String descripcion, TipoBusqueda tipoBusquedaEnum) {

        List<Programa> resultado = new LinkedList<Programa>();
        for (Programa programas : progr) {
            switch (tipoBusquedaEnum) {
                case Completa:
                    resultado.add(programas);
                    break;
                case Parcial:
                    if (!titulo.isEmpty() && titulo.equalsIgnoreCase(programas.getTitulo())
                            || !descripcion.isEmpty() && descripcion.equalsIgnoreCase(programas.getDescripcion())) {
                        resultado.add(programas);
                    }
                    break;
            }
        }
        return resultado;
    }
}
