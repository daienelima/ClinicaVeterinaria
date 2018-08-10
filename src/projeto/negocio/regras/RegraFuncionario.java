
package projeto.negocio.regras;

import java.util.ArrayList;
import projeto.acesso.FuncionarioDAO;
import projeto.acesso.FuncionarioDAOImpl;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionFuncionario;
import projeto.negocio.classesBasicas.Funcionario;
import projeto.util.Msg;

/**
 *
 * @author Mario
 */
public class RegraFuncionario {
    
    FuncionarioDAO daoFunc = new FuncionarioDAOImpl();
    
    /**
     * Metodo para validar se o objeto funcionario esta nos conformes para inserir no banco.
     * @param funcionario 
     * @throws projeto.erro.RegraExceptionFuncionario 
     */
    public void validaFuncionario(Funcionario funcionario) throws RegraExceptionFuncionario{
        
        if(funcionario == null){
            throw new RegraExceptionFuncionario("Todos os campos de funcionario devem ser preenchidos!");
        }
        if(funcionario.getNome().isEmpty()){
            throw new RegraExceptionFuncionario("O nome do funcionario não pode ser deixado em branco!");
        }
        if(funcionario.getNome().length() < 3){
            throw new RegraExceptionFuncionario("O nome do funcionario deve ter no minimo 3 caracteres");
        }
        if(funcionario.getCpf().isEmpty()){
            throw new RegraExceptionFuncionario("O CPF do funcionario nao pode ser deixado em branco!");
        }
        if(funcionario.getTelefone().isEmpty()){
            throw new RegraExceptionFuncionario("O Telefone do funcionario nao pode ser deixado em branco!");
        }
        if(funcionario.getCargo().equals("Selecione o Cargo")){
            throw new RegraExceptionFuncionario("O cargo do funcionario deve ser alterado para uma opção válida!");
        }
    }
    
    /**
     * Metodo que verifica se o funcionario ja existe no banco de dados.
     * @param funcionario 
     * @throws projeto.erro.RegraExceptionFuncionario 
     */
    public void verificaDuplicidade(Funcionario funcionario) throws RegraExceptionFuncionario{
        try{
            if(daoFunc.consultar(funcionario.getCpf()) == null){
                throw new RegraExceptionFuncionario("Funcionario Já consta no banco de dados");
            }
        }catch(ConexaoException e){
            throw new RegraExceptionFuncionario("Erro no banco de dados, Favor tentar novamente!");
        }catch(DaoException e){
            throw new RegraExceptionFuncionario("Um erro inesperado na aplicação ocorreu, favor tentar novamente");
        }
    }
    
    /**
     * Metodo que insere os dados do funcionario no banco de dados.
     * @param funcionario 
     * @throws projeto.erro.DaoException 
     * @throws projeto.erro.ConexaoException 
     */
    public void incluirFuncionario(Funcionario funcionario) throws DaoException, ConexaoException{
        daoFunc.inserir(funcionario);
    }
    
    /**
     * Metodo que deleta um funcionario do banco de dados.
     * @param codigoFuncionario
     * @throws DaoException
     * @throws ConexaoException 
     * @throws projeto.erro.RegraExceptionFuncionario 
     */
    public void deletarFuncionario(int codigoFuncionario) throws DaoException, ConexaoException, RegraExceptionFuncionario{
        
        try{
            int result = Msg.msgConfirm("Tem certeza que deseja deletar o Funcionario?", "Deletar Funcionario");
        if(result == 0){
            daoFunc.deletar(codigoFuncionario);
        }
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionFuncionario("Não foi possivel deletar o Funcionario do BD!");
        } 
        
    }
    
    /**
     * Metodo para alterar funcionario do banco de dados.
     * @param func
     * @throws DaoException
     * @throws ConexaoException
     * @throws RegraExceptionFuncionario 
     */
    public void alterarFuncionario(Funcionario func) throws DaoException, ConexaoException, RegraExceptionFuncionario{
        try{
            daoFunc.alterar(func);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionFuncionario(e.getMessage());
        }
    }
    
    /**
     * Metodo para consultar um funcionario
     * @param cpf
     * @return
     * @throws RegraExceptionFuncionario
     * @throws ConexaoException
     * @throws DaoException 
     */
    public Funcionario consultarFuncionario(String cpf) throws RegraExceptionFuncionario, ConexaoException, DaoException{
        Funcionario func;
        try{
            func = daoFunc.consultar(cpf);
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionFuncionario(e.getMessage());
        }
        return func;
    }
    
    /**
     * Metodo para listar todos os funcionarios e retornar uma lista
     * @return lista de funcionarios
     * @throws RegraExceptionFuncionario
     * @throws ConexaoException
     * @throws DaoException 
     */
    public ArrayList<Funcionario> listarFuncionarios()throws RegraExceptionFuncionario, ConexaoException, DaoException{
        try{
            return daoFunc.consultarFuncionarios();
        }catch(ConexaoException | DaoException e){
            throw new RegraExceptionFuncionario(e.getMessage());
        }      
    }
    
}
