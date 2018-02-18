package main.convert;

import main.model.Data;
import main.model.OutputData;

public class OutputConverter {
    public static io.reactivex.functions.Function<Data, OutputData> invokeRxJava() {
        return data -> new OutputData(data.getId(), data.getValue1(), data.getValue2(), data.getValue3());
    }

    public static java.util.function.Function<Data, OutputData> invokeReactor() {
        return data -> new OutputData(data.getId(), data.getValue1(), data.getValue2(), data.getValue3());
    }
}
