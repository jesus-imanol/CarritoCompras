package models;

import java.util.ArrayList;

public class Carrito {
    int idCart;
    private ArrayList<Producto> carrito=new ArrayList<>();
    private ArrayList<Comprador> comprador=new ArrayList<>();

    private boolean statusCart;

    private int state;
    public boolean addCompradorPago(Comprador buyer){
        boolean status;
        status=comprador.add(buyer);
        return status;
    }
    public ArrayList<Comprador> getCompradorId(){
        return comprador;
    }

    public Carrito() {
        this.idCart=(int)(Math.random()*100+1);
        statusCart=false;

    }

    public boolean isStatusCart() {
        return statusCart;
    }

    public void setStatusCart(boolean estado) {
        this.statusCart = estado;
    }

    public int getId() {
        return idCart;
    }

    public void setId(int id) {
        this.idCart = id;
    }

    public int isState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean addProductCarrito(Producto carritoCompras){
        boolean status;
        status=carrito.add(carritoCompras);
        return status;
    }
    public ArrayList<Producto> getCarrito(){
        return carrito;
    }

    @Override
    public String toString() {
        return " " +idCart +
                ", carrito: " + carrito ;
    }
}
