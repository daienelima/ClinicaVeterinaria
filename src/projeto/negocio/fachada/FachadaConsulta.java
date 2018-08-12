package projeto.negocio.fachada;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionConsulta;
import projeto.negocio.classesBasicas.Consulta;
import projeto.negocio.regras.RegraConsulta;

/**
 *
 * @author Andre
 */
public class FachadaConsulta {
    
    private static FachadaConsulta instancia;
    private final RegraConsulta regraConsulta;
    
    public FachadaConsulta(){
        
        regraConsulta = new RegraConsulta();
    }
    
    /**
     * Construtor da classe.
     * @return instancia.
     */
    public static FachadaConsulta getInstancia(){
        if(instancia==null)
            instancia = new FachadaConsulta();
        return instancia;
    }
    
    /**
     * Metodo para inserir checar conformidades antes de inserir uma consulta.
     * @param consulta
     * @throws RegraExceptionConsulta
     * @throws DaoException 
     */
    public void inserir(Consulta consulta)throws RegraExceptionConsulta, DaoException{
        regraConsulta.validarConsulta(consulta);
        regraConsulta.inserir(consulta);
    }
    
    /**
     * Metodo para deletar uma consulta.
     * @param codigoConsulta
     * @throws RegraExceptionConsulta
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletar(int codigoConsulta)throws RegraExceptionConsulta, ConexaoException, DaoException{
        regraConsulta.deletar(codigoConsulta);
    }
    
    /**
     * Metodo para atualizar uma consulta.
     * @param consulta
     * @throws RegraExceptionConsulta
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizar(Consulta consulta)throws RegraExceptionConsulta, ConexaoException, DaoException{
        regraConsulta.validarConsulta(consulta);
        regraConsulta.atualizar(consulta);
    }
    
    /**
     * Metodo para pesquisar uma consulta.
     * @param codigoConsulta
     * @return consulta
     * @throws RegraExceptionConsulta
     * @throws ConexaoException
     * @throws DaoException 
     */  
    public Consulta pesquisar(int codigoConsulta)throws RegraExceptionConsulta,ConexaoException,DaoException{
        Consulta consulta = regraConsulta.pesquisar(codigoConsulta);
        return consulta;
    }
    
    /**
     *
     * @return
     * @throws RegraExceptionConsulta
     * @throws projeto.erro.ConexaoException
     * @throws projeto.erro.DaoException
     */
    public ArrayList<Consulta> listarConsulta()throws RegraExceptionConsulta, ConexaoException, DaoException{
        return regraConsulta.listar();
    }
}
