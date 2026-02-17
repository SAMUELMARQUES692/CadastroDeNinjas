package dev.java10x.Cadastro.de.Ninja.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MissoesController {

    // Adicionar Missao
    @PostMapping("/criarMissao")
    public String adicionarMissao() {
        return "Missão foi adicionada";
    }

    // Mostrar todas as missoes
    @GetMapping("/mostrarmissao")
    public String mostrarTodasAsMissoes() {
        return "Mostrar todas as missoes";
    }

    // Mostrar missao por ID
    @GetMapping("/mostrarmissaoID")
    public String mostrarMissaoPorId() {
        return "Mostrar missão por ID";
    }

    // Alterar dados da missao por ID
    @PutMapping("/alterarmissaoID")
    public String alterarMissaoPorId() {
        return "Alterar missao por ID";
    }

    // Deletar missao por ID
    @DeleteMapping("/deletarmissaoID")
    public String deletarMissaoPorId() {
        return "Missão deletada por ID";
    }

}
