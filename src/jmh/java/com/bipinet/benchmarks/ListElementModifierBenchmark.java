package com.bipinet.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class ListElementModifierBenchmark {

    @Param({"100", "1000", "10000"})
    private int size;

    private List<ListElement> sourceList;


    @Setup(Level.Invocation)
    public void setUp() {
        sourceList = new ArrayList<>(Collections.nCopies(size, new ListElement("foo")));
    }

    @Benchmark
    public List<ListElement> listIterator() {
        return ListElementModifier.listIterator(sourceList);
    }

    @Benchmark
    public List<ListElement> forEachLoop() {
        return ListElementModifier.forEachLoop(sourceList);
    }

    @Benchmark
    public List<ListElement> forLoop() {
        return ListElementModifier.forLoop(sourceList);
    }

    @Benchmark
    public List<ListElement> stream() {
        return ListElementModifier.stream(sourceList);
    }

}
