package Projeto_Integrado_III_UNIFEOB;

public class ItemVenda {

    //Atributos
    private int id;
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
    private double subtotal;
    
    
    //Construtor
    public ItemVenda(int id, Produto produto, int quantidade, double precoUnitario) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        calcularSubtotal();
    }


    //Metodos

    @Override
    public String toString() {
        return "Produto: " + getProduto().getNome() + " | Quantidade: " + getQuantidade()+ " | Preço Und. " + getPrecoUnitario() + " | SubTotal: " + getSubtotal();
    }

    public void calcularSubtotal() {
        setSubtotal(getPrecoUnitario()*getQuantidade());
    }


    //Getter e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    


}