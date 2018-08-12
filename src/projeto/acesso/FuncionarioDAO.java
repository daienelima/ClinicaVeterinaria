package projeto.acesso;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Funcionario;

/**
 *
 * @author Mario
 */
public interface FuncionarioDAO {
    
    /**
     * Assinatura do metodo Incluir.
     * @param funcionario
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void inserir(Funcionario funcionario)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo Alterar.
     * @param funcionario
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void alterar(Funcionario funcionario)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo Deletar
     * @param codFunc
     * @throws DaoException
     * @throws ConexaoException 
     */
    public void deletar(int codFunc)throws DaoException, ConexaoException;
    
    /**
     * Assinatura do metodo consultar.
     * @param cpf
     * @return
     * @throws DaoException
     * @throws ConexaoException 
     */
    public Funcionario consultar(String cpf)throws DaoException, ConexaoException;
    
    /**
     * Lista para busca com o retorno de mais de um Funcionario.
     * @return 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public ArrayList<Funcionario> consultarFuncionarios() throws ConexaoException, DaoException;
}
