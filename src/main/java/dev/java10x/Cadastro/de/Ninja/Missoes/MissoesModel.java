package dev.java10x.Cadastro.de.Ninja.Missoes;

import dev.java10x.Cadastro.de.Ninja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoMissao;
    private String rankMissao;

    // @OneToMany - Uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
