/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnn.service;

import com.dnn.model.Cliente;

/**
 *
 * @author deivi
 */
public interface ClienteService {

    Iterable<Cliente> listarTodos();

    Cliente buscarPorId(Integer id);

    void salvar(Cliente cliente);

    void atualizar(Cliente cliente);

    void excluir(Integer id);
}
