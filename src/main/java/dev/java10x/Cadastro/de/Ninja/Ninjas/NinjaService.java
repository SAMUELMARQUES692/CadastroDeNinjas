package dev.java10x.Cadastro.de.Ninja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return ninja.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar todos os ninjas por ID
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar um ninja - Tem que ser void
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar um ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public NinjaDTO salvarOuAtualizar(NinjaDTO dto) {

        NinjaModel ninja;

        // Se tiver ID → UPDATE
        if (dto.getId() != null) {
            ninja = ninjaRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));
        } else {
            // Se não tiver ID → CREATE
            ninja = new NinjaModel();
        }

        ninja.setNome(dto.getNome());
        ninja.setEmail(dto.getEmail());
        ninja.setImgUrl(dto.getImgUrl());
        ninja.setIdade(dto.getIdade());
        ninja.setRank(dto.getRank());

        ninja = ninjaRepository.save(ninja);

        return ninjaMapper.map(ninja);
    }

}
