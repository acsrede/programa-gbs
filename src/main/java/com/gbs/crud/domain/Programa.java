package com.gbs.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "programa")
@AllArgsConstructor
@NoArgsConstructor
public class Programa {

    @Id
    private String id;
    private String nome;
    private LocalDateTime data_cadastro;
    private Integer ativo;
    private LocalDateTime data_exclusao;

}
