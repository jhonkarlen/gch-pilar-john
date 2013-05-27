package pe.edu.cibertec.gch.modelo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import pe.edu.cibertec.gch.annotation.enConstruccion;

/**
 * Representa a un docente de la institucion.
 */
@enConstruccion(owner="Alumnos") //notacion descriptiva. 
public class Profesor implements Serializable {

    private String codigo;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String referencia;
    private Date fechaNacimiento;
    private Genero sexo;
    private EstadoProfesor estado;
    private String estadoCivil;

    private List<String> telefonos;
    private List<String> emails;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.matches("px[a-z]{6}\\d?")) {
            this.codigo = codigo;
        }
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public EstadoProfesor getEstado() {
        return estado;
    }

    public void setEstado(EstadoProfesor estado) {
        this.estado = estado;
    }

    public List<String> getTelefonos() {
        return Collections.unmodifiableList(telefonos);
    }

    public void agregarTelefono(String telefono) {
        telefonos.add(telefono);
    }

    public void eliminarTelefono(String telefono) {
        telefonos.remove(telefono);
    }

    public List<String> getEmails() {
        return Collections.unmodifiableList(emails);
    }

    public void agregarEmail(String email) {
        emails.add(email);
    }

    public void eliminarEmail(String email) {
        emails.remove(email);
    }

    public boolean tieneDatosObligatorios() {
        boolean faltaCodigo = (null == getCodigo()),
                faltaNombres = (null == getNombres()),
                faltaApellidoPaterno = (null == getApellidoPaterno()),
                faltaFechaNacimiento = (null == getFechaNacimiento()),
                faltaGenero = (null == getSexo()),
                faltaEstado = (null == getEstado());
        // se puede devolver directamente el resultado de la condicion,
        if (faltaCodigo
                || faltaNombres
                || faltaApellidoPaterno
                || faltaFechaNacimiento
                || faltaGenero
                || faltaEstado) {
            return false;
        } else {
            return true;
        }

    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }    

    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Profesor)) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
