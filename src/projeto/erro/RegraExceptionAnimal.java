package projeto.erro;

/**
 * 
 * @author Geraldo
 */
 public class RegraExceptionAnimal extends Exception {
  
    /**
     * Construtor vazio da classe RegraExceptionFuncionario.
     */
    public RegraExceptionAnimal(){
    }
     /**
     * Construtor da classe recebendo uma mensagem como parametro para exibir na tela.
     * @param msg 
     */
    public RegraExceptionAnimal (String msg){
        super(msg);
    }
    
    /**
     * Construtor da classe recebendo um Exception como parametro e enviando para a classe pai tratar.
     * @param e 
     */
    public RegraExceptionAnimal (Exception e){
        super(e);
    }
    
}