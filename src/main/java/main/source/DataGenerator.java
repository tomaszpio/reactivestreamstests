package main.source;

import io.reactivex.Observable;
import main.model.InputData;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataGenerator {
    private final List<InputData> data = new ArrayList<>();

    public DataGenerator() {
        IntStream.range(0, 10_000).forEach(id -> {
            data.add(new InputData(id));
        });
    }

    public Observable<InputData> getDataObservable(){
        return Observable.fromIterable(data);
    }

    public Flux<InputData> getDataFlux() {return Flux.fromIterable(data);}

    public List<InputData> getData() {
        return data;
    }
}
