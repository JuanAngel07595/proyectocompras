package com.logicfuse.logicfuse.service;

import com.logicfuse.logicfuse.controllers.dto.UsuarioRegistroDTO;
import com.logicfuse.logicfuse.models.Usuario;

public interface UsuarioServicio {
    public Usuario guardar(UsuarioRegistroDTO usuarioRegistroDTO);
}
