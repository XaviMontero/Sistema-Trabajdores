package conection;

import model.InformesProducto;
import model.Producto;
import model.Trabajador;
import model.Transaccion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Conection {
    public static SessionFactory factory;

    public Conection() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Trabajador.class)
                .addAnnotatedClass(Transaccion.class)
                .addAnnotatedClass(Producto.class)
                .addAnnotatedClass(InformesProducto.class)

                .buildSessionFactory();
    }



}
