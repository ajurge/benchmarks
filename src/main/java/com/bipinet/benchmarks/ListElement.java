package com.bipinet.benchmarks;

import java.util.Objects;

public class ListElement {

    private String name;

    ListElement(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListElement that = (ListElement) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ListElement{" +
                "name='" + name + '\'' +
                '}';
    }
}