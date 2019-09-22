package gestor;

import global.Global;
import model.FacturaCabecera;
import model.Trabajador;
import org.hibernate.Session;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class GestorFactura {


    public static int getFacturasCode() {
        int i=0;
        try{
            SortedSet<String> usuarios = new TreeSet<>();
            Session session = Global.CONEXION.factory.getCurrentSession();
            session.beginTransaction();
            List<FacturaCabecera> trabajadors = session.createQuery(" FROM model.FacturaCabecera").list();
            session.close();
            i= trabajadors.get(trabajadors.size()-1).getIdFactura()+1;
            System.err.println(i);
        }catch (IndexOutOfBoundsException ex){
            i=1;
        }


        return i;
    }

    public static FacturaCabecera getCodigo(int  code) {
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<FacturaCabecera> trabajadors = session.createQuery(" FROM model.FacturaCabecera where idFactura= " + code + "").list();
        session.close();

        try {

            return trabajadors.get(0);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe");
        }
        return null;

    }
}
