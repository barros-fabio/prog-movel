/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restprova2;

import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class TarefasDAO {
    ArrayList<Tarefa> tarefas = new ArrayList<>();
    public TarefasDAO(){
        Tarefa task = new Tarefa();
        task.setId(1);
        task.setNome("lista de exercícios");
        task.setDescricao(" exercícios da prova ");
        task.setStatus("ABERTA");
        tarefas.add(task);
        task = new Tarefa();
        task.setId(2);
        task.setNome("dormir");
        task.setDescricao(" tarefa diária ");
        task.setStatus("FECHADA");
        tarefas.add(task);
        task = new Tarefa();
        task.setId(3);
        task.setNome("The Walking Dead");
        task.setDescricao(" Assistir nas férias ");
        task.setStatus("ABERTA");
        tarefas.add(task);
        task = new Tarefa();
        task.setId(4);
        task.setNome("rede social");
        task.setDescricao(" Dar uma olhada no face ");
        task.setStatus("FECHADA");
        tarefas.add(task);
        task = new Tarefa();
    }
    
    public ArrayList<Tarefa> getTarefas(){
        return tarefas;
    }
    
    public Tarefa getTarefaById(int id){
        
        for(int i = 0; i<tarefas.size();i++){   
            if(tarefas.get(i).getId()==id){
                return tarefas.get(i);// existe a tarefa
            }
        }
        Tarefa t = new Tarefa();
        t.setId(0);
        return t;
    }
    
    public void salvar(Tarefa t){
        tarefas.add(t);
    }
    
    public String apagar(int id){
        for(int i = 0; i<tarefas.size();i++){   
            if(tarefas.get(i).getId()==id){
                tarefas.get(i).setStatus("FECHADA");
            }
        }

        return "Tarefa apagada!";
    }
    
}
