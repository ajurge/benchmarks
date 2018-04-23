package com.bipinet.benchmarks;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ListElementModifierTest {

    private static List<ListElement> expectedList;
    private static List<ListElement> sourceList;
    private static final int size = 5;

    @BeforeClass
    public static void setUpClass() {
        expectedList = Arrays.asList(
                new ListElement("foo MODIFIED 0"),
                new ListElement("foo MODIFIED 1"),
                new ListElement("foo MODIFIED 2"),
                new ListElement("foo MODIFIED 3"),
                new ListElement("foo MODIFIED 4")
        );
    }

    @Before
    public void setUp() {
        sourceList = new ArrayList<>(Collections.nCopies(size, new ListElement("foo")));
    }

    @Test
    public void listIteratorReturnsModifiedListElements(){
        assertThat(ListElementModifier.listIterator(sourceList), is(expectedList));
    }

    @Test
    public void forEachLoopReturnsModifiedListElements(){
        assertThat(ListElementModifier.forEachLoop(sourceList), is(expectedList));
    }

    @Test
    public void forLoopReturnsModifiedListElements(){
        assertThat(ListElementModifier.forLoop(sourceList), is(expectedList));
    }

    @Test
    public void streamReturnsModifiedListElements() {
        assertThat(ListElementModifier.stream(sourceList), is(expectedList));
    }

}
