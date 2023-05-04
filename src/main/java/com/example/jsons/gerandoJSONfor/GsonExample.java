package com.example.jsons.gerandoJSONfor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;




public class GsonExample {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Como escrever um arquivo JSON
         */
        createJSON();
        
        System.out.println("\n\n");
        
        /**
         * Como ler arquivo json
         */
        try {
            File filePath = new File("src/main/java/com/example/jsons/gerandoJSONfor/conteudoJson.json");
            loadJSON(filePath);
        } catch (FileNotFoundException ex) {

            Logger.getLogger(GsonExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public static void createJSON() {
        Compra compra = new Compra();

        Cliente cliente = new Cliente();
        cliente.setId(12);
        cliente.setNome("Sherlocked");

        compra.setId(1234);
        compra.setCliente(cliente);

        for (int i = 1; i <= 3; i++) {
            ItemPedido item = new ItemPedido();
            item.setId(i);
            item.setDescricao("Item " + i);
            item.setQtd(10);

            compra.getItens().add(item);
        }

        compra.setId(123);

        // Gson gson = new Gson();

        // Cria uma instância Gson
        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls() 
            .create();

        String json = gson.toJson(compra);

        System.out.println(json);
    }
    
    public static void loadJSON(File filePath) throws FileNotFoundException {
        Reader reader = new FileReader(filePath);

        Gson gson = new Gson();
        Compra pedidoCompra = gson.fromJson(reader, Compra.class);
        pedidoCompra.setId(123);

        System.out.println("Pedido nº: " + pedidoCompra.getId());
        System.out.println("Cliente nº: " + pedidoCompra.getCliente().getId() + " | Nome: " + pedidoCompra.getCliente().getNome());
        System.out.println("Itens: ");
        for (ItemPedido item : pedidoCompra.getItens()) {
            System.out.println("----------------------------------------------------------");
            System.out.println("   Ped. nº: " + item.getId());
            System.out.println("   Item: " + item.getDescricao());
            System.out.println("   Qtd: " + item.getQtd());
        }

    }

    
}
