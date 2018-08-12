package projeto.erro;

/**
 *
 * @author Mario
 */
public class AutenticacaoException extends Exception{
    
    /**
     * Construtor vazio
     */
    public AutenticacaoException(){
    }
    
    /**
     * Construtor recebendo uma String e jogando para o super (pai).
     * @param msg 
     */
    public AutenticacaoException(String msg){
        super(msg);
    }
    
    /**
     * Construtor recebendo e jogando a excessão para o pai (Exception). 
     * @param e 
     */
    public AutenticacaoException(Exception e){
        super(e);
    }
    
}
