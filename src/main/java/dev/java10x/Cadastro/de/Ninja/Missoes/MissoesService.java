package dev.java10x.Cadastro.de.Ninja.Missoes;

import dev.java10x.Cadastro.de.Ninja.Ninjas.NinjaModel;

import java.util.List;

public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissao(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missoesAtualizada) {
        if (missoesRepository.existsById(id)) {
            missoesAtualizada.setId(id);
            return missoesRepository.save(missoesAtualizada);
        }
        return null;
    }

    public void deletarMissao(Long id) {
         missoesRepository.deleteById(id);
    }
}
