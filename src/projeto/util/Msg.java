/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class Msg {
    
    static Icon sucesso = new ImageIcon("src/projeto/gui/icones/successIcon.png");
    
    /**
     * Metodo que recebe dois textos como parametro,
     * um para o corpo do popup
     * um para o titulo do popup
     * e exibe uma mensagem de sucesso.
     * @param msg
     * @param title 
     */
    public static void msgSucesso(String msg, String title){
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE, sucesso);
    }

    /**
     * Metodo que recebe dois textos como parametro,
     * um para o corpo do popup
     * um para o titulo do popup
     * e exibe uma mensagem solicitando a confirmação de determinada ação.
     * @param msg
     * @param title
     * @return 
     */
    public static int msgConfirm(String msg, String title){
        int result = JOptionPane.showConfirmDialog(null,msg,title,JOptionPane.YES_NO_OPTION);
        return result;
    }
    
    /**
     * Metodo que recebe dois textos como parametro,
     * um para o corpo do popup
     * um para o titulo do popup
     * e exibe uma mensagem de erro
     * @param msg
     * @param title 
     */    
    public static void msgErro(String msg, String title){
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
    }
    
}
