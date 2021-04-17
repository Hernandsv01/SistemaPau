package proyecto;

import java.util.Date;

public class Alumno {
    private String nombre;
    private int edad;
    private String telefono;
    private String mail;
    private String DNI;
    private Date fechaDeInicio;
    private String estado;
    private String comentarios;

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getMail() {
        return mail;
    }
    public String getDNI() {
        return DNI;
    }
    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }
    public String getEstado() {
        return estado;
    }
    public String getComentarios() {
        return comentarios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
