package prueba.logica.entidades;

public class Opcion {
  
private String nombre;
private boolean esCorrecto;

    public Opcion(String nombre, boolean esCorrecto) {
        this.nombre = nombre;
        this.esCorrecto = esCorrecto;
    }
    

    public String getNombre() {
        return nombre;
    }

    public boolean isEsCorrecto() {
        return esCorrecto;
    }


}
