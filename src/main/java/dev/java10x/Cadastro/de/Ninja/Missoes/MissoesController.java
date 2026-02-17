package dev.java10x.Cadastro.de.Ninja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    // Adicionar Missao
    @PostMapping("/criar")
    public String adicionarMissao() {
        return "Missão foi adicionada";
    }

    // Mostrar todas as missoes
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes listadas com sucesso";
    }

    // Alterar dados da missao por ID
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    // Deletar missao por ID
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }

}
