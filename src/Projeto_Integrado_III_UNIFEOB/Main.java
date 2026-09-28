package Projeto_Integrado_III_UNIFEOB;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // =========================================================
        // FORNECEDORES
        // =========================================================

        Fornecedor fornecedor1 = new Fornecedor(
                1,
                "Wessel",
                "19988887777",
                "Rua dos Queijos, 10",
                "12345678000199"
        );

        Fornecedor fornecedor2 = new Fornecedor(
                2,
                "Laticinios Brasil",
                "19999998888",
                "Rua do Leite, 20",
                "98765432000188"
        );


        // =========================================================
        // CLIENTES
        // =========================================================

        Cliente cliente1 = new Cliente(
                1,
                "Joao",
                "19977776666",
                "Rua dos Clientes, 30",
                "12345678901"
        );

        Cliente cliente2 = new Cliente(
                2,
                "Maria",
                "19966665555",
                "Rua dos Clientes, 40",
                "98765432100"
        );


        // =========================================================
        // VENDEDORES
        // =========================================================

        Vendedor vendedor1 = new Vendedor(
                1,
                "Carlos",
                "19955554444",
                "Rua dos Vendedores, 50"
        );


        // =========================================================
        // PRODUTOS
        // =========================================================

        Produto produto1 = new Produto(
                1,
                "Queijo Parmesao",
                "Queijo tipo parmesao",
                10.0,
                700,
                30,
                10,
                "Laticinios"
        );

        Produto produto2 = new Produto(
                2,
                "Queijo Mussarela",
                "Queijo tipo mussarela",
                15.0,
                700,
                20,
                5,
                "Laticinios"
        );

        Produto produto3 = new Produto(
                3,
                "Leite Integral",
                "Leite integral 1 litro",
                4.0,
                700,
                10,
                5,
                "Laticinios"
        );


        // =========================================================
        // ESTOQUE
        // =========================================================

        Estoque estoque = new Estoque();

        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.adicionarProduto(produto3);


        // =========================================================
        // ENTRADAS DE ESTOQUE
        // =========================================================

        EntradaEstoque entrada1 = new EntradaEstoque(
                1,
                LocalDateTime.now(),
                produto1,
                20,
                fornecedor1,
                10.0
        );

        EntradaEstoque entrada2 = new EntradaEstoque(
                2,
                LocalDateTime.now(),
                produto2,
                15,
                fornecedor2,
                15.0
        );

        estoque.registrarEntrada(entrada1);
        estoque.registrarEntrada(entrada2);


        // =========================================================
        // LISTAR ESTOQUE
        // =========================================================

        estoque.listarProdutos();


        // =========================================================
        // ITENS DA VENDA
        // =========================================================

        ItemVenda item1 = new ItemVenda(
                1,
                produto1,
                3,
                produto1.getPrecoVenda()
        );

        ItemVenda item2 = new ItemVenda(
                2,
                produto2,
                2,
                produto2.getPrecoVenda()
        );


        // =========================================================
        // VENDA
        // =========================================================

        Venda venda1 = new Venda(
                1,
                LocalDateTime.now(),
                cliente1,
                vendedor1,
                "PIX"
        );

        venda1.adicionarItem(item1);
        venda1.adicionarItem(item2);


        // =========================================================
        // VALORES DA VENDA
        // =========================================================

        System.out.println();
        System.out.println("----------------------- VENDA -----------------------");

        System.out.println("Cliente: " + venda1.getCliente().getNome());
        System.out.println("Vendedor: " + venda1.getVendedor().getNome());

        System.out.println("Valor bruto: R$ " + venda1.getValorBruto());


        // =========================================================
        // DESCONTO
        // =========================================================

        venda1.calcularDescontoMaximo();

        System.out.println(
                "Desconto maximo: "
                + venda1.getDescontoMaximo()
                + "%"
        );

        // Vendedor decide conceder 3% de desconto
        venda1.aplicarDesconto(3);

        System.out.println(
                "Percentual aplicado: "
                + venda1.getPercentualDesconto()
                + "%"
        );

        System.out.println(
                "Valor do desconto: R$ "
                + venda1.getValorDesconto()
        );

        System.out.println(
                "Valor final: R$ "
                + venda1.getValorTotal()
        );


        // =========================================================
        // FINALIZAR VENDA
        // =========================================================

        venda1.finalizarVenda();


        // =========================================================
        // ESTOQUE APOS A VENDA
        // =========================================================

        System.out.println();
        System.out.println("---------------- ESTOQUE APOS VENDA ----------------");

        estoque.listarProdutos();


        // =========================================================
        // TESTE DE VENDA FECHADA
        // =========================================================

        System.out.println();
        System.out.println("---------------- TESTE VENDA FECHADA ----------------");

        venda1.adicionarItem(item1);
        venda1.removerItem(item1);
        venda1.finalizarVenda();


        // =========================================================
        // ESTOQUE BAIXO
        // =========================================================

        System.out.println();
        System.out.println("---------------- ESTOQUE BAIXO ----------------");

        System.out.println(
                estoque.verificarEstoqueBaixo()
        );
    }
}