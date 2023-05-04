package com.example.jsons.gerandoJSONfor;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Compra() {
        itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

}
