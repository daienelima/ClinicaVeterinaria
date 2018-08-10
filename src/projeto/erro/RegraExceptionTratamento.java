/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.erro;

/**
 *
 * @author camilo
 */
public class RegraExceptionTratamento extends Exception {
    
   /**
    * Construtor da classe recebendo uma String como parametro e enviando para a classe pai tratar.
    * @param msg 
    */
    public RegraExceptionTratamento (String msg){
        super(msg);
    }
    
    /**
     * Construtor da classe vazio.
     */
    public RegraExceptionTratamento(){
    }
    
    /**
     * Construtor da classe recebendo um exception e enviando para a classe pai tratar.
     * @param e 
     */
    public RegraExceptionTratamento (Exception e){
        super(e);
    }
     
}
