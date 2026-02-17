package com.example.bazar_todo_code.controller;


import com.example.bazar_todo_code.model.Cliente;
import com.example.bazar_todo_code.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clientes")
public class ClienteController {
    public final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public List<Cliente> listaClientes(){
        return clienteService.listaClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id_cliente){
        return clienteService.findClienteById(id_cliente);
    }

    @PostMapping("/crear")
    public void saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
    }

    @PutMapping("/editar")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        return clienteService.editCliente(cliente);

    }

}
