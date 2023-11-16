package contatoscli.src;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContatoController {

    public static List<Contato> contatos;

    public ContatoController() {
        this.contatos = new ArrayList<>();
    }

    public void criarContato() {
        var contato = lerDadosContato();
        Random random = new Random();
        contato.setId(random.nextInt(100000));
        contatos.add(contato);
        System.out.println("Contato salvo");
    }

    public void recuperarContato() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Contato: " + i + contatos.get(i));
        }
    }

    public void updateContato() {
        if (contatos.size() <= 0) {
            System.out.println("Não há contatos para atualizar");
            return;
        }
        System.out.println("Qual contato você quer atualizar (Digite o ID)?");
        recuperarContato();
        var scanner = new Scanner(System.in);
        var id = scanner.nextInt();

        var novoContato = lerDadosContato();
        var velhoContato = encontrarContatoPorId(id);
        velhoContato.setNome(novoContato.getNome());
        velhoContato.setTelefone(novoContato.getTelefone());

        System.out.println("Contato salvo");
    }

    public void deletarContato() {
        if (contatos.size() <= 0) {
            System.out.println("Não há contatos para deletar");
            return;
        }
        System.out.println("Qual contato você quer deletar (Digite o número)?");
        recuperarContato();
        var scanner = new Scanner(System.in);
        var id = scanner.nextInt();
        var contato = encontrarContatoPorId(id);
        contatos.remove(contato);
        System.out.println("Contato deletado");

    }

    private Contato encontrarContatoPorId(int id) {
        for (var contato : contatos) {
            if (contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }

    private Contato lerDadosContato() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome:");
        var nome = scanner.nextLine();
        System.out.println("Digite o telefone:");
        var telefone = scanner.nextLine();
        var contato = new Contato(nome, telefone);
        return contato;
    }

}
