package com.basis.colatina.gerenciadordetarefas.builder;

import java.text.ParseException;
import java.util.Collection;

public abstract class ConstructorEntity<E> {

    private CustomizeEntity<E> customize;

    public E buildAndSave() throws ParseException {
        final E entity = buildEntity();
        if (isCustomize()) {
            customize.execute(entity);
            setCustomize(null);
        }
        return persist(entity);
    }

    public ConstructorEntity<E> customize(CustomizeEntity<E> customization) {
        this.customize = customization;
        return this;
    }

    public abstract E buildEntity() throws ParseException;

    public abstract E persist(E entity);

    public abstract E findById(Integer id);

    public abstract Collection<E> findAll();

    public boolean isCustomize() {
        return this.customize != null;
    }

    public void setCustomize(CustomizeEntity<E> customize) {
        this.customize = customize;
    }
}
