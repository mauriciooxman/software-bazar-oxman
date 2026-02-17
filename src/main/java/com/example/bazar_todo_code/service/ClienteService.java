package com.example.bazar_todo_code.service;

import com.example.bazar_todo_code.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.bazar_todo_code.repository.IClienteRepository;


import java.util.List;

@Service
public class ClienteService implements IClienteService{

    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listaClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
    clienteRepository.save(cliente);
    }

    @Override
    public Cliente findClienteById(Long id_cliente) {
        Cliente cliente = clienteRepository.findById(id_cliente).orElse(null);
        return cliente;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
    clienteRepository.deleteById(id_cliente);
    }

    @Override
    public Cliente editCliente(Cliente cliente) {
        Cliente ClienteExistente = findClienteById(cliente.getId_cliente());
        if(ClienteExistente == null) {
            return null;
        }
        ClienteExistente.setNombre(cliente.getNombre());
        ClienteExistente.setApellido(cliente.getApellido());
        ClienteExistente.setRut(cliente.getRut());
        return clienteRepository.save(ClienteExistente);
    }
}
