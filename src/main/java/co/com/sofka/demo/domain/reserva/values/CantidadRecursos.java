package co.com.sofka.demo.domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadRecursos implements ValueObject<Integer> {
    private final Integer value;

    public CantidadRecursos(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public Integer value() {
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
