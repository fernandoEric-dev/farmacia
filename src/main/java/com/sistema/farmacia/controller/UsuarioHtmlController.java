package com.sistema.farmacia.controller;

import com.sistema.farmacia.model.Usuario;
import com.sistema.farmacia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios-html")
public class UsuarioHtmlController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/salvar")
    public String salvarUsuario(
            @RequestParam String nomeUsuario,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String rua,
            @RequestParam String bairro,
            @RequestParam String cidade,
            @RequestParam String cep,
            @RequestParam String estado
    ) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        
        // --- NOVOS CAMPOS ---
        usuario.setCpf(cpf);
        usuario.setRua(rua);
        usuario.setBairro(bairro);
        usuario.setCidade(cidade);
        usuario.setCep(cep);
        usuario.setEstado(estado);

        repository.save(usuario);

        return "redirect:/cadastro.html";
    }
}