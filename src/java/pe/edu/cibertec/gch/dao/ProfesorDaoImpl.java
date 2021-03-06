package pe.edu.cibertec.gch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import pe.edu.cibertec.gch.modelo.Profesor;

public class ProfesorDaoImpl implements ProfesorDao {

    public void registrar(Profesor profesor) {
        Contenedor.PROFESORES.add(profesor);
    }

    public void actualizar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarSegun(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Profesor> listarTodo() {
        return Contenedor.PROFESORES;
    }

    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        List<Profesor> profesores = new LinkedList();
        for (Profesor profesor : Contenedor.PROFESORES) {
            boolean nombreCoincide = nombres == null 
                    || nombres.isEmpty()
                    || profesor.getNombres().toLowerCase(Locale.ENGLISH)
                    .contains(nombres.toLowerCase(Locale.ENGLISH));
            boolean apellidoPaternoCoincide = apellidoPaterno == null 
                    || apellidoPaterno.isEmpty()
                    || profesor.getApellidoPaterno().toLowerCase(Locale.ENGLISH)
                    .contains(apellidoPaterno.toLowerCase(Locale.ENGLISH));
            boolean apellidoMaternoCoincide = apellidoMaterno == null 
                    || apellidoMaterno.isEmpty() 
                    || profesor.getApellidoMaterno().toLowerCase(Locale.ENGLISH)
                    .contains(apellidoMaterno.toLowerCase(Locale.ENGLISH));
            if (nombreCoincide && apellidoPaternoCoincide && apellidoMaternoCoincide) {
                profesores.add(profesor);
            }
        }
        return profesores;
    }

    public Profesor obtenerSegun(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static class Contenedor {

        private static List<Profesor> PROFESORES = new LinkedList<Profesor>();
    }
}
