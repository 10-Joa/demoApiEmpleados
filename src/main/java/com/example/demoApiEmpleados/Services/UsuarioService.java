package com.example.demoApiEmpleados.Services;

import com.example.demoApiEmpleados.Models.UsuarioModel;
import com.example.demoApiEmpleados.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    //ahora creamos una instancia d ela clase usuarioRepositorio le colocamos el autowird para no indicar el tipo de dato porque ya se sabe de donde viene
    @Autowired
    UsuarioRepository usuarioRepository;

    //crear metodo listar
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        //con esto hago q con el metodo findall encuentre todos y los retorne, pero lo casteamos para q retorne de tipo usuario model, que sera un arreglo
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //guardarUsuario
    public  UsuarioModel guardarUsuario(UsuarioModel usuario){
        //este guardar recibe a el usuario y devuelve el usuario guardado ya con su respectivo id autogenerado
        return usuarioRepository.save(usuario);
    }

    //buscar por id
    public Optional<UsuarioModel>  buscarPorId(Long id){ //se le pone de tipo opcional porque si encuentra no arroja problemas y si no encuentro tampoco hace nada
        return usuarioRepository.findById(id);
    }

    //buscar por prioridad el metodo abstraco que implemente antes en el repositorio
    public ArrayList<UsuarioModel> buscarPorPrioridad(Integer prioridad){
        return  usuarioRepository.findByPrioridad(prioridad);
    }

    //eliminar el usuario
    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
