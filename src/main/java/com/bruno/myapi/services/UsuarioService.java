package com.bruno.myapi.services;

import com.bruno.myapi.domain.Usuario;
import com.bruno.myapi.repositories.UsuarioRepsoitory;
import com.bruno.myapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepsoitory repsoitory;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repsoitory.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

}
