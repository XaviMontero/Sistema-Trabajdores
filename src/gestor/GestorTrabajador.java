package gestor;

import global.Global;
import model.Trabajador;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class GestorTrabajador {

    public static SortedSet<String> getNombresTrabajadores(){
        SortedSet<String> usuarios = new TreeSet<>();
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<Trabajador> trabajadors =  session.createQuery(" FROM model.Trabajador").list();
        session.close();
        for (Trabajador recu : trabajadors){
            String nombre = recu.getNombreTra()+""+recu.getApellidoTra();
            
            usuarios.add(nombre);
            

        }

        return usuarios;
    }

        public static Trabajador   getCodigo (String nombres){
            Session session = Global.CONEXION.factory.getCurrentSession();
            session.beginTransaction();
            List<Trabajador> trabajadors =  session.createQuery(" FROM model.Trabajador where concat(nombreTra,apellidoTra)= '"+nombres+"'").list();
            session.close();

            try{

              return trabajadors.get(0);

            }catch (IndexOutOfBoundsException e ){
                System.out.println("No existe");
            }
            return  null;

    }
}
