package com.example.todo;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.TodoService;

@RestController
public class TodoController{
    TodoService todoService=new TodoService();
    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodos();
    }
    @GetMapping("/todos/{todoId}")
    public Todo getTodobyid(@PathVariable("todoId") int id) {
        return todoService.getTodobyid(id);
    }
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
    
    
    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }
    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int id){
        todoService.deleteTodo(id);
    }
}
