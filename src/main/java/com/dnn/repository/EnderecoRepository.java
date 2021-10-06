/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnn.repository;

import com.dnn.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author deivi
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String>{
    
}
