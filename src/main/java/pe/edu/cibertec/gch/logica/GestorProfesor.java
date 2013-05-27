package pe.edu.cibertec.gch.logica;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Realiza operaciones relacionadas al profesor.
 */
public class GestorProfesor implements GestorBase<Profesor>{

    private static ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    
    @Override 
    public void registrar(Profesor profesor) {
        profesores.add(profesor);
    }

    public List<Profesor> listarTodos() {
        return profesores;
    }

    public void eliminarPorCodigo(final String codigo) {
        // Al eliminar, el estado del profesor 
        // se cambia a inactivo
        Profesor profesor = consultarPorCodigo(codigo);
        profesor.setEstado(EstadoProfesor.Inactivo);
    }

    public Profesor consultarPorCodigo(final String codigo) {
        Profesor profesor = new Profesor() {{setCodigo(codigo);}};
        return profesores.get(profesores.indexOf(profesor));
    }

    protected void borrarTodos() {
        profesores.clear();
    }
}
