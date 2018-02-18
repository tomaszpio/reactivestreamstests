package main.enrichment;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

public class ValueTwoEnricher {
    public static Observable<Enricher> enrichRxJava(){
        return Observable.just(new Enricher(data -> {
            data.setValue2(20);
        }));
    }

    public static Flux<Enricher> enrichReactor(){
        return Flux.just(new Enricher(data -> {
            data.setValue2(20);
        }));
    }
}
