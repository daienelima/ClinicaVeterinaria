
package projeto.negocio.fachada;


import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionTratamento;
import projeto.negocio.classesBasicas.Tratamento;
import projeto.negocio.regras.RegraTratamento;

/**
 * 
 * @author Camilo
 */

public class FachadaTratamento {
    RegraTratamento rt = new RegraTratamento();
    
    /**
     * Metodo para checar conformidades antes de inserir um tratamento.
     * @param tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserirTratamento (Tratamento tratamento) throws RegraExceptionTratamento, ConexaoException, DaoException {        
        rt.validaTratamento(tratamento);
        rt.inserirTratamento(tratamento);  
    }
    
    /**
     * Metodo para deletar um tratamento do BD.
     * @param codTratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletarTratamento (int codTratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        rt.deletarTratamento(codTratamento);
    }
    
    /**
     * Metodo para alterar um tratamento do banco de dados.
     * @param tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void alterarTratamento (Tratamento tratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        rt.validaTratamento(tratamento);
        rt.atualizarTratamento(tratamento);
         
    }
    
    /**
     * Metodo para consultar um tratamento.
     * @param codigoTratamento
     * @return Tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Tratamento consultarTratamento (int codigoTratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        Tratamento tratamento = rt.consultarTratamento(codigoTratamento);
        return tratamento;
    }
    
    /**
     * Metodo para listar todos os tratamentos do banco de dados.
     * @return List de tratamentos
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Tratamento> listarTratamento()throws RegraExceptionTratamento, ConexaoException, DaoException{
        return rt.listar();      
    }
}