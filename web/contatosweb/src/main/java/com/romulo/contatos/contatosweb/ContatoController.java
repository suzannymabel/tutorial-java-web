package com.romulo.contatos.contatosweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ContatoController {

    public static List<Contato> contatos = new ArrayList<>();

    @GetMapping("/contatos")
    public String contatos(Model model) {
        model.addAttribute("contatos", contatos);
        return "template_contatos";
    }

    @PostMapping("/criar_contato")
    public String criar_contato(@ModelAttribute Contato contato) {
        Random random = new Random();
        contato.setId(random.nextInt(100000));
        contatos.add(contato);
        return "redirect:contatos";
    }

    @GetMapping("/deletar_contato")
    public String deletar_contato(@RequestParam int id) {
        var contato = encontrarContatoPorId(id);
        if (contato != null) {
            int pos = contatos.indexOf(contato);
            contatos.remove(pos);

        }
        return "redirect:contatos";
    }

    @GetMapping("/update_contato")
    public String show_update_contato(@RequestParam int id, Model model) {
        var contato = encontrarContatoPorId(id);
        if (contato == null) {
            return "redirect:contatos";
        }
        model.addAttribute("contato", contato);
        return "template_update_contatos";
    }

    // Atualiza funcionario
    @PostMapping("update_contato")
    public String update_contato(@RequestParam int id, Contato contato) {

        return "redirect:/contatos";
    }

    private Contato encontrarContatoPorId(int id) {
        for (var contato : contatos) {
            if (contato.getId() == id) {
                System.out.println("Contato encontrado.");
                System.out.println(contato);
                return contato;
            }
        }
        return null;
    }
}