package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Stock implements ValueObject<Integer> {
    private final Integer value;

    public Stock(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public Integer value() {
        return value;
    }

}
