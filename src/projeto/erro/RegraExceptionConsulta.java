package projeto.erro;

/**
 *
 * @author André
 */
public class RegraExceptionConsulta extends Exception{
    
    /**
     *Construtor da classe recebendo uma mensagem como parametro e enviando para a classe pai tratar.
     * @param msg
     */
    public RegraExceptionConsulta (String msg){
        super(msg);
    }
    
    /**
     * Construtot vazio da classe.
     */
    public RegraExceptionConsulta(){
        
    } 
}