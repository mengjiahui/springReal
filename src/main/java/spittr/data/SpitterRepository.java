package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter unsaved);

    void atLeastOnce();

    Spitter findByUsername(String username);

    public void markAnything();
}
