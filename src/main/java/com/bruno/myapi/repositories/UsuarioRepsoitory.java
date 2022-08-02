package com.bruno.myapi.repositories;

import com.bruno.myapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepsoitory extends JpaRepository<Usuario, Integer> {
}
