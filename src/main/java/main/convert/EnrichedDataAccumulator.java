package main.convert;

import main.enrichment.Enricher;
import main.model.Data;

import java.util.stream.Stream;

public class EnrichedDataAccumulator {
    private Data enrichedData = new Data(0);

    public Data accumulateEnrichedData(Object[] enrichers){
        Stream.of(enrichers)
                .filter(enricher -> enricher != null)
                .forEach(enricher -> ((Enricher)enricher).enrich().accept(enrichedData));
        return enrichedData;
    }
}
