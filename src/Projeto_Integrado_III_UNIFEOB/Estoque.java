package Projeto_Integrado_III_UNIFEOB;

import java.util.ArrayList;

public class Estoque {

    // Atributos
    private ArrayList<Produto> produtos;
    private ArrayList<EntradaEstoque> entradas;


    // Construtor
    public Estoque() {
        produtos = new ArrayList<>();
        entradas = new ArrayList<>();
    }


    // Métodos - Produtos

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int produtoID) {

        Produto produto = buscarProduto(produtoID);

        if (produto == null) {
            System.out.println("Não foi possivel remover o Produto, Produto nao encontrado!");

        } else {
            produtos.remove(produto);
        }
    }

    public Produto buscarProduto(int produtoID) {

        for (int i = 0; i < produtos.size(); i++) {

            if (produtoID == produtos.get(i).getId()) {
                return produtos.get(i);
            }
        }

        return null;
    }

    public void listarProdutos() {

        System.out.println("------------------------------- ESTOQUE -------------------------------");

        for (int i = 0; i < produtos.size(); i++) {

            System.out.println(
                "Nome: " + produtos.get(i).getNome() +
                "        ID: " + produtos.get(i).getId()
            );

            System.out.println(
                "Quantidade em estoque: " +
                produtos.get(i).getQuantidade()
            );

            System.out.println(
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
            );
        }
    }


    // Métodos - Entradas

    public void registrarEntrada(EntradaEstoque entrada) {
        entradas.add(entrada);
        entrada.registrarEntrada();
    }

    public void listarEntradas() {

        System.out.println("------------------------------- ENTRADAS -------------------------------");

        for (int i = 0; i < entradas.size(); i++) {

            entradas.get(i).exibirEntrada();

            System.out.println(
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
            );
        }
    }


    // Métodos - Controle de estoque

    public ArrayList<String> verificarEstoqueBaixo() {

        ArrayList<String> estoqueBaixo = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).minimoDeEstoque()) {
                estoqueBaixo.add(produtos.get(i).getNome());
            }
        }

        return estoqueBaixo;
    }
}