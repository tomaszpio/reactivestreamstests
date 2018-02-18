package main.enrichment;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;;

public class ValueThreeEnricher {

    public static Observable<Enricher> enrichRxJava(){
        return Observable.just(new Enricher(data -> {
            data.setValue3("rxJava enrichment");
        }));
    }

    public static Flux<Enricher> enrichReactor(){
        return Flux.just(new Enricher(data -> {
            data.setValue3("rxJava enrichment");
        }));
    }
}
