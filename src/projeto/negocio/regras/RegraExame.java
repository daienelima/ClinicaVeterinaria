package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.ExameDAO;
import projeto.acesso.ExameDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionExame;
import projeto.negocio.classesBasicas.Exame;
import projeto.util.Msg;

/**
 *
 * @author Mario
 */
public class RegraExame {
    ExameDAO  exameDao = new ExameDAOImpl(); 
    /**
     * Valida se o objeto está nos conformes para ser inserido no banco de dados.
     * @param exame
     * @throws RegraExceptionExame 
     */
    public void validaExame(Exame exame) throws RegraExceptionExame{
        
        if(exame == null){
            throw new RegraExceptionExame("Todos os campos devem ser preenchidos");
        }
        
        if(exame.getNomeAnimal().isEmpty()){
            throw new RegraExceptionExame("O nome do Animal não pode estar vazio!");
        }
        if(exame.getVeterinarioExame().isEmpty()){
            throw new RegraExceptionExame("O nome do veterinário não pode estar vazio!");
        }
        if(exame.getVeterinarioExame().length() < 3){
            throw new RegraExceptionExame("O nome do Veterinário deve conter no minimo 3 digitos!");
        }
        if(exame.getExameDescricao().isEmpty()){
            throw new RegraExceptionExame("A descrição do exame deve ser preenchida!");
        }
        if(exame.getDataExame() == null){
            throw new RegraExceptionExame("A data do exame deve ser preenchida");
        }
        
    }
    
    /**
     * Inclui o exame no banco de dados
     * @param exame
     * @throws projeto.erro.RegraExceptionExame
     */
    public void incluirExame(Exame exame) throws RegraExceptionExame{
        try{
           exameDao.inserir(exame);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionExame(e.getMessage());
        } 
    
    }
    
    /**
     * Deletar exame do banco de dados.
     * @param codExame
     * @throws RegraExceptionExame 
     */
    public void deletarExame(int codExame) throws RegraExceptionExame{
        
        try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar o Exame?", "Deletar Exame");
        if(result == 0){
            exameDao.deletar(codExame);
        }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionExame("Não foi possivel deletar o Exame do BD!");
        }
         
    }
    
    /**
     * Metodo para listar Exame
     * @return
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Exame> listar()throws RegraExceptionExame, ConexaoException, DaoException{
        try{
            return exameDao.listarExames();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionExame(e.getMessage());
        }      
    }
    
    /**
     * Metodo para consultar exame
     * @param codigoExame
     * @return
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Exame consultarExame(int codigoExame) throws RegraExceptionExame, ConexaoException, DaoException{
        Exame exame;
        try{
            exame = exameDao.consultar(codigoExame);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionExame(e.getMessage());
        }
        return exame;
    }
    
    /**
     * Alterar exame no banco de dados
     * @param exame
     * @throws RegraExceptionExame
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void atualizarExame(Exame exame) throws RegraExceptionExame, ConexaoException, DaoException {
        try{
            exameDao.alterar(exame);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionExame(e.getMessage());
        }
    }
    
}
