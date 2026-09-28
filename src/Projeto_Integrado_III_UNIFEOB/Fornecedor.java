package Projeto_Integrado_III_UNIFEOB;

public class Fornecedor extends Pessoa{
    
    
        // Atributos
        private String cnpj;
        
        
    public Fornecedor(int id, String nome, String telefone, String endereco, String cnpj) {
        super(id, nome, telefone, endereco);
        this.cnpj = cnpj;
    }
    
    // metodos

    
    @Override
    public String toString() {
        return "Fornecedor{" +
            super.toString() + 
            ", cnpj='" + cnpj + "'}";
    }

}
