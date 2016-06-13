/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2parte1;

import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class FuncionarioDAO {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    
    public FuncionarioDAO(){
        Funcionario func = new Funcionario();
        func.setId(1);
        func.setNome("Barack Obama");
        func.setSalario(5690.67);
        func.setIdade(45);
        func.setCargo("presidente dos EUA");
        funcionarios.add(func);
        func = new Funcionario();
        func.setId(22);
        func.setNome("Angela Merkel");
        func.setSalario(17690.67);
        func.setIdade(57);
        func.setCargo("presidente da Alemanha");
        funcionarios.add(func);
        func = new Funcionario();
        func.setId(31);
        func.setNome("Margareth Thatcher");
        func.setSalario(6000.67);
        func.setIdade(87);
        func.setCargo("primeira-ministra");
        funcionarios.add(func);
        func = new Funcionario();
        func.setId(44);
        func.setNome("Francis Underwood");
        func.setSalario(70600.98);
        func.setIdade(45);
        func.setCargo("congressista");
        funcionarios.add(func);     
    }
    
    
    //Usado no GET geral
    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
    
    ///Usado no GET by ID
    public Funcionario getFuncionarioById(int id){
        
        for(int i = 0; i<funcionarios.size();i++)   
            if(funcionarios.get(i).getId()==id)
                return funcionarios.get(i);// existe o funcionário
          
        Funcionario f = new Funcionario();
        f.setId(0);
        return f;
    }
    
    
    ///usado no POST
    public void salvar(Funcionario f){
        funcionarios.add(f);
    }
    
    //Usado no DELETE
    public String apagar(int id){
        for(int i = 0; i<funcionarios.size();i++) 
            if(funcionarios.get(i).getId()==id)
                funcionarios.remove(i);
       
        return "Funcionário apagado!";
    }
    
    //Usado no PUT
    public int atualizar(int id, String novoCargo){
        int funcAtualizado =0;
        for(int i = 0; i<funcionarios.size();i++) 
            if(funcionarios.get(i).getId()==id){
                funcAtualizado = i;
                funcionarios.get(i).setCargo(novoCargo);
            }
                
        return funcAtualizado;
    }
    
    
}
