package projeto.erro;

/**
 *
 * @author Mario
 */
public class RegraExceptionExame extends Exception{
    
    /**
     * Construtor vazio da classe RegraExceptionFuncionario.
     */
    public RegraExceptionExame(){ 
    }  
    /**
     * Construtor da classe recebendo uma mensagem como parametro para exibir na tela. 
     * @param msg
     */
    public RegraExceptionExame(String msg){
        super(msg);
    }
    
    /**
     * Construtor da classe recebendo um exception e enviando para a classe pai tratar.
     * @param e 
     */
    public RegraExceptionExame (Exception e){
        super(e);
    }
    
}
