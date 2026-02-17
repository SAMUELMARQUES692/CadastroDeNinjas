package dev.java10x.Cadastro.de.Ninja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository  ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os ninjas por ID
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar um ninja - Tem que ser void
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Alterar um ninja
    public NinjaModel alterarNinjaPorId(Long id) {
        Optional<NinjaModel> alterarPorId = ninjaRepository.findById(id);
        return alterarPorId.orElse(null);
    }

}
