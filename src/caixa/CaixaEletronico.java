package caixa;

import bean.Caixa;
import dao.CaixaDAO;
import interfaces.ICaixaEletronico;

public class CaixaEletronico implements ICaixaEletronico {

    private static int cedulas[][];
    private static int cotamin; // Cota minima
    private static int somacedulas;// Soma as cedulas que estão disponiveis

    public CaixaEletronico() {
        if(cedulas == null){
            cedulas = new int[6][2];
            // Inicializando as cedulas nas matrizes criadas
            // Cedulas de 2 reais
            cedulas[0][0] = 2;
            cedulas[0][1] = 0;
            // Cedulas de 5 reais
            cedulas[1][0] = 5;
            cedulas[1][1] = 0;
            // Cedulas de 10 reais
            cedulas[2][0] = 10;
            cedulas[2][1] = 0;
            // Cedulas de 20 reais
            cedulas[3][0] = 20;
            cedulas[3][1] = 0;
            // Cedulas de 50 reais
            cedulas[4][0] = 50;
            cedulas[4][1] = 0;
            // Cedulas de 100 reais
            cedulas[5][0] = 100;
            cedulas[5][1] = 0;       
        }
    }
  
    @Override
    public String pegaRelatorioCedulas() {
        String resposta = "Relatório de cedulas\n\n";

        for (int lista = 0; lista < 6; lista++) {
            resposta += "Cedulas de R$ " + cedulas[lista][0] + ",00 possui " + cedulas[lista][1]
                    + " cédulas disponíveis\n";
        }
        return resposta;
    }
    
    @Override
    public String pegaValorTotalDisponivel() {
        String resposta = "";
        int somacedulas;
        // logica de pega o valor total disponivel no caixa eletronio
        int ce2, ce5, ce10, ce20, ce50, ce100;
        
        // Calculo para encontra o valor
        ce2 = cedulas[0][1] * 2;
        ce5 = cedulas[1][1] * 5;
        ce10 = cedulas[2][1] * 10; 
        ce20 = cedulas[3][1] * 20;
        ce50 = cedulas[4][1] * 50;
        ce100 = cedulas[5][1] * 100;

        somacedulas = ce2 + ce5 + ce10 + ce20 + ce50 + ce100;       
        resposta = Integer.toString(somacedulas);
        return resposta;
    }

    @Override
    public String reposicaoCedulas(Integer cedula, Integer quantidade) {
        String resposta = "Reposicao";
        Caixa caixaBean = new Caixa();
        CaixaDAO caixadao = new CaixaDAO();
        caixaBean.setTipo("Entrada");
        caixaBean.setValor(cedula * quantidade);   
        // logica de fazer a reposicao de cedulas e criar uma mensagem
        // (resposta)ao usuario
        if (cedula == 2 || cedula == 5 || cedula == 10 || cedula == 20 || cedula == 50 || cedula == 100) {
            if (quantidade > 0) {
                if (cedula == 2) {
                    cedulas[0][1] = cedulas[0][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + " cedulas de R$ " + cedula + ",00";
                }

                if (cedula == 5) {
                    cedulas[1][1] = cedulas[1][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + "  cedulas de R$ " + cedula + ",00";
                }

                if (cedula == 10) {
                    cedulas[2][1] = cedulas[2][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + "  cedulas de R$ " + cedula + ",00";
                }

                if (cedula == 20) {
                    cedulas[3][1] = cedulas[3][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + "  cedulas de R$ " + cedula + ",00";
                }

                if (cedula == 50) {
                    cedulas[4][1] = cedulas[4][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + "  cedulas de R$ " + cedula + ",00";
                }

                if (cedula == 100) {
                    cedulas[5][1] = cedulas[5][1] + quantidade;
                    resposta = "Reposição com sucesso!\n";
                    resposta += "Colocado " + quantidade + "  cedulas de R$ " + cedula + ",00";
                }
                
                caixadao.inserir(caixaBean);
            } else {
                resposta = "Você não pode inserir menos de uma cédula";
            }
        } else {
            resposta = "Só podera inserir cédulas dos seguintes valores:\n";
            resposta += "\t R$2,00 \n\t R$5,00 \n\t R$10,00 \n\t R$20,00 \n\t R$50,00 \n\t R$100,00";
        }
        return resposta;
    }

    @Override
    public String sacar(Integer valor) {
        String resposta = ""; 
        
        Caixa caixaBean = new Caixa();
        CaixaDAO caixadao = new CaixaDAO();
        CaixaEletronico caixaEletronico = new CaixaEletronico();
        caixaBean.setTipo("Saida");
        caixaBean.setValor(valor);            
        
        // logica de sacar do caixa eletronico e criar um mensagem(resposta) ao usuario	

        int q100 = 0, q50 = 0, q20 = 0, q10 = 0, q5 = 0, q2 = 0, somar, auxiliar = valor;
        // Controlar as  cedulas emitidas
        // Máximo de saque R$999,00 // minimo R$2,00
        if ((valor >= 1000) || (valor <= 0) || valor > Integer.parseInt(pegaValorTotalDisponivel())) {
            resposta = "Valor indisponivel!";
        } else {
            
            somacedulas = Integer.parseInt(pegaValorTotalDisponivel());
            
            if (somacedulas >= cotamin) { // Se o total de cédulas for maior ou
                // O lopp de saque funciona enquanto o valor for maior ou igual
                // ao valor que tem, o loop verifica se há notas// disponiveis para o saque,
                // caso não exista nota disponivel, ele para o // loop, fazendo para que ele passe
                // para o próximo, caso exista notas, ele faz a // contagem de notas emitidas e
                // O valor é decrementado.
                while (valor >= 100) {
                    if (cedulas[5][1] <= 0) {
                        cedulas[5][1] = 0; 
                        break; 
                    } else { 
                        q100++; 
                        valor -= 100; 
                    }
                }

                while (valor >= 50) {
                    if (cedulas[4][1] <= 0) {
                        cedulas[4][1] = 0;
                        break;
                    } else {
                        q50++;
                        valor -= 50;
                    }
                }

                while (valor >= 20) {
                    if (cedulas[3][1] <= 0) {
                        cedulas[3][1] = 0;
                        break;
                    } else {
                        q20++;
                        valor -= 20;
                    }
                }

                while (valor >= 10) {
                    if (cedulas[2][1] <= 0) {
                        cedulas[2][1] = 0;
                        break;
                    } else {
                        q10++;
                        valor -= 10;
                    }
                }

                while ((valor == 6) || (valor == 8)) {
                    if (cedulas[0][1] <= 0) {
                        cedulas[0][1] = 0;
                        break;
                    } else {
                        q2++;
                        valor -= 2;
                    }
                }

                while (valor >= 5) {
                    if (cedulas[1][1] <= 0) {
                        cedulas[1][1] = 0;
                        break;
                    } else {
                        q5++;
                        valor -= 5;
                    }
                }

                while (valor >= 2) {
                    if (cedulas[0][1] <= 0) {
                        cedulas[0][1] = 0;
                        break;
                    } else {
                        q2++;
                        valor -= 2;
                    }
                }

                somar = q100 + q50 + q20 + q10 + q5 + q2; // Soma das cedulas

                if ((valor == 0) && (somar <= 30)) {
                    /* Se o valor do saque for aceito,zerado e não forem dadas  mais de 30 notas,
                     * ele faz o decremento das cedulas no caixa e mostra pro usuario,quantas notas de
                     * cada cedula ele recebeu
                     * */
                    cedulas[0][1] -= q2;
                    cedulas[1][1] -= q5;
                    cedulas[2][1] -= q10;
                    cedulas[3][1] -= q20;
                    cedulas[4][1] -= q50;
                    cedulas[5][1] -= q100;

                    resposta = "Saque requisitado: R$" + auxiliar + ",00\n\nNotas de R$100: " + q100 + "\n";
                    resposta += "Notas de R$50: " + q50 + "\n";
                    resposta += "Notas de R$20: " + q20 + "\n";
                    resposta += "Notas de R$10: " + q10 + "\n";
                    resposta += "Notas de R$5: " + q5 + "\n";
                    resposta += "Notas de R$2: " + q2 + "\n";
                    caixadao.inserir(caixaBean);
                }

            } else {
                resposta = "\n\nErro a operação sera cancelada.Por favor entre em contato com o administrador";
            }
        }
        
        return resposta;
    }
    
    @Override
    public String armazenaCotaMinima(Integer minimo) {
        String resposta = "";
        // logica de armazenar a cota minima para saque e criar um mensagem(resposta)ao usuario
        setCotamin(minimo);
        
        // Armazena a Cota minima definida
        resposta = "Cota minima definida para: R$" + getCotamin() + ",00";

        return resposta;
    }
    
    public int getCotamin(){
        return cotamin;
    }
    
    public void setCotamin(int cotamin){
       this.cotamin = cotamin;
    }
    
    public boolean verificaCotaMinima(){
        if(getCotamin() < Integer.parseInt(pegaValorTotalDisponivel())){
            return true;
        }
        return false;
        
    }
    
     
}