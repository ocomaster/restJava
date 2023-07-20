package com.brayan.app.rest.Controller;

import com.brayan.app.rest.Model.Task;
import com.brayan.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// 1 Primer paso crear el controlador
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    //Creacion de metodos
    @GetMapping(value = "/")
    public String holaMundo(){
        return "Hola mundo";
    }


    //Ver Tareas
    @GetMapping(value = "/tasks")
    public List <Task> getTasks(){
        return todoRepository.findAll();
    }

    //Ver tarea por id
     @GetMapping(value = "/task/{id}")

     public Optional<Task> oneTask(@PathVariable Long id){
         return todoRepository.findById(id);
         
     }


    //Crear tarea
    @PostMapping(value = "/savetask")
    public  String SaveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "Tarea guardada";
    }

    //Actualizar tarea
    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody Task task){
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());

        todoRepository.save(updatedTask);
        return "Tarea actualizada";

    }

    //Eliminar una tarea
    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return  "Tarea eliminada";
    }


}
