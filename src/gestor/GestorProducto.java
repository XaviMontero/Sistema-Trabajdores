package gestor;

import global.Global;
import model.InformesProducto;
import model.Producto;
import model.Trabajador;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class GestorProducto {

    public static Producto getProducto (String nombres){
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<Producto> trabajadors =  session.createQuery(" FROM model.Producto where nombreProduc='"+nombres+"'").list();
        session.close();

        try{

            return trabajadors.get(0);

        }catch (IndexOutOfBoundsException e ){
            System.out.println("No existe");
        }
        return  null;

    }
    public static SortedSet<String> getNombreProductos(){
        SortedSet<String> usuarios = new TreeSet<>();
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<Producto> trabajadors =  session.createQuery(" FROM model.Producto").list();
        session.close();
        for (Producto recu : trabajadors){
            String nombre = recu.getNombreProduc();

            usuarios.add(nombre);


        }

        return usuarios;
    }

    public static double getTotalProforma (String fechaInicio, String fechaFIn)
    {
        double i = 0;
        Session session = Global.CONEXION.factory.getCurrentSession();

        session.beginTransaction();
            List<InformesProducto> list = session.createQuery("  FROM model.InformesProducto where fechaInfo between '"+fechaInicio+"' and '"+fechaFIn+"' " ).list();

            for(InformesProducto re : list){
                i =i+re.getTotal();
            }

        session.close();
        return i;
    }
}
