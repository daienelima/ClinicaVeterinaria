
package projeto.acesso;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Tratamento;

/**
 * 
 * @author Camilo
 */
public interface TratamentoDAO {
    
    /**
     * Metodo para consultar um tratamento no BD.
     * @param codigoTratamento
     * @return Tratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Tratamento consultar(int codigoTratamento) throws ConexaoException, DaoException;
    
    /**
     * Metodo para inserir um tratamento no banco de dados
     * @param tratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserir(Tratamento tratamento)throws ConexaoException, DaoException; 
    
    /**
     * Metodo para deletar um tratamento do banco de dados.
     * @param codigoTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletar(int codigoTratamento)throws ConexaoException, DaoException;
    
    /**
     * Metodo para atualizar um tratamento do banco de dados.
     * @param tratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizar(Tratamento tratamento)throws ConexaoException, DaoException;
    
    /**
     * Metodo para listar todos os tratamentos do banco de dados
     * @return
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Tratamento> listar()throws ConexaoException, DaoException;
}
