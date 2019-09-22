package global;

import conection.Conection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Global {


    public static Conection CONEXION = new Conection();
    public static String formato;


    public static Date getFechaActual() {


        Date date = new Date();
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            System.out.println("Fecha: " + dateFormat.format(date));

            date = dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date getHoraActual() {


        Date date = new Date();
        try {

//Caso 1: obtener la hora y salida por pantalla con formato:
            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);

            date = hourFormat.parse(hourFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date getMyHora(String hora) {


        Date date = null;
        try {

            DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
            System.out.println("Hora: " + hourFormat.parse(hora));

            date = hourFormat.parse(hora);
        } catch (ParseException e) {

        }

        return date;
    }


    public static Date getFechaFormato(String dateInString) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);


        Date date = null;

        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int obtenerAnio(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerDia(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerMes(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "MM";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerhoras(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "HH";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerMinutos(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "mm";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

    public static int obtenerSegundos(Date date) {

        if (null == date) {

            return 0;

        } else {

            formato = "ss";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }
}
