package prueba.logica.entidades;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String nickname;
    private String pass;
    private String tipo;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String nickname, String pass, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.pass = pass;
        this.tipo = tipo; 
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario(String nickname, String pass) {
        this.nickname = nickname;
        this.pass = pass;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", nombre, apellido, id);
    }

}
