package Projeto_Integrado_III_UNIFEOB;

public class Cliente extends Pessoa{

    //Atributo
    private String cpf;

    public Cliente(int id, String nome, String telefone, String endereco, String cpf) {
        super(id, nome, telefone, endereco);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            super.toString() + 
            ", cpf='" + cpf + "'}";
    }
}
