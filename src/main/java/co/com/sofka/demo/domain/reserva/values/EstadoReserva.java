package co.com.sofka.demo.domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoReserva implements ValueObject<String> {
    private final String value;

    public EstadoReserva(String estado) {
        this.value = Objects.requireNonNull(estado);
        if(estado.isBlank()){
            throw new IllegalArgumentException("La descripción del recurso no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
