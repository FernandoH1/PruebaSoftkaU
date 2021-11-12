package prueba.exeptions;

public class InnovaModelException extends RuntimeException {

    public InnovaModelException(String message) {
        super(message);
    }

    public InnovaModelException(String message, Throwable cause) {
        super(message, cause);
    }
     
}
