package dao;

import bean.Caixa;
import conexao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class CaixaDAO {
    
    private final String INSERT = "INSERT INTO transacao (tipo, valor) VALUES (?,?)";

    public void inserir(Caixa operacao) {
        if (operacao != null) {
            Connection conn = null;
            try {
                conn = ModuloConexao.conectar();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, operacao.getTipo());
                pstm.setString(2, Double.toString(operacao.getValor()));

                pstm.execute();
                ModuloConexao.fechaConexao(conn, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir no banco de "
                        + "dados " + e.getMessage());
            }
        }
    }
}
