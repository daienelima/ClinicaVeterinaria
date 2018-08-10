package projeto.acesso;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Consulta;

/**
 *
 * @author Andre
 */
public interface ConsultaDAO {
    
    /**
     *
     * @param codigoConsulta
     * @return
     * @throws ConexaoException
     * @throws DaoException
     */
    public Consulta pesquisar(int codigoConsulta) throws ConexaoException, DaoException;
      
    /**
     * Assinatura do método inserir
     * @param consulta
     * @throws ConexaoException
     * @throws DaoException
     */
    public void inserir(Consulta consulta)throws ConexaoException, DaoException;
    
    /**
     * Adeletarssinatura do método 
     * @param codigoConsulta
     * @throws ConexaoException
     * @throws DaoException
     */
    public void deletar(int codigoConsulta)throws ConexaoException, DaoException;
    
    /**
     * Assinatura do método atualizar
     * @param consulta
     * @throws ConexaoException
     * @throws DaoException
     */
    public void atualizar(Consulta consulta)throws ConexaoException, DaoException;
    
    /**
     * Lista para busca com o retorno de mais de uma consulta.
     * @return
     * @throws ConexaoException
     * @throws DaoException
     */
    public ArrayList<Consulta> listar()throws ConexaoException, DaoException;   
}

