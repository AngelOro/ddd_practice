package co.com.sofka.demo.domain.solicitante.values;

import co.com.sofka.domain.generic.Identity;

public class SancionId extends Identity {
    private SancionId(String uid) {
        super(uid);
    }

    public SancionId() { }

    public static SancionId of(String uid){
        return new SancionId(uid);
    }
}
