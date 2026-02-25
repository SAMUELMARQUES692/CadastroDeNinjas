package dev.java10x.Cadastro.de.Ninja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {

        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDescricaoMissao(missoesDTO.getDescricaoMissao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {

        MissoesDTO missoesDTO= new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setDescricaoMissao(missoesModel.getDescricaoMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        return missoesDTO;
    }


}
