
package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.TratamentoDAO;
import projeto.acesso.TratamentoDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Tratamento;
import projeto.erro.RegraExceptionTratamento;
import projeto.util.Msg;

/**
 * 
 * @author Camilo
 */
    
public class RegraTratamento {
    TratamentoDAO  tratamentoDao = new TratamentoDAOImpl();
    
    /**
     * Metodo para validar se o tratamento está nos conformes antes de manipular no BD.
     * @param tratamento
     * @throws RegraExceptionTratamento 
     */
    public void validaTratamento (Tratamento tratamento) throws RegraExceptionTratamento{
        if (tratamento == null) {
            throw new RegraExceptionTratamento("Impossível cadastrar Tratamento");
        }
        if (tratamento.getDataInicialTratamento() == null || tratamento.getDataInicialTratamento().isEmpty()) {
            throw new RegraExceptionTratamento ("A data do tratamento não pode ser deixada em branco");
        }
        if (tratamento.getDataFinalTratamento() == null || tratamento.getDataFinalTratamento().isEmpty()) {
            throw new RegraExceptionTratamento ("A data final do tratamento não pode ser deixada em branco");
        }
        if (tratamento.getDescricaoTratamento() == null || tratamento.getDescricaoTratamento().isEmpty()) {
            throw new RegraExceptionTratamento ("A descrição do tratamento não pode ser deixada em branco");
        }
        if (tratamento.getDiagnosticoTratamento() == null || tratamento.getDiagnosticoTratamento().isEmpty()) {
            throw new RegraExceptionTratamento ("O diagnostico do tratamento não pode ser deixada em branco");
        }
        if(tratamento.getNomeAnimal() == null || tratamento.getNomeAnimal().isEmpty()){
            throw new RegraExceptionTratamento ("O nome do animal não pode ser deixada em branco");
        }
    }
    
    /**
     * Metodo que verifica se o mesmo tratamento já foi cadastrado anteriormente.
     * @param tratamento
     * @throws RegraExceptionTratamento 
     */
    public void verificaDuplicidade(Tratamento tratamento)throws RegraExceptionTratamento {
        try{
            Tratamento tr = tratamentoDao.consultar(tratamento.getCodigoTratamento());
            if(tr != null){
                throw new RegraExceptionTratamento("Tratamento Já Cadastrado");
            }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento(e.getMessage());   
                       
        }
    }
    
    /**
     * Metodo que chama o DAO para inserir um tratamento no banco de dados
     * @param tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserirTratamento(Tratamento tratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        try{
             tratamentoDao.inserir(tratamento);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento(e.getMessage());
        }    
    }
    
    /**
     * Metodo que chama o DAO para deletar um tratamento do banco de dados
     * @param codTratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void deletarTratamento(int codTratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        
        try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar o tratamento?", "Deletar Tratamento");
        if(result == 0){
            tratamentoDao.deletar(codTratamento);
        }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento("Não foi possivel deletar o tratamento do BD!");
        } 
    }
    
    /**
     * Metodo que chama o DAO para atualizar um tratamento no banco de dados
     * @param tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizarTratamento(Tratamento tratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        try{
            tratamentoDao.atualizar(tratamento);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento(e.getMessage());
        } 
    }
    
    /**
     * Metodo que chama o DAO para realizar uma consulta no banco de dados
     * @param codigoTratamento
     * @return Tratamento
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Tratamento consultarTratamento(int codigoTratamento) throws RegraExceptionTratamento, ConexaoException, DaoException{
        Tratamento tratamento;
        try{
            tratamento = tratamentoDao.consultar(codigoTratamento);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento(e.getMessage());
        }
        return tratamento;
    }
    
    /**
     * Metodo que chama o DAO para listar todos os dados da tabela de tratamentos
     * @return List of Tratamentos.
     * @throws RegraExceptionTratamento
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Tratamento> listar()throws RegraExceptionTratamento, ConexaoException, DaoException{
        try{
            return tratamentoDao.listar();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionTratamento(e.getMessage());
        }      
    }
    
}