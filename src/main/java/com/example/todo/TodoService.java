package com.example.todo;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int uniqueId=6;
    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    @Override
    public ArrayList<Todo> getTodos(){
        Collection<Todo> todos1=todoList.values();
        ArrayList<Todo> todos=new ArrayList<>(todos1);
        return todos;

    }

    @Override
    public Todo getTodobyid(int id){
        Todo todo=todoList.get(id);
        if(todo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todo;
    }

    @Override
    public Todo addTodo(Todo todo){
        todo.setId(uniqueId);
        todoList.put(uniqueId,todo);
        uniqueId=uniqueId+1;
        return todo;
    }

    @Override
    public Todo updateTodo(int id,Todo todo){
        Todo existingtodo=todoList.get(id);
        if(existingtodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (todo.getTodo() != null) {
            existingtodo.setTodo(todo.getTodo());
        }
        
        if (todo.getPriority() != null) {
            existingtodo.setPriority(todo.getPriority());
        }
        if (todo.getStatus() != null) {
            existingtodo.setStatus(todo.getStatus());
        }
        return existingtodo;

    }

    @Override
    public void deleteTodo(int id){
        Todo todo=todoList.get(id);

        if(todo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
           
    }
}

