package com.example.fabio.exercicio05lista;

import java.util.ArrayList;

/**
 * Created by fabio on 4/3/16.
 */
public class Cidade {
    public ArrayList<String> getCidadeByEstado(String estado){
        ArrayList<String> ret = new ArrayList<>();

        if(estado.startsWith("Paran")){
            ret.add("Londrina");
            ret.add("Curitiba");
            ret.add("Cornélio Procópio");
        } else if(estado.startsWith("São Paul")){
            ret.add("São Paulo");
            ret.add("Campinas");
            ret.add("Assis");
        } else if(estado.startsWith("Santa Ca")) {
            ret.add("Florianópolis");
            ret.add("Joinville");
            ret.add("Concórdia");
        }
        return ret;
    }
}
