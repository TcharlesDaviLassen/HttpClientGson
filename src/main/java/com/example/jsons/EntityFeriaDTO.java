package com.example.jsons;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class EntityFeriaDTO {

    private String date;
    private String name;
    private String type;

    public EntityFeriaDTO(String date, String name, String type) {
        this.date = date;
        this.name = name;
        this.type = type;
    }

    public String getDate() {

        String[] dados = date.split("-");
        dados[0].toString();
        dados[1].toString();
        dados[2].toString();

        return dados[2].toString()+"/"+dados[1].toString()+"/"+dados[0].toString();
        
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // @Override
    // public String toString() {
    // return ("DATA: " + date + " NOME: " + name + " TIPO: " + type);
    // }

    // @Override
    // public String toString() {
    //     return Arrays.asList(date, String.valueOf(name), type.toString()).toString();
    // }

    @Override
    public String toString() {
        return Arrays.asList(getDate(), name, type).toString();
      
    }
}
