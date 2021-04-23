package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionRecurso implements ValueObject<String> {

    private final String value;

    public DescripcionRecurso(String name) {
        this.value = Objects.requireNonNull(name);
        if(name.isBlank()){
            throw new IllegalArgumentException("La descripción del recurso no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
