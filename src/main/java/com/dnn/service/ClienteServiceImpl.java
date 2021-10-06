/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnn.service;

import com.dnn.model.Cliente;
import com.dnn.model.Endereco;
import com.dnn.repository.ClienteRepository;
import com.dnn.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deivi
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViacepService viacepService;

    @Override
    public Iterable<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void salvar(Cliente cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Cliente cli) {
        Cliente cliente = clienteRepository.findById(cli.getId()).orElse(null);
        if (cliente != null) {
            salvarCliente(cliente);
        }
    }

    private void salvarCliente(Cliente cliente) {
        Endereco endereco = enderecoRepository.findById(cliente.getEndereco().getCep()).orElseGet(() -> {
            Endereco novoEndeeco = viacepService.consultarCep(cliente.getEndereco().getCep());
            enderecoRepository.save(novoEndeeco);
            return novoEndeeco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }

}
