package com.locadora.reposity;


import org.springframework.data.repository.CrudRepository;

import com.locadora.model.Cliente;

public interface CrudCliente extends CrudRepository<Cliente,Long>{

}
