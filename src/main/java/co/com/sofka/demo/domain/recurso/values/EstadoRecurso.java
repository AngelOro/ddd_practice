package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoRecurso implements ValueObject<String> {
    private final String value;

    public EstadoRecurso(String estado) {
        this.value = Objects.requireNonNull(estado);
        if(estado.isBlank()){
            throw new IllegalArgumentException("La descripción del recurso no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return value;
    }


}