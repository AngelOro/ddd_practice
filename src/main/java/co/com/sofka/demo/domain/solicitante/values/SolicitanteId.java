package co.com.sofka.demo.domain.solicitante.values;

import co.com.sofka.domain.generic.Identity;

public class SolicitanteId extends Identity {

    private SolicitanteId(String uid) {
        super(uid);
    }

    public SolicitanteId() { }

    public static SolicitanteId of(String uid){
        return new SolicitanteId(uid);
    }
}
