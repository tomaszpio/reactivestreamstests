package main.convert;

import main.model.Data;
import main.model.InputData;

public class InputDataConverter {
    public static io.reactivex.functions.Function<InputData, Data> convertRxJava() {
        return data -> new Data(data.getId());
    }

    public static java.util.function.Function<InputData, Data> convertReactor() {
        return data -> new Data(data.getId());
    }
}
