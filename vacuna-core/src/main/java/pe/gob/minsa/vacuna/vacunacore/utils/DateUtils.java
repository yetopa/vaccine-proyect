package pe.gob.minsa.vacuna.vacunacore.utils;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtils {

    public int diffInMonths(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
        Period period = Period.between(ld, LocalDate.now());

        return Long.valueOf(period.toTotalMonths()).intValue();
    }
}
