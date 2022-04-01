package dateIme;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateJavaa {
    public static void main(String[] args) throws ParseException {
        GregorianCalendar date = new GregorianCalendar(2021,11,31);
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);

        //System.out.println(format.format(date));

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        System.out.println(sdf.format(date.getTime()));


        /**
         * Più utilizzato
         */
        String bday = "17/01/2000";
        SimpleDateFormat sdfBd = new SimpleDateFormat("yyyy/mm/dd");
        Date birthday = sdfBd.parse(bday);

        System.out.println(sdfBd.format(birthday));

    }
}
