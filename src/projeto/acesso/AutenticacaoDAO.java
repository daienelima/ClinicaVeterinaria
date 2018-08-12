
package projeto.acesso;

import projeto.erro.AutenticacaoException;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Autenticacao;

/**
 *
 * @author Mario
 */
public interface AutenticacaoDAO {
    
    /**
     * Metodo para verificar no banco se existe tal login
     * @param login
     * @param pass
     * @return autenticacao
     * @throws AutenticacaoException 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public Autenticacao checarAutenticacao(String login, String pass) throws AutenticacaoException, ConexaoException, DaoException;
    
    /**
     * Metodo para criar as credenciais no banco de dados
     * @param autenticacao
     * @throws AutenticacaoException 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void criarCredenciais(Autenticacao autenticacao) throws AutenticacaoException, ConexaoException, DaoException;
    
    /**
     * Metodo para alterar o password.
     * @param cpfCli
     * @param newPassword
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void alterarPassword(String cpfCli, String newPassword) throws ConexaoException, DaoException;
}
