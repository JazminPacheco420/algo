/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author andrea jazmin pacheco
 */
public class ProyectoFinal {

    public static void main(String[] args) {
        GrafoDirigidoAciclico grafo = new GrafoDirigidoAciclico(3);

        grafo.insertarArista(0, 2);  
        grafo.insertarArista(2, 1);  



        System.out.println("list");
        System.out.println(grafo.mostrarEstructura());
        
        System.out.println("matriz");// pra mostrar mamtriz
        System.out.println(grafo.matrizDeAdyacencia());

        System.out.println("ordenados");
        System.out.println(grafo.topologicalSort());

        System.out.println("ciclo?");
        System.out.println(grafo.tieneCiclos() ? "Si" : "No");

        Graph graph = grafo.crearGrafoGraphStream();
        graph.display();
        
        System.out.println("Grado de entrada de 2: " + grafo.gradoDeEntrada(2));
        System.out.println("Grado de salida de 1: " + grafo.gradoDeSalida(1));
        System.out.println("Hay " + grafo.cuantasAristasHay() + " aristas");
        System.out.println("4 y 0 son adyacentes: " + grafo.adyacente(1, 0));
        System.out.println("Existe un camino directo entre 0 y 4: " + grafo.conectados(2, 1));
        
        String ruta = "grafo.txt";
        grafo.guardarGrafo(ruta);

        grafo.eliminarAristas();
        System.out.println("Se eliminaron las aristas, ahora hay " + grafo.cuantasAristasHay() + " aristas");

        System.out.println("Cantidad de grafos que hay  " + grafo.contarGrafos(ruta));
        
        System.out.println(grafo.cargarGrafoPorIndice(ruta, 2));
    }
}
