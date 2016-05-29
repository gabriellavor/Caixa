package dao;

import bean.RelatorioMovimentacao;
import conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Lavor
 */
public class RelatorioMovimentacaoDAO {  
    private final String LIST = "SELECT * FROM transacao";
    private final String LISTBYID = "SELECT * FROM transacao WHERE ID=?";
    private final String LISTBYNOMEFONE = "SELECT * FROM transacao WHERE NOME=? AND TELEFONE=?";

    public List<RelatorioMovimentacao> getContatos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<RelatorioMovimentacao> contatos = new ArrayList<RelatorioMovimentacao>();
        try {
            conn = ModuloConexao.conectar();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                RelatorioMovimentacao contato = new RelatorioMovimentacao();
               
                contato.setId(rs.getInt("id"));
                contato.setTipo(rs.getString("tipo"));
                contato.setValor(rs.getDouble("valor"));
                contato.setData(rs.getString("data"));
                contatos.add(contato);
            }
            ModuloConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return contatos;
    }

    public RelatorioMovimentacao getContatoById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        RelatorioMovimentacao contato = new RelatorioMovimentacao();
        try {
            conn = ModuloConexao.conectar();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setTipo(rs.getString("tipo"));
                contato.setValor(rs.getDouble("valor"));
                contato.setData(rs.getString("data"));
            }
            ModuloConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return contato;
    }

    public RelatorioMovimentacao getContatoByNomeTel(RelatorioMovimentacao c) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        RelatorioMovimentacao contato = new RelatorioMovimentacao();
        try {
            conn = ModuloConexao.conectar();
            pstm = conn.prepareStatement(LISTBYNOMEFONE);
            pstm.setString(1, c.getTipo());
            rs = pstm.executeQuery();
            while (rs.next()) {
                contato.setId(rs.getInt("id"));
                contato.setTipo(rs.getString("tipo"));
                contato.setValor(rs.getDouble("valor"));
                contato.setData(rs.getString("data"));

            }
            ModuloConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return contato;
    }
}
