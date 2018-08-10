package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.ConsultaDAO;
import projeto.acesso.ConsultaDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionConsulta;
import projeto.negocio.classesBasicas.Consulta;
import projeto.util.Msg;

/**
 *
 * @author Andre
 */
public class RegraConsulta {
    
    private final ConsultaDAO dao = new ConsultaDAOImpl();

    /**
     * Metodo para validar o objeto consulta.
     * @param consulta
     * @throws RegraExceptionConsulta 
     */
    public void validarConsulta(Consulta consulta) throws RegraExceptionConsulta {
        if (consulta.getDataConsulta() == null) {
            throw new RegraExceptionConsulta ("A data da consulta não pode ser deixada em branco");
        }
        if (consulta.getDescricaoConsulta() == null || consulta.getDescricaoConsulta().isEmpty()) {
            throw new RegraExceptionConsulta ("A descrição da consulta não pode ser deixada em branco");
        }
        if(consulta.getNomeAnimal() == null || consulta.getNomeAnimal().isEmpty()){
            throw new RegraExceptionConsulta ("O nome do animal não pode ser deixado em branco");
        }
        if(consulta.getNomeVeterinario() == null || consulta.getNomeVeterinario().isEmpty()){
            throw new RegraExceptionConsulta ("O nome do Veterinario não pode ser deixado em branco");
        }
        
    }
    
    /**
     * Metodo que verifica se já existe a consulta cadastrada.
     * @param consulta
     * @throws RegraExceptionConsulta
     * @throws DaoException 
     */
    public void verificaDuplicidade(Consulta consulta)throws RegraExceptionConsulta, DaoException{
        try{
            Consulta x = dao.pesquisar(consulta.getCodigoConsulta());
            if (x != null) {
                throw new RegraExceptionConsulta("Consulta já existe.");
            }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta(e.getMessage());
        }
    }

    /**
     * Metodo para inserir consulta no banco de dados.
     * @param consulta
     * @throws RegraExceptionConsulta
     * @throws DaoException 
     */
    public void inserir(Consulta consulta) throws RegraExceptionConsulta, DaoException{
        try{
            dao.inserir(consulta);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta(e.getMessage());
        }
    }

    /**
     *
     * @param codigoConsulta
     * @throws projeto.erro.RegraExceptionConsulta
     * @throws projeto.erro.ConexaoException
     * @throws projeto.erro.DaoException
     */
    public void deletar(int codigoConsulta) throws RegraExceptionConsulta,ConexaoException,DaoException{
         try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar a consulta", "Deletar Consulta");
        if(result == 0){
            dao.deletar(codigoConsulta);
        }
         }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta("Não foi possivel deletar a consulta do BD!");
        } 
    }

    /**
     *
     * @param consulta
     * @throws projeto.erro.RegraExceptionConsulta
     * @throws projeto.erro.ConexaoException
     * @throws projeto.erro.DaoException
     */
    public void atualizar(Consulta consulta) throws RegraExceptionConsulta,ConexaoException,DaoException {
        try{
            dao.atualizar(consulta);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta(e.getMessage());
        } 
    }

    /**
     *
     * @param codigoConsulta
     * @return
     * @throws RegraExceptionConsulta
     */
    public Consulta pesquisar(int codigoConsulta) throws RegraExceptionConsulta {
        Consulta consulta;
        try{
            consulta = dao.pesquisar(codigoConsulta);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta(e.getMessage());
        }
        return consulta;
    }

    /**
     *
     * @return
     * @throws RegraExceptionConsulta
     * @throws ConexaoException
     * @throws DaoException
     */
    public ArrayList<Consulta> listar() throws RegraExceptionConsulta,ConexaoException, DaoException {
        try{
            return dao.listar();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionConsulta(e.getMessage());
        } 
    }
    
}
