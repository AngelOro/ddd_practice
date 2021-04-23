package co.com.sofka.demo.domain.solicitante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDocumento implements ValueObject<String> {
    private final String value;

    public TipoDocumento(String apellido) {
        this.value = Objects.requireNonNull(apellido);
        if(apellido.isBlank()){
            throw new IllegalArgumentException("El tipo documento del solicitante no puede esta vacio");
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
