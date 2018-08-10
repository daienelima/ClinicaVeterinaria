/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.erro;

/**
 *
 * @author Mario
 */
public class RegraExceptionFuncionario extends Exception {
    
    /**
     * Construtor vazio da classe RegraExceptionFuncionario.
     */
    public RegraExceptionFuncionario(){
    
    } 
    /**
     * Construtor da classe recebendo uma mensagem como parametro para exibir na tela.
     * @param txt 
     */
    public RegraExceptionFuncionario(String txt){
        super(txt);
    }
    
    /**
     * Construtor da classe recebendo um Exception como parametro e enviando para a classe pai tratar.
     * @param e 
     */
    public RegraExceptionFuncionario(Exception e){
        super(e);
    }
    
}
