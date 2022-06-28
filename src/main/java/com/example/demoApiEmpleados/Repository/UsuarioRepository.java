package com.example.demoApiEmpleados.Repository;

import com.example.demoApiEmpleados.Models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> { //extendemos de crudrepositorio que tendra todos los metodos, indicar que tipo de dato es UsuaroMODEL y que tipo id es LOng
    //es una interfaz porque implementa ciertos metodos

    //por ahora use una extension propia de un crud pero aqui va toda la logica que conecta con la base como el controller en laravel
    //aqui agrege un nuevo metodo a esta extension
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad); //con esto buscara todos los q tienen una prioridad filtros
}
