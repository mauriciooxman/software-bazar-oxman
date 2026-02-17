package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.model.Cliente;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Path;
import java.util.List;

public interface IClienteService {

    public List<Cliente> listaClientes(); //traer lista de clientes
    public void saveCliente(Cliente cliente);
    public Cliente findClienteById(Long id_cliente); //traer cliente por id
    public void deleteCliente(Long id_cliente);
    public Cliente editCliente(Cliente cliente);

}
