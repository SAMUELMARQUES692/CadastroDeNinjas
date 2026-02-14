package dev.java10x.Cadastro.de.Ninja.Missoes;

import dev.java10x.Cadastro.de.Ninja.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoMissao;
    private String rankMissao;

    // @OneToMany - Uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String descricaoMissao, String rankMissao) {
        this.id = id;
        this.descricaoMissao = descricaoMissao;
        this.rankMissao = rankMissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoMissao() {
        return descricaoMissao;
    }

    public void setDescricaoMissao(String descricaoMissao) {
        this.descricaoMissao = descricaoMissao;
    }

    public String getRankMissao() {
        return rankMissao;
    }

    public void setRankMissao(String rankMissao) {
        this.rankMissao = rankMissao;
    }
}
