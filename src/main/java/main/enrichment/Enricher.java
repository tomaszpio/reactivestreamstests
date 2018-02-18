package main.enrichment;

import main.model.Data;

import java.util.function.Consumer;

public class Enricher {

    private final Consumer<Data> dataEnricher;

    public Enricher(Consumer<Data> dataEnricher) {
        this.dataEnricher = dataEnricher;
    }

    public Consumer<Data> enrich(){
        return dataEnricher;
    }
}
