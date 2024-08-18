package proyecto.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String raza;
    private String lactancia;
    private String pelaje;
    private String edad;
    private String telefono;  

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Usuarios usuarios;


    public Mascotas() {
    }


    public Mascotas(String nombre, String raza, String lactancia, String pelaje, String edad, String telefono,
            Usuarios usuarios) {
        this.nombre = nombre;
        this.raza = raza;
        this.lactancia = lactancia;
        this.pelaje = pelaje;
        this.edad = edad;
        this.telefono = telefono;
        this.usuarios = usuarios;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getRaza() {
        return raza;
    }


    public void setRaza(String raza) {
        this.raza = raza;
    }


    public String getLactancia() {
        return lactancia;
    }


    public void setLactancia(String lactancia) {
        this.lactancia = lactancia;
    }


    public String getPelaje() {
        return pelaje;
    }


    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }


    public String getEdad() {
        return edad;
    }


    public void setEdad(String edad) {
        this.edad = edad;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public Usuarios getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    
}

    