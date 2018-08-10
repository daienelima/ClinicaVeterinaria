package projeto;

import java.sql.Connection;
import java.sql.SQLException;
import projeto.erro.ConexaoException;
import projeto.erro.DaoException;
import projeto.erro.RegraExceptionCliente;
import projeto.util.GerenciadorConexao;
import projeto.util.GerenciadorConexaoImpl;

/**
 *
 * @author daiene
 */
   public class ProjetoPOOEquipe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConexaoException  {
        testaconexao();
        
    }

    private static void testaconexao() throws ConexaoException  {
        GerenciadorConexao ger = GerenciadorConexaoImpl.getInstancia();
        try {
            Connection con = ger.abrirConexao();
            ger.fecharConexao(con);
            System.out.println("funcionou!");
        }catch(ConexaoException e){
            throw new ConexaoException("não funcionou");
        }     
    }

}
