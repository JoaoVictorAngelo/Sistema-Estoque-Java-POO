package Projeto_Integrado_III_UNIFEOB;


public class Produto {


    // Atributos
    private int id;
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private int quantidade;
    private int estoqueMinimo;
    private String categoria;



    //Construtor
    public Produto(
        int id, 
        String nome,
        String descricao, 
        double precocompra, 
        double precovenda,
        int quantidade,
        int estoqueminimo,
        String categoria ) {
    
        this.id = id;
        this.nome = nome;  
        this.descricao = descricao;
        this.precoCompra = precocompra;
        this.estoqueMinimo = estoqueminimo;
        this.categoria = categoria;

        setPrecoVenda(precovenda);
        setQuantidade(quantidade);

        
    }

    //Metodos

    public void mostrarProduto() {
        System.out.println(
            "-------Informações do Produto-------" +
            "\nNome: " + getNome() +
            "\nID: " + getId() +
            "\nCategoria: " + getCategoria() +
            "\nDescrição: " + getDescricao() +
            "\nQuantidade em estoque: " + getQuantidade() +
            "\n-----------------------------------------------------------------------" +
            "\nPreço de compra: " + getPrecoCompra() +
            "\nPreço de venda: " + getPrecoVenda() +
            "\nEstoque minimo: " + getEstoqueMinimo()
        );
    }

    public void adicionarEstoque (int quantidade) {
        if (quantidade > 0 ) {
            setQuantidade(getQuantidade() + quantidade);
        } else {
            System.out.println("Não pode adicionar valores negativos");
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
             System.out.println("Não pode usar valores negativos");
        } else if (quantidade > getQuantidade()){
           System.out.println("Nao pode remover quantidade maior que o estoque");;
        } else {
            setQuantidade(getQuantidade() - quantidade);
        }
    }
        
        
    public boolean verificarEstoque() {
        return getQuantidade() > 0;
    }

    public boolean minimoDeEstoque() {
        return quantidade <= estoqueMinimo;
    }





    

    //Getters e Setters


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        if (precoVenda >= 0) {
            this.precoVenda = precoVenda;
        } else {
            System.out.println("Apenas valores positivos");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Apenas valores positivos");
        }
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    
}
