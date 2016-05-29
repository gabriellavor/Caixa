/**
 * Classe Resposanvel por Exibir a tabela de logs de transação ao finalizar
 */
package telas;

import bean.RelatorioMovimentacao;
import dao.RelatorioMovimentacaoDAO;
import tableModel.RelatorioMovimentacaoTableModel;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class RelatorioMovimentacaoTela extends JFrame{
    
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private RelatorioMovimentacaoTableModel modelo;
    List<RelatorioMovimentacao> lista;

    public RelatorioMovimentacaoTela() {
        super("Relatorio de Movimentação");
        criaJTable();
        criaJanela();
    }

    public void criaJanela() {
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private void criaJTable() {
        tabela = new JTable(modelo);
        pesquisar();
    }

    private void pesquisar() {
        RelatorioMovimentacaoDAO dao = new RelatorioMovimentacaoDAO();
        lista = dao.getContatos();
        modelo = new RelatorioMovimentacaoTableModel(lista);
        tabela.setModel(modelo);
    }
   

    public static void main(String[] args) {
        RelatorioMovimentacaoTela lc = new RelatorioMovimentacaoTela();
        lc.setVisible(true);
    }
    
}
