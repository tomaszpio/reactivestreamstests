package main;

import main.convert.EnrichmentDispatcher;
import main.convert.InputDataConverter;
import main.convert.OutputConverter;
import main.source.DataGenerator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class ReactiveFlowRunner {

    public static final InputDataConverter INPUT_DATA_CONVERTER = new InputDataConverter();
    public static final EnrichmentDispatcher ENRICHMENT_DISPATCHER = new EnrichmentDispatcher();
    public static final OutputConverter OUTPUT_CONVERTER = new OutputConverter();
    private DataGenerator dataGenerator = new DataGenerator();

    @Benchmark
    @Fork(1)
    public void rxJavaFlowTest(Blackhole blackhole){

        dataGenerator.getDataObservable()
                .map(INPUT_DATA_CONVERTER.convertRxJava())
                .map(ENRICHMENT_DISPATCHER.enrichRxJava())
                .map(OUTPUT_CONVERTER.invokeRxJava())
                .subscribe(data -> blackhole.consume(data));
    }


    @Benchmark
    @Fork(1)
    public void reactorFlowTest(Blackhole blackhole){

        dataGenerator.getDataFlux()
                .map(INPUT_DATA_CONVERTER.convertReactor())
                .map(ENRICHMENT_DISPATCHER.enrichReactor())
                .map(OUTPUT_CONVERTER.invokeReactor())
                .subscribe(data -> blackhole.consume(data));
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
