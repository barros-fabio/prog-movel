/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova2parte1;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

/**
 *
 * @author fabio
 */
public class RESTServidor {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServerFactory.create("http://localhost:4000/");
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
