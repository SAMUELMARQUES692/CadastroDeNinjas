package dev.java10x.Cadastro.de.Ninja.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.deser.BasicDeserializerFactory;

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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
       MissoesDTO novaMissao = missoesService.criarMissao(missoes);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body("Missão criada com sucesso " + novaMissao.getDescricaoMissao() + " (ID): " + novaMissao.getId());
    }

    // Mostrar todas as missoes
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    // Alterar dados da missao por ID
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizada) {
        MissoesDTO missoes = missoesService.atualizarMissao(id, missoesAtualizada);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID" + id + "não foi encontrado");
        }
    }

    // Mostrar missoes por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);
        if (missoes != null) {
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o ID " + id + " não existe nos nossos registros");
        }
    }


    // Deletar missao por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID " + id + " foi deletado");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado");
        }
    }

}
