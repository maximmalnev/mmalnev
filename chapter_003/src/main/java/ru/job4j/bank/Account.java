package ru.job4j.bank;

public class Account {
    private Integer requisites, value;

    public Account(Integer requisites, Integer value) {
        this.requisites = requisites;
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getRequisites() {

        return requisites;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Account{" + "requisites=" + requisites + ", value=" + value + '}';
    }
}
