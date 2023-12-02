package com.logicfuse.logicfuse.repositories;

import com.logicfuse.logicfuse.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);

}
