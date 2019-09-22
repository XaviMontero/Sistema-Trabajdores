package gestor;

import global.Global;
import model.Transaccion;
import org.hibernate.Session;

import java.util.List;

public class GestorTransaccion {

    public static Transaccion getHoraEntradaOsalida(int codigo) {
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<Transaccion> trabajadors = session.createQuery(" FROM model.Transaccion where horaSalida is null and trabajador =" + codigo + "").list();
        session.close();

        try {

            return trabajadors.get(0);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe");
        }
        return null;

    }


    public static List<Transaccion> getNombresTrabajadores(int codigo) {
        Session session = Global.CONEXION.factory.getCurrentSession();
        session.beginTransaction();
        List<Transaccion> transaccions = session.createQuery(" FROM model.Transaccion where  trabajador.id=" + codigo + " and estadoPago=false").list();
        session.close();


        return transaccions;
    }


    public static int getTotalHorasPagar(int codigoTrabajador) {
        int i = 0;
        Session session = Global.CONEXION.factory.getCurrentSession();
        try {
            List<Long> list = session.createQuery("SELECT sum(totalHoras) FROM model.Transaccion where trabajador.codgioTrabajador =" + codigoTrabajador + "  and estadoPago =false  ").list();
            i = list.get(0).intValue();
        } catch (Exception e) {

            i = 0;
        }
        session.close();
        return i;
    }

    public static int getTotalMinutosPagar(int codigoTrabajador) {
        int i = 0;
        Session session = Global.CONEXION.factory.getCurrentSession();
        try {
            List<Long> list = session.createQuery("SELECT sum(totalMinutos) FROM model.Transaccion where trabajador.codgioTrabajador =" + codigoTrabajador + "  and estadoPago =false  ").list();
            i = list.get(0).intValue();
        } catch (Exception e) {

            i = 0;
        }
        session.close();
        return i;
    }
}
