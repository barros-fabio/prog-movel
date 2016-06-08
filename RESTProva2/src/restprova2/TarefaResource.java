/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restprova2;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fabio
 */
@Path("task")
public class TarefaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Tarefa> get(){
        TarefasDAO dao = new TarefasDAO();
        System.out.println("Retornando todas as tarefas");
        return dao.getTarefas();
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tarefa getTarefaById(@PathParam("id")int id){
        TarefasDAO dao = new TarefasDAO();
        
        System.out.println("Tarefa de id = "+id+"  ");
        return dao.getTarefaById(id);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Tarefa addTarefa(Tarefa task){
        TarefasDAO dao = new TarefasDAO();
        
        dao.salvar(task);
        return task;
    }
    
    @Path("{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String apagar(@PathParam("id")int id){
        TarefasDAO dao = new TarefasDAO();
        System.out.println("Tarefa removida: "+id);
        return dao.apagar(id);
    }
   
}
