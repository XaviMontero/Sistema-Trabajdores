package gestor;

import global.Global;
import org.hibernate.Session;

public class GestorGlobal {


    public static void save(Object user){
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
    public static void update(Object user){
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

}
