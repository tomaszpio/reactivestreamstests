package main.model;

public class Data {
    private final Integer id;
    private Integer value1;
    private Integer value2;
    private String value3;

    public Data(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
}
