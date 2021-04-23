package co.com.sofka.demo.domain.recurso.values;

import co.com.sofka.domain.generic.Identity;

public class RecursoId extends Identity {
    private RecursoId(String uid) {
        super(uid);
    }

    public RecursoId() { }

    public static RecursoId of(String uid){
        return new RecursoId(uid);
    }
}
