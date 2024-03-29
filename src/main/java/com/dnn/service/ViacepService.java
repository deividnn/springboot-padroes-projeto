/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnn.service;

import com.dnn.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author deivi
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViacepService {

    @GetMapping("/{cep}/json")
    Endereco consultarCep(@PathVariable String cep);
}
