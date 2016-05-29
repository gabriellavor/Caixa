/**
 Classe Responsavel por tabela do relatorio de logs de transação
*/
package tableModel;

import bean.RelatorioMovimentacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RelatorioMovimentacaoTableModel extends AbstractTableModel{
    
    private static final int COL_ID = 0;
    private static final int COL_TIPO = 1;
    private static final int COL_VALOR = 2;
    private static final int COL_DATA = 3;
    List<RelatorioMovimentacao> linhas;
    private String[] colunas = new String[]{"Codigo Operação", "Tipo", "Valor", "Data"};

    public RelatorioMovimentacaoTableModel(List<RelatorioMovimentacao> contatos) {
        this.linhas = new ArrayList<>(contatos);
    }
        
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {

        RelatorioMovimentacao m = linhas.get(row);

        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_TIPO) {
            return m.getTipo();
        } else if (column == COL_VALOR) {
            return m.getValor();
        } else if (column == COL_DATA) {
            return m.getData();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        RelatorioMovimentacao u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_TIPO) {
            u.setTipo(aValue.toString());
        } else if (column == COL_VALOR) {
            u.setValor(Double.valueOf(aValue.toString()).doubleValue());            
        } else if (column == COL_DATA) {
            u.setData(aValue.toString());
        }
    }

    public RelatorioMovimentacao getContato(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    
    
}
