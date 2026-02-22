package dev.java10x.Cadastro.de.Ninja.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")

public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // Adicionar Missao
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes) {
        return missoesService.criarMissao(missoes);
    }

    // Mostrar todas as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    // Alterar dados da missao por ID
    @PutMapping("/atualizar/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizada) {
        return missoesService.atualizarMissao(id, missoesAtualizada);
    }

    // Deletar missao por ID
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }

}
