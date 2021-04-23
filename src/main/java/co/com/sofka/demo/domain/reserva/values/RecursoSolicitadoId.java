package co.com.sofka.demo.domain.reserva.values;

import co.com.sofka.domain.generic.Identity;

public class RecursoSolicitadoId extends Identity {
    private RecursoSolicitadoId(String uid) {
        super(uid);
    }

    public RecursoSolicitadoId() { }

    public static RecursoSolicitadoId of(String uid){
        return new RecursoSolicitadoId(uid);
    }
}
