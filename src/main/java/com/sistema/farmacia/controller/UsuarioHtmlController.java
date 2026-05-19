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
            @RequestParam String telefone
    ) {
        // Cria um novo usuário
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);

        // Guarda no banco de dados (XAMPP)
        repository.save(usuario);

        // Volta para a página do formulário após guardar
        return "redirect:/cadastro.html";
    }
}