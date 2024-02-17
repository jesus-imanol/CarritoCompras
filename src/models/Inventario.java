package models;

import java.util.ArrayList;

public class Inventario {
private int id;
private String nombre;

private ArrayList<Producto> productos=new ArrayList<>();

public boolean addProduct(Producto product){
    boolean status;
    status = productos.add(product);
    return status;
}
public ArrayList<Producto> getProductos(){
    return productos;
    }
}
