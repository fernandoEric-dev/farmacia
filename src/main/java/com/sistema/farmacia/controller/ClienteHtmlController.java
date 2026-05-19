package com.crud.cliente.controller;

import com.crud.cliente.entity.ClienteEntity;
import com.crud.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes-html")
public class ClienteHtmlController {

    @Autowired
    private ClienteService service;

    // CREATE
    @PostMapping("/salvar")
    public String salvarCliente(
            @RequestParam String nome,
            @RequestParam String sobrenome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String endereco,
            @RequestParam String cidade,
            @RequestParam String estado,
            @RequestParam String cep
    ) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setCep(cep);

        service.salvar(cliente);

        return "redirect:/clientes.html";
    }

    // READ
    @GetMapping("/buscar")
    @ResponseBody
    public ClienteEntity buscarCliente(@RequestParam Long id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    @PostMapping("/atualizar")
    public String atualizarCliente(
            @RequestParam Long id,
            @RequestParam String nome,
            @RequestParam String sobrenome,
            @RequestParam String email,
            @RequestParam String telefone,
            @RequestParam String cpf,
            @RequestParam String endereco,
            @RequestParam String cidade,
            @RequestParam String estado,
            @RequestParam String cep
    ) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setCidade(cidade);
        cliente.setEstado(estado);
        cliente.setCep(cep);

        service.atualizar(id, cliente);

        return "redirect:/clientes-crud.html";
    }

    // DELETE
    @PostMapping("/excluir")
    public String excluirCliente(@RequestParam Long id) {
        service.deletar(id);

        return "redirect:/clientes-crud.html";
    }
}