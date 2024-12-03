package com.mycompany.proyectofinal;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GrafoDirigidoAciclico {
    private Map<Integer, List<Integer>> listaAdyacencia; 
    private Map<Integer, Integer> gradoEntrada; 
    private int numVertices; 
    private Graph graphStreamGraph; 

    public GrafoDirigidoAciclico(int n) 
    {
         this.numVertices = n;
       this.listaAdyacencia = new HashMap<>();
        this.gradoEntrada = new HashMap<>();
        this.graphStreamGraph = new SingleGraph("Grafo Dirigido");

        for (int i = 0; i < n; i++)
        {
            listaAdyacencia.put(i, new ArrayList<>());
            gradoEntrada.put(i, 0);
            graphStreamGraph.addNode(String.valueOf(i)); 
        }
    }

    public GrafoDirigidoAciclico() 
    {
        this(4);
        generarAristasAleatorias();
    }

    public GrafoDirigidoAciclico(int n, boolean aleatorio)
    {
        this(n);
        if (aleatorio) 
        {
            generarAristasAleatorias();
        }
    }

    private void generarAristasAleatorias()
    {
        Random rand = new Random();
        for (int i = 0; i < numVertices; i++) 
        {
        for (int j = 0; j < numVertices; j++) 
         {
            if (i != j && rand.nextBoolean()) 
            {
                insertarArista(i, j);
            }
          }
        }
    }


    public int gradoDeEntrada(int i) 
    {
        if (i < 0 || i >= numVertices) 
            throw new IllegalArgumentException("fuera de rango!!!");
        return gradoEntrada.get(i);
    }

    public int gradoDeSalida(int i) 
    {
        if (i < 0 || i >= numVertices)
            throw new IllegalArgumentException("fuera de rango!!!");
        return listaAdyacencia.get(i).size(); 
    }

    public int cuantasAristasHay() {
        int contador = 0;
        for (List<Integer> adyacentes : listaAdyacencia.values())
        {
            contador += adyacentes.size(); 
          }
        return contador;
    }

    public boolean adyacente(int i, int j) 
    {
        if (i < 0 || i >= numVertices || j < 0 || j >= numVertices)
         throw new IllegalArgumentException("fuera de rango!!!");
          return listaAdyacencia.get(i).contains(j); 
    }

    public boolean conectados(int i, int j)
    {
        if (i < 0 || i >= numVertices || j < 0 || j >= numVertices)
            throw new IllegalArgumentException("fuera de rango!!!");
        return dfsConectados(i, j, new HashSet<>()); 
    }

    private boolean dfsConectados(int i, int j, Set<Integer> visitados) 
    {
        if (i == j) 
            return true;
        if (!visitados.add(i)) 
            return false;
            for (int vecino : listaAdyacencia.get(i)) 
            {
                if (dfsConectados(vecino, j, visitados)) return true;
               }
            return false;
    }

    public String topologicalSort() {
        Map<Integer, Integer> gradoEntradaAux = new HashMap<>(gradoEntrada);

        StringBuilder orden = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(gradoEntradaAux::get));

        for (int i = 0; i < numVertices; i++) 
        {
            if (gradoEntradaAux.get(i) == 0) pq.add(i);
            }

        while (!pq.isEmpty()) {
            int vertice = pq.poll();
            orden.append(vertice).append(" - ");
            for (int vecino : listaAdyacencia.get(vertice)) 
                {
                gradoEntradaAux.put(vecino, gradoEntradaAux.get(vecino) - 1);
                if (gradoEntradaAux.get(vecino) == 0) pq.add(vecino);
                 }
        }

        return orden.length() > 0 ? orden.substring(0, orden.length() - 3) : "";
    }

    public boolean tieneCiclos() {
        Set<Integer> visitados = new HashSet<>();
        Set<Integer> enPila = new HashSet<>();
        for (int i = 0; i < numVertices; i++) 
        {
            if (!visitados.contains(i)) 
            {
                if (dfsCiclo(i, visitados, enPila)) return true;
              }
        }
        return false;
    }

    private boolean dfsCiclo(int v, Set<Integer> visitados, Set<Integer> enPila) 
    {
        if (enPila.contains(v))
            return true;
        if (visitados.contains(v)) 
            return false;

        visitados.add(v);
        enPila.add(v);

        for (int vecino : listaAdyacencia.get(v))
        {
            if (dfsCiclo(vecino, visitados, enPila)) return true;
          }

        enPila.remove(v);
        return false;
    }

    public boolean insertarArista(int i, int j)
    {
        if (i == j || adyacente(i, j) || tieneCiclos())
            return false;
        listaAdyacencia.get(i).add(j); 
        gradoEntrada.put(j, gradoEntrada.get(j) + 1); 

        graphStreamGraph.addEdge(i + "-" + j, String.valueOf(i), String.valueOf(j), true); 
        return true;
    }

    public void eliminarAristas() 
    {
            for (List<Integer> adyacentes : listaAdyacencia.values()) 
            {
                adyacentes.clear();
            }
        for (Integer v : gradoEntrada.keySet()) 
        {
            gradoEntrada.put(v, 0); 
        }
    }

    public String mostrarEstructura() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) 
        {
            sb.append(i).append(": ").append(listaAdyacencia.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public Graph crearGrafoGraphStream()
    {
        graphStreamGraph.setAttribute("ui.stylesheet", 
            "node { size: 20px; fill-color: black; text-size: 40px; text-color: red; text-style: bold; } " + 
            "node:clicked { fill-color: blue; }");

        for (Node n : graphStreamGraph)
        {
            n.setAttribute("ui.label", n.getId()); 
        }

        return graphStreamGraph;
    }

    public void guardarGrafo(String ruta)
    {
        try {
            List<String> aristas = new ArrayList<>();
            for (int i = 0; i < numVertices; i++)
            {
                for (int j : listaAdyacencia.get(i)) 
                {
                    aristas.add(i + " -> " + j); 
                }
            }

            Collections.sort(aristas);

            Set<String> setAristas = new HashSet<>(aristas);

            String grafoAComparar = String.join("\n", setAristas);

            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String line;
            StringBuilder contenidoArchivo = new StringBuilder();
            boolean grafoExistente = false;

            while ((line = reader.readLine()) != null) {
                contenidoArchivo.append(line).append("\n");

                if (line.startsWith("Fecha: ")) {
                    StringBuilder aristasGrafo = new StringBuilder();
                        while ((line = reader.readLine()) != null && !line.startsWith("Fecha: ")) 
                        {
                            aristasGrafo.append(line).append("\n");
                        }

                    
                    Set<String> setAristasGrafo = new HashSet<>(Arrays.asList(aristasGrafo.toString().split("\n")));
                        if (setAristasGrafo.equals(setAristas)) 
                        {
                            grafoExistente = true;
                            break;
                        }
                }
            }
            reader.close();

            if (grafoExistente) 
            {
                System.out.println("ya esta almacenado");
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) 
                {
                    writer.write("Fecha: " + new Date() + " | Vertices: " + numVertices + "\n");

                        for (String arista : setAristas)
                        {
                            writer.write(arista + "\n");
                        }
                }
                System.out.println("Guardado!!!!");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public int contarGrafos(String ruta) {
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) 
        {
            String line;

            while ((line = reader.readLine()) != null) 
            {
                if (line.startsWith("Fecha: "))
                {
                    contador++;
                }
            }
        } catch (IOException e) 
            {
                e.printStackTrace();
            }

        return contador;
    }

    public String cargarGrafoPorIndice(String ruta, int indice) 
    {
        String apartadoStr = "";
        int contador = 0;
        int size = contarGrafos(ruta);

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta)))
        {
            String line;

            while ((line = reader.readLine()) != null) 
            {
                if (line.startsWith("Fecha: "))
                {
                    contador++;
                }
                if(contador == indice)
                {
                    apartadoStr += line + "\n";
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        return apartadoStr;
    }
    
    public String matrizDeAdyacencia()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
            for (int i = 0; i < numVertices; i++) 
            {
                sb.append(i).append(" ");
            }
            sb.append("\n");

        for (int i = 0; i < numVertices; i++)
        {
            sb.append(i).append("  ");
            for (int j = 0; j < numVertices; j++) 
            {
                sb.append(adyacente(i, j) ? "1 " : "0 ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
