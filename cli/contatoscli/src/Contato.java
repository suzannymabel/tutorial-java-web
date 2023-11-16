package contatoscli.src;

public class Contato {
    private int id;
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "\n-------------------------------------\n" +
                "ID: " + this.id + "\tNome: " + this.nome + "\tTelefone: " + this.telefone +
                "\n-------------------------------------";
    }

    @Override
    public boolean equals(Object obj) {
        return ((Contato) obj).getId() == this.id;
    }
}
