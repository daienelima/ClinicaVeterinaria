
package projeto.negocio.classesBasicas;

/**
 *
 * @author Mario
 */
public class Autenticacao {
    
    private String login;
    private String pass;
    private String primeiroAcesso;
    private String funCpf;
    
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the superuser
     */
    public String getPrimeiroAcesso() {
        return primeiroAcesso;
    }

    /**
     * @param primeioAcesso
     */
    public void setPrimeiroAcesso(String primeioAcesso) {
        this.primeiroAcesso = primeioAcesso;
    }

    /**
     * @return the codigoFuncionario
     */
    public String getFunCpf() {
        return funCpf;
    }

    /**
     * @param funCpf
     */
    public void setFunCpf(String funCpf) {
        this.funCpf = funCpf;
    }
    
    
    
}
