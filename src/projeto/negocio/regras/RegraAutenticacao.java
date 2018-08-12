package projeto.negocio.regras;

import projeto.acesso.AutenticacaoDAO;
import projeto.acesso.AutenticacaoDAOImpl;
import projeto.erro.AutenticacaoException;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.negocio.classesBasicas.Autenticacao;

/**
 *
 * @author Mario
 */
public class RegraAutenticacao {
    
    AutenticacaoDAO autenDao = new AutenticacaoDAOImpl();
    
    /**
     * Metodo para validar Objeto
     * @param autenticacao
     * @throws AutenticacaoException 
     */
    public void checarCredenciais(Autenticacao autenticacao) throws AutenticacaoException{
        if(autenticacao == null){
            throw new AutenticacaoException("Autenticação inválida");
        }
        if(autenticacao.getLogin().isEmpty() || autenticacao.getLogin() == null){
            throw new AutenticacaoException("Login não pode ser nulo");
        }
        if(autenticacao.getPass().isEmpty() || autenticacao.getPass() == null){
            throw new AutenticacaoException("Password não pode ser nulo");
        }
        if(autenticacao.getFunCpf().isEmpty() || autenticacao.getFunCpf() == null){
            throw new AutenticacaoException("CPF do cliente nao pode ser deixado nulo");
        }
        if(autenticacao.getPrimeiroAcesso().isEmpty() || autenticacao.getPrimeiroAcesso() == null || autenticacao.getPrimeiroAcesso().length() > 1){
            throw new AutenticacaoException("Primeiro Acesso inválido");
        }
    }
    
    /**
     * Metodo para validar a nova senha.
     * @param pass
     * @throws AutenticacaoException 
     */
    public void checarSenha(String pass) throws AutenticacaoException{
        if(pass.isEmpty()){
            throw new AutenticacaoException("Nova senha nao pode ser nula!");
        }
    }
    
    /**
     * Metodo parqa validar credenciais
     * @param login
     * @param pass
     * @throws AutenticacaoException 
     */
    public void validarLogin (String login, String pass) throws AutenticacaoException{
        if(login.isEmpty() || login == null){
            throw new AutenticacaoException("Login não pode ser nulo");
        }
        if(pass.isEmpty() || pass == null){
            throw new AutenticacaoException("Password não pode ser nulo");
        }
    }
    
    /**
     * Metodo para inserir as credenciais.
     * @param autenticacao
     * @throws AutenticacaoException
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void inserirCredenciais(Autenticacao autenticacao) throws AutenticacaoException,ConexaoException,DaoException{
        try{
            autenDao.criarCredenciais(autenticacao);
        }catch(ConexaoException | DaoException e){
            throw new AutenticacaoException(e.getMessage());
        }
    }
    
    /**
     * Metodo para consultar as credenciais.
     * @param login
     * @param pass
     * @return
     * @throws AutenticacaoException 
     */
    public Autenticacao consultarCredenciais(String login, String pass) throws AutenticacaoException{
        Autenticacao autenticacao;
        try{
            autenticacao = autenDao.checarAutenticacao(login, pass);
        }catch(ConexaoException | DaoException e){
            throw new AutenticacaoException("Falha na autenticação, contacte o administrador do sistema!");
        }
        return autenticacao;
    }
    
    /**
     * Metodo para alterar a senha.
     * @param oldPass
     * @param newPass
     * @param cpfCli
     * @throws AutenticacaoException
     * @throws ConexaoException
     * @throws DaoException 
     */
    public void alterarSenha(String oldPass, String newPass, String cpfCli) throws AutenticacaoException, ConexaoException, DaoException{
        try{
            Autenticacao autenticacao = autenDao.checarAutenticacao(cpfCli,oldPass);
            if(autenticacao != null){
                autenDao.alterarPassword(cpfCli, newPass);
            }else{
                throw new AutenticacaoException("A senha anterior está incorreta! Por favor, alterar as credenciais.");
            }
        }catch(ConexaoException | DaoException e){
            throw new AutenticacaoException("Falha ao tentar alterar a senha!");
        }
    }
    
}
