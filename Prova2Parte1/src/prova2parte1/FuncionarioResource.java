/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2parte1;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fabio
 */
@Path("funcionario")
public class FuncionarioResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Funcionario> get(){
        FuncionarioDAO dao = new FuncionarioDAO();
        System.out.println("Retornando todos os funcionários");
        return dao.getFuncionarios();
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario getFuncionarioById(@PathParam("id")int id){
        FuncionarioDAO dao = new FuncionarioDAO();
        
        System.out.println("Funcionário de id = "+id+" sendo retornado ");
        return dao.getFuncionarioById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario addFuncionario(Funcionario func){
        FuncionarioDAO dao = new FuncionarioDAO();
        
        dao.salvar(func);
        System.out.println("Funcionario adicionado!!!");
        return func;
    }   
    
    @Path("{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String apagar(@PathParam("id")int id){
        FuncionarioDAO dao = new FuncionarioDAO();
        System.out.println("Funcionário removido: "+id);
        return dao.apagar(id);
    }
    
    @Path("{id}/{novo_cargo}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario atualizarFuncionario(@PathParam("id")int id, @PathParam("novo_cargo") String novoCargo){
        FuncionarioDAO dao = new FuncionarioDAO();    
        int funcAtualizado = dao.atualizar(id, novoCargo);
        System.out.println("Funcionario atualizado!!!");
        return dao.getFuncionarioById(id);
    }
}