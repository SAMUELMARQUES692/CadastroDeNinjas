package dev.java10x.Cadastro.de.Ninja.Ninjas;

import dev.java10x.Cadastro.de.Ninja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity transforma uma classe em uma entidade do Banco de Dados
// JPA - Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @Column(unique = true)
    private String email;

    // @ManyToOne - Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreina Key ou chave estrangeira
    private MissoesModel missoes;
}
