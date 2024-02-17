package models;

import java.util.ArrayList;

public class Pago{
    private int idPago;
    private ArrayList<Carrito> cart =new ArrayList<>();

    public ArrayList<Carrito> getCart(){
       return cart;
    }

    public void setCart(ArrayList<Carrito> cart) {
        this.cart = cart;
    }

    public Carrito actualCarrito(int id){
        return cart.get(searchById(id));
    }
    public int searchById(int id){
        int flag=0;
        for (int i = 0; i <cart.size(); i++) {
            if(cart.get(i).getId() == id) {
                flag=i;
            }
        }
        return flag;
    }

}
