package dev.java10x.Cadastro.de.Ninja.Missoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private Long id;
    private String descricaoMissao;
    private String dificuldade;

}
