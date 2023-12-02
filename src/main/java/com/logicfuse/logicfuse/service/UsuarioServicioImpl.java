package com.logicfuse.logicfuse.service;

import java.util.Arrays;


import com.logicfuse.logicfuse.controllers.dto.UsuarioRegistroDTO;
import com.logicfuse.logicfuse.models.Rol;
import com.logicfuse.logicfuse.models.Usuario;
import com.logicfuse.logicfuse.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepository usuarioRepository;

    public UsuarioServicioImpl(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepository.save(usuario);
    }
}















