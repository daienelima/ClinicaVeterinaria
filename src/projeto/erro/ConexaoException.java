
package projeto.erro;

/**
 *
 * @author Clinica
 */
public class ConexaoException extends Exception {

    /**
     * Construtor vazil
     */
    public ConexaoException() {
    }
    
    /**
     * Construtor recebendo uma mensagem de erro e enviando para a classe pai tratar.
     * @param msg 
     */
     public ConexaoException(String msg) {
        super(msg);
    }
     
    /**
     * Construtor recebendo um exception e enviando para a classe pai tratar.
     * @param e 
     */
    public ConexaoException(Exception e) {
        super(e);
    }
}
