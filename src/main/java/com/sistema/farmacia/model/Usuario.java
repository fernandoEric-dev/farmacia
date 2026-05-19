package com.sistema.farmacia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nomeUsuario;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 20)
    private String telefone;

    // --- NOVOS CAMPOS ADICIONADOS ---
    @Column(length = 14)
    private String cpf;

    @Column(length = 150)
    private String rua;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column(length = 9)
    private String cep;

    @Column(length = 50)
    private String estado;
}