package com.Empresa.CrudSpringBoot.controllers;

import com.Empresa.CrudSpringBoot.models.UsuarioModel;
import com.Empresa.CrudSpringBoot.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController //API REST - será un restController
//@RequestMapping("/api/v1")
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "ruta del frontend") //Nos permite poner la ruta del fornt end para hacer un intercambio de recursos
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    @RequestMapping("/usuario")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

//    http://localhost:8070/api/v1/usuario/1
//    http://localhost:8070/usuario/7

    @GetMapping( path = "usuario/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    //http://localhost:8070/usuario/prioridad?prioridad=3
//    http://localhost:8070/api/v1/usuario/prioridad?prioridad=3
    @GetMapping("usuario/prioridad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //http://localhost:8070/usuario/nombre?nombre=diego%20bolivar
    @GetMapping("usuario/nombre")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

//    http://localhost:8070/usuario/correo?correo=diego@yopmail.com
    @GetMapping("usuario/correo")
    public ArrayList<UsuarioModel> obtenerUsuarioPorCorreo(@RequestParam("correo") String correo){
        return this.usuarioService.obtenerPorCorreo(correo);
    }




    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
