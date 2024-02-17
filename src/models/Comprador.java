package models;

import java.util.ArrayList;

public class Comprador {
    private int id;
    private ArrayList<Comprador> comprador=new ArrayList<>();

    public Comprador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "" + id ;
    }
}
