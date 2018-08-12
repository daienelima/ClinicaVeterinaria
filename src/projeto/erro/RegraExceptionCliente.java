package projeto.erro;

/**
 *
 * @author Daiene
 */
public class RegraExceptionCliente extends Exception {
  
    /**
     * Construtor vazio da classe RegraExceptionFuncionario.
     */
    public RegraExceptionCliente(){
    }
     /**
     * Construtor da classe recebendo uma mensagem como parametro para exibir na tela.
     * @param msg 
     */
    public RegraExceptionCliente (String msg){
        super(msg);
    }
    
    /**
     * Construtor recebendo um exception.
     * @param e 
     */
    public RegraExceptionCliente (Exception e){
        super(e);
    }
    
}
