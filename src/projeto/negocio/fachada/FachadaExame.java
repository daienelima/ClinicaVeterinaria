package projeto.negocio.fachada;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionExame;
import projeto.negocio.classesBasicas.Exame;
import projeto.negocio.regras.RegraExame;

/**
 *
 * @author Mario
 */
public class FachadaExame {
    
    RegraExame regraExame = new RegraExame();
    
    /**
     * Metodo para inserir exame
     * @param exame
     * @throws RegraExceptionExame 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void agendarExame(Exame exame) throws RegraExceptionExame,ConexaoException, DaoException{
        regraExame.validaExame(exame);
        regraExame.incluirExame(exame);
    }
    
    /**
     * Metodo para deletar o exame.
     * @param codExame
     * @throws RegraExceptionExame 
     * @throws projeto.erro.ConexaoException 
     * @throws projeto.erro.DaoException 
     */
    public void deletarExame(int codExame) throws RegraExceptionExame,ConexaoException, DaoException{
        regraExame.deletarExame(codExame);
    }
    
    /**
     * Metodo para consultar um exame
     * @param codigoExame
     * @return
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Exame consultarExameCod(int codigoExame) throws RegraExceptionExame,ConexaoException, DaoException{
        Exame exame = regraExame.consultarExame(codigoExame);
        return exame;
    }
    
    /**
     * Metodo para listar todos os exames
     * @return
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Exame> listarExames()throws RegraExceptionExame, ConexaoException, DaoException{
        return regraExame.listar();      
    }
    
    /**
     * Metodo para alterar o exame
     * @param exame
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void alterarExame (Exame exame) throws RegraExceptionExame, ConexaoException, DaoException{
        regraExame.validaExame(exame);
        regraExame.atualizarExame(exame);  
    }
    
}
