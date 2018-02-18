package main.model;

public class OutputData {
    private final Integer id;
    private final Integer value1;
    private final Integer value2;
    private final String value3;

    public OutputData(Integer id, Integer value1, Integer value2, String value3) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public Integer getValue1() {
        return value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "id=" + id +
                ", value1=" + value1 +
                ", value2=" + value2 +
                ", value3='" + value3 + '\'' +
                '}';
    }
}
