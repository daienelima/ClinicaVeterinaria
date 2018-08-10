package projeto.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Mario
 */
public class TableTratamento extends AbstractTableModel{
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public TableTratamento(ArrayList linhas, String[]colunas){
        setLinhas(linhas);
        setColunas(colunas);
    }
    
    /**
     * Metodo que conta a quantidade de colunas da table;
     * @return 
     */
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    /**
     * Metodo que conta a quantidade de linhas
     * @return 
     */
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    
    /**
     * Metodo que pega o nome da coluna pela posição inteira
     * @param numCol
     * @return 
     */
    @Override
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    /**
     * Metodo que pega o valor em determinada linha/coluna da tabela
     * @param numLin
     * @param numCol
     * @return 
     */
    @Override
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
    
}
