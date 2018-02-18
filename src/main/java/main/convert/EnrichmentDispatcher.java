package main.convert;

import io.reactivex.Observable;
import main.enrichment.EnrichedData;
import main.enrichment.Enricher;
import main.enrichment.ValueOneEnricher;
import main.enrichment.ValueThreeEnricher;
import main.enrichment.ValueTwoEnricher;
import main.model.Data;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class EnrichmentDispatcher {
    public static io.reactivex.functions.Function<Data, Data> enrichRxJava() {
        return data -> {
            final EnrichedData enrichedData = new EnrichedData();
            List<Observable<Enricher>> dataEnrichers = new ArrayList<>();
            dataEnrichers.add(ValueOneEnricher.enrichRxJava());
            dataEnrichers.add(ValueTwoEnricher.enrichRxJava());
            dataEnrichers.add(ValueThreeEnricher.enrichRxJava());
            Observable.zip(dataEnrichers, new EnrichedDataAccumulator()::accumulateEnrichedData)
                    .lastElement()
            .subscribe(result -> enrichedData.setData(result));
            return enrichedData.getData();

        };
    }

    public static java.util.function.Function<Data, Data> enrichReactor() {
        return data -> {
            final EnrichedData enrichedData = new EnrichedData();
            List<Flux<Enricher>> dataEnrichers = new ArrayList<>();
            dataEnrichers.add(ValueOneEnricher.enrichReactor());
            dataEnrichers.add(ValueTwoEnricher.enrichReactor());
            dataEnrichers.add(ValueThreeEnricher.enrichReactor());
            Flux.zip(dataEnrichers, new EnrichedDataAccumulator()::accumulateEnrichedData)
                    .last()
                    .subscribe(result -> enrichedData.setData(result));
            return enrichedData.getData();
        };
    }
}
