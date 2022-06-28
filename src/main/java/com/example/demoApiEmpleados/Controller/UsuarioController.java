package com.example.demoApiEmpleados.Controller;

import com.example.demoApiEmpleados.Models.UsuarioModel;
import com.example.demoApiEmpleados.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario") //esto es para la ruta inical que tendra tpara entrar a este controlador
public class UsuarioController {
    //instancio el servicio para poder comunicarme
    @Autowired
    UsuarioService usuarioService;

    @GetMapping //UTULIZO POR LA PETICION DE TIPO GET que es cuando se lista y obtento los usuario llamando a el servicio donde los tengo
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping  //MEODO PARA CREAR UN USUARIO LA RUTA ES TIPO POST lo que hara el por la ruta tener el usuarioa agregar
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    //obtengo un usuario por id
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioId(@PathVariable("id") Long id){
        return usuarioService.buscarPorId(id);
    }

    //obtener el usuario por prioridad lo que hare es paras por query params
    //que seria tipo asi localhost:8080/usuario/query?prioridad=5
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuariosPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.buscarPorPrioridad(prioridad);
    }

    //eliminar el usuario por un path que seria localhost:8080/usuario/1  ==>> {id}
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean eliminado = usuarioService.eliminarUsuario(id);
        if (eliminado){
            return "Se elimino el usuario con el id :" + id;
        }else{
            return "Ocurrio un erro al eliminarse el usuario con el id :"+id;
        }
    }
}
