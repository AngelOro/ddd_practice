package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CodigoBarras implements ValueObject<String> {
    private final String value;

    public CodigoBarras(String codigo) {
        this.value = Objects.requireNonNull(codigo);
        if(codigo.isBlank()){
            throw new IllegalArgumentException("El código de barras no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
