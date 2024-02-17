import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Inventario inventario = new Inventario();
    private static boolean estado;
    private static Pago referenciaPago = new Pago();
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String user;
        String admin="Jesus";
        String password;
        String ispassword="Cast";

        System.out.println("App-Carrito de compras");
        int opcion;

        do {
            System.out.println("1. Administrador");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.println("Opcion: ");
            opcion = keyboard.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese usuario: ");
                    user = keyboard.next();
                    System.out.println("Ingrese su contraseña: ");
                    password = keyboard.next();
                    if (user.equals(admin) && password.equals(ispassword)) {
                        System.out.println("Bienvenido "+ admin +" ¿Que haremos hoy? ");
                        Carrito carrito = new Carrito();
                        int opcionAdmin;
                        do {
                            System.out.println("1.Agregar producto");
                            System.out.println("2.Ver inventario");
                            System.out.println("3.Validar pago");
                            System.out.println("4.Salir");
                            opcionAdmin = keyboard.nextInt();
                            switch (opcionAdmin) {

                                case 1: {
                                    addProductInventario();
                                    break;
                                }
                                case 2: {
                                    listProductInventario();
                                    break;
                                }
                                case 3: {
                                    validarCart(carrito);
                                    break;
                                }
                                case 4: {
                                    System.out.println("Saliendo de administrador....");
                                    break;
                                }

                            }
                        } while (opcionAdmin != 4);
                        break;
                    }
                    else{
                        System.out.println("Usuario incorrecto");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Bienvenido comprador ");
                    int opcionComprador;
                    int id;
                    Carrito carrito = new Carrito();
                    do {
                        id = (int) (Math.random() * 100 + 1);
                        System.out.println("1. Agregar producto al carrito");
                        System.out.println("2. Mostrar carrito");
                        System.out.println("3. Generar pago");
                        System.out.println("4. Estatus del carrito");
                        System.out.println("5. Salir");
                        opcionComprador = keyboard.nextInt();
                        Comprador comprador = new Comprador(id);
                        carrito.addCompradorPago(comprador);
                        switch (opcionComprador) {
                            case 1: {
                                addProductCarrito(carrito);
                                break;
                            }
                            case 2: {
                                listProductCarrito(carrito);
                                break;
                            }
                            case 3: {
                                solicitarPago(carrito);
                                break;
                            }
                            case 4: {
                                cartValidado();
                                break;
                            }
                            case 5: {
                                System.out.println("Espere... esto puede tardar unos minutos");
                                break;
                            }
                        }
                    } while (opcionComprador != 5);
                    break;
                }
                case 3: {
                    System.out.println("Saliendo del programa.....");
                    break;
                }
            }
        } while (opcion != 3);

    }

    private static void addProductInventario() {
        int id;
        String nombre;
        String tipo;
        int precio;
        int cantidad;

        System.out.println("Ingrese ID del producto: ");
        id = keyboard.nextInt();
        System.out.println("Ingrese el nombre: ");
        nombre = keyboard.next();
        System.out.println("Ingrese el tipo: ");
        tipo = keyboard.next();
        System.out.println("Ingrese el precio: ");
        precio = keyboard.nextInt();
        System.out.println("Ingrese la cantidad del producto: ");
        cantidad = keyboard.nextInt();

        Producto product = new Producto(id, nombre, tipo, precio, cantidad);

        if (inventario.addProduct(product)) {
            System.out.println("El producto se ha registrado correctamente");
        } else {
            System.out.println("Registro fallido");
        }
    }
    private static void listProductInventario() {
        ArrayList<Producto> list;
        list = inventario.getProductos();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    private static void addProductCarrito(Carrito carrito) {
        int id = (int) (Math.random() * 100 + 1);
        String nombre;
        String tipo;
        int precio=(int)(Math.random()*100+1);
        int cantidad;
        System.out.println("Ingrese el nombre: ");
        nombre = keyboard.next();
        System.out.println("Ingrese el tipo: ");
        tipo = keyboard.next();
        System.out.println("Ingrese la cantidad del producto: ");
        cantidad = keyboard.nextInt();

        Producto product = new Producto(id, nombre, tipo, precio, cantidad);

        if (carrito.addProductCarrito(product)) {
            System.out.println("El producto se ha agregado al carrito correctamente");
        } else {
            System.out.println("Upsss...Algo fallo");
        }
    }
    private static void listProductCarrito(Carrito carrito) {
        ArrayList<Producto> list;
        list = carrito.getCarrito();
        System.out.println("Recuerda este ID  "+carrito.getId()+ " para saber si el administrador valido tu compra");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
   private static boolean validarCart(Carrito cartt) {
        ArrayList<Carrito> cart;
        cart = referenciaPago.getCart();
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("Deseas validar este carrito " + cart.get(i));
            System.out.println("1.Si 0.No");
            String respuesta = keyboard.next();
            if ("1".equals(respuesta)) {
                estado=true;
             cart.get(i).setStatusCart(estado);
            } else if ("0".equals(respuesta)) {
                estado=false;
                cart.get(i).setStatusCart(estado);
            } else {
                System.out.println("Respuesta no válida. Por favor, ingresa 1 o 0.");
                break;
            }

        }
        return estado;
    }
    private static void cartValidado(){
        ArrayList<Carrito> list;
        list=referenciaPago.getCart();
        int idSearch;
        boolean flag=false;
        for (int i = 0; i < list.size() && !flag; i++) {
            System.out.println("Ingrese el id de su carrito para saber estatus: ");
            idSearch= keyboard.nextInt();
            if(list.get(i).getId()==idSearch){
                flag=true;
                if (list.get(i).isStatusCart()==true){
                    System.out.println("El carrito esta validado ");
                    System.out.println("Estos son tus productos  referencia de pago "+ list.get(i));
                }
                else {
                    System.out.println("El carrito no esta validado");
                }
            }
            else {
                System.out.println("No se encontró ningun carrito");
                flag=true;
            }
        }
    }
    private static void solicitarPago(Carrito carrito) {
        char comprar;
        System.out.println("Comprar productos S/N");
        comprar = keyboard.next().charAt(0);
        if (comprar == 'S' || comprar == 's') {
            referenciaPago.getCart().add(carrito);
            System.out.println("Espera a un momento hasta que el administrador valide tu carrito");
        } else {
            System.out.println(".......");
        }

    }

}

