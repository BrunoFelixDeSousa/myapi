package com.bruno.myapi.services;

import com.bruno.myapi.domain.Usuario;
import com.bruno.myapi.repositories.UsuarioRepsoitory;
import com.bruno.myapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Usuario> findAll() {
        return repsoitory.findAll();
    }


    public Usuario update(Integer id, Usuario obj) {
            Usuario newObj = findById(id);
            newObj.setNome(obj.getNome());
            newObj.setLogin(obj.getLogin());
            newObj.setSenha(obj.getSenha());
            return repsoitory.save(newObj);
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return repsoitory.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repsoitory.deleteById(id);
    }
}
