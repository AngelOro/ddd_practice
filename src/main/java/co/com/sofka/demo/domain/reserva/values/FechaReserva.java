package co.com.sofka.demo.domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaReserva implements ValueObject<String> {
    private final LocalDateTime date;
    private final String format;

    public FechaReserva(int day, int month, int year, int hour, int minute ) {
        try {
            date = LocalDateTime.of(year, month, day, hour, minute);
            if(date.isBefore(LocalDateTime.now())){
                throw new IllegalArgumentException("Fecha de reserva no valida");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    @Override
    public String value() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        FechaReserva that = (FechaReserva) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }
}
