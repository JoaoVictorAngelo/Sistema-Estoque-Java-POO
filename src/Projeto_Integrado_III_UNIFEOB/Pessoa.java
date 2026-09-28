package Projeto_Integrado_III_UNIFEOB;

public class Pessoa {

    //Atributos
    private int id;
    private String nome;
    private String telefone;
    private String endereco;

    //Construtor
    public Pessoa(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        setTelefone(telefone);
        this.endereco = endereco;
    }

    //Metodos


    public void atualizarDados(String novoTelefone, String novoEndereco) {
        setTelefone(novoTelefone);
        setEndereco(novoEndereco);
    }


    @Override
    public String toString() {
        return "ID=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'';
    }



    //Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {

        if (telefone.length() != 11 || !telefone.matches("\\d+")) {
            System.out.println("Digite apenas DDD + Numero ex: 19987654321");
        } else {
            this.telefone = telefone;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    
    
}
