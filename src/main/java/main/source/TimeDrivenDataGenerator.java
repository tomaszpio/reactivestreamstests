package main.source;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import main.model.InputData;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeDrivenDataGenerator {
    private final PublishSubject<InputData> dataPublishSubject = PublishSubject.create();
    private AtomicInteger idGenerator = new AtomicInteger();
    public Observable<InputData> getDataObservable(){
        return dataPublishSubject;
    }

    public void startTimeDrivenEventsStream(){
        Executors.newScheduledThreadPool(1).schedule(()->{
            dataPublishSubject.onNext(new InputData(idGenerator.getAndIncrement()));
        }, 1, TimeUnit.SECONDS);

        dataPublishSubject.onComplete();
    }
}
