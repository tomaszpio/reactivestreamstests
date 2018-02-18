package main.enrichment;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

public class ValueOneEnricher {
    public static Observable<Enricher> enrichRxJava(){
        return Observable.just(new Enricher(data -> {
            data.setValue1(10);
        }));
    }

    public static Flux<Enricher> enrichReactor(){
        return Flux.just(new Enricher(data -> {
            data.setValue1(10);
        }));
    }
}
