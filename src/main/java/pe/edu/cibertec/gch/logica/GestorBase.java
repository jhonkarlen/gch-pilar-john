/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author hans delgado
 */
public interface GestorBase<T> {
    public List<T> listarTodos();
    void eliminarPorCodigo(final String codigo);
    T consultarPorCodigo(final String codigo);
    void registrar(T entidad);
}
