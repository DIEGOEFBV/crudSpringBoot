package com.Empresa.CrudSpringBoot.services;

import com.Empresa.CrudSpringBoot.models.UsuarioModel;
import com.Empresa.CrudSpringBoot.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel>  obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public ArrayList<UsuarioModel>  obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }


    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
