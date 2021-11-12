package prueba.logica.entidades;

public class Historial{
    
    private int puntaje;
    private Usuario Id;

    public Historial() {
    }

    public Historial(int puntaje, Usuario Id) {
        this.puntaje = puntaje;
        this.Id = Id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Usuario getIdUsuario() {
        return Id;
    }
    
    
    
    
}
