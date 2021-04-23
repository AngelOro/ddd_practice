package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreRecurso implements ValueObject<String>  {
    private final String value;

    public NombreRecurso(String nombreRecurso) {
        this.value = Objects.requireNonNull(nombreRecurso);
        if(nombreRecurso.isBlank()){
            throw new IllegalArgumentException("El nombre del recurso no puede esta vacio");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
