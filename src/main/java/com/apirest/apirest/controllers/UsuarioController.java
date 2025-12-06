package com.apirest.apirest.controllers;

import com.apirest.apirest.entities.Usuario;
import com.apirest.apirest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario mostrarUsuarioId(@PathVariable Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro al usuario con id:" + id));
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario bodyUsuario, @PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro al usuario con id:" + id));

        usuario.setNombre(bodyUsuario.getNombre());
        usuario.setCorreo(bodyUsuario.getCorreo());
        usuario.setNumero(bodyUsuario.getNumero());

        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro al usuario con id:" + id));

        usuarioRepository.delete(usuario);
        return "Usuario eliminado correctamente";
    }

}
