package dev.java10x.Cadastro.de.Ninja.Ninjas;
import dev.java10x.Cadastro.de.Ninja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String imgUrl;
    private String email;
    private MissoesModel missoes;
    private String rank;

}
