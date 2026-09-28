package Projeto_Integrado_III_UNIFEOB;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {

    //Atributos
    private int id;
    private LocalDateTime data;
    private Vendedor vendedor;
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;
    private String status;
    private String formaPagamento;
    private double valorTotal;
    private double valorBruto;
    private double percentualDesconto;
    private double valorDesconto;
    private double descontoMaximo;


    //Construtor
    public Venda(int id, LocalDateTime data, Cliente cliente,
             Vendedor vendedor ,String formaPagamento) {

        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
        this.status = "ABERTA";
        this.formaPagamento = formaPagamento;
        this.valorTotal = 0;
    }


    //Metodos

    public void adicionarItem(ItemVenda item) {

        if (getStatus().equals("ABERTA")) {
            itens.add(item);
            calcularTotal();
        } else {
            System.out.println("Item recusado, Venda esta fechada");
        }
    }

    public void removerItem(ItemVenda item) {
        if (getStatus().equals("ABERTA")) {
            itens.remove(item);
            calcularTotal();
        } else {
            System.out.println("Remoção recusada, Venda esta fechada");
        }
    }

    public void calcularTotal() {

        valorBruto = 0;

        for (int i = 0; i < itens.size(); i++) {
            valorBruto += itens.get(i).getSubtotal();
        }

        valorTotal = valorBruto;
    }


    public void finalizarVenda() {

        if (getStatus().equals("ABERTA")) {

            boolean estoqueSuficiente = true;

            for (int i = 0; i < itens.size(); i++) {

                if (itens.get(i).getQuantidade() <= itens.get(i).getProduto().getQuantidade()) {

                } else {
                    estoqueSuficiente = false;
                    System.out.println("Venda não concluída, falta produto no estoque");
                }
            }

            if (estoqueSuficiente) {
                for(int i = 0; i < itens.size(); i++) {
                    itens.get(i).getProduto().removerEstoque(itens.get(i).getQuantidade());
                }
                status = "FECHADA";
                System.out.println("Venda concluída. STATUS: " + status);
            }
            } else {
                System.out.println("Não pode finalizar a venda, venda já esta fechada");
            }
        
    }

    public void calcularDescontoMaximo() {
        if (getValorTotal() < 500) {
            this.descontoMaximo = 0;
        } else if (getValorTotal() < 1200) {
            this.descontoMaximo = 5;
        } else {
            this.descontoMaximo = 15;
        }
    }

    public void aplicarDesconto(double percentual) {
        if (percentual <= descontoMaximo) {
            this.percentualDesconto = percentual;
            this.valorDesconto = valorBruto * percentual / 100;
            this.valorTotal = this.valorBruto - this.valorDesconto;
        } else {
            System.out.println("Desconto nao permitido, voce pode gerar no maximo: " + getDescontoMaximo() + "% de desconto");
        }
    }

        
    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente; 
    }   

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

}