package Projeto_Integrado_III_UNIFEOB;

import java.time.LocalDateTime;

public class EntradaEstoque {
    
    //Atributos
    private int id;
    private LocalDateTime data;
    private Produto produto;
    private int quantidade;
    private Fornecedor fornecedor;
    private double custoUnitario;
    private double total;

    //Construtor
    public EntradaEstoque(
        int id, 
        LocalDateTime data, 
        Produto produto, 
        int quantidade,
        Fornecedor fornecedor, 
        double custoUnitario) {

        this.id = id;
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.custoUnitario = custoUnitario;
        calcularTotal();
    }
    

    //Metodos
    public void  calcularTotal() {
        setTotal(getCustoUnitario() * getQuantidade());
    }

    public void registrarEntrada() {
        produto.adicionarEstoque(getQuantidade());
    }


    public void exibirEntrada() {
        System.out.println("---------------- ENTRADA DE ESTOQUE ----------------");
        System.out.println("ID: " + getId());
        System.out.println("Data: " + getData());
        System.out.println("Produto: " + getProduto().getNome());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Fornecedor: " + getFornecedor());
        System.out.println("Custo unitário: " + getCustoUnitario());
        System.out.println("Total: " + getTotal());
        
    }


    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int numero) {
        this.id = numero;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    



}
