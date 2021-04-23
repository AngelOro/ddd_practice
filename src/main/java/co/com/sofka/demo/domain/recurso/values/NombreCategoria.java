package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCategoria  implements ValueObject<String> {
    private final String value;

    public NombreCategoria(String nombreCategoria) {
        this.value = Objects.requireNonNull(nombreCategoria);
        if(nombreCategoria.isBlank()){
            throw new IllegalArgumentException("El nombre del recurso no puede esta vacio");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
