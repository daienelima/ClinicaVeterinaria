/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.acesso;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Exame;

/**
 *
 * @author Mario
 */
public interface ExameDAO {
    
    /**
     * Assinatura do metodo inserir.
     * @param exame
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void inserir(Exame exame)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo alterar.
     * @param exame
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void alterar(Exame exame)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo deletar
     * @param codExame
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void deletar(int codExame)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo consultar
     * @param codExame
     * @return
     * @throws DaoException
     * @throws ConexaoException 
     */
    public Exame consultar(int codExame)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do array para retorno de mais de um objeto.
     * @return 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public ArrayList<Exame> listarExames() throws ConexaoException, DaoException;
    
}
