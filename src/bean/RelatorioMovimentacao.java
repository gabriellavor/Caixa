package bean;

/**
 * Classe Responsavel por getter e setter para visualizar log de movimentação no banco de dados
 */
public class RelatorioMovimentacao {
    
    private int id;
    private String tipo;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    private double valor;
    
    
}
