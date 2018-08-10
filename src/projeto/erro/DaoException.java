
package projeto.erro;

/**
 *
 * @author Clinica
 */
public class DaoException extends Exception{

    /**
     * Construtor vazil
     */
    public DaoException() {
    }
    
    /**
     * Construtor recebendo uma mensagem de erro e enviando para a classe pai tratar.
     * @param msg 
     */
    public DaoException(String msg) {
        super(msg);
    }
    
    /**
     * Construtor recebendo um Exception e enviando para a classe pai tratar.
     * @param e 
     */
    public DaoException(Exception e) {
        super(e);
    }
    
}
