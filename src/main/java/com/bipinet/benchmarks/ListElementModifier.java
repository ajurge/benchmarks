package com.bipinet.benchmarks;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class ListElementModifier {

    static List<ListElement> listIterator(List<ListElement> sourceList) {
        for (final ListIterator<ListElement> i = sourceList.listIterator(); i.hasNext(); ) {
            final int listElementIndex = i.nextIndex();
            final ListElement listElement = i.next();
            i.set(modifyElement(listElement, listElementIndex));
        }
        return sourceList;
    }

    static List<ListElement> forEachLoop(List<ListElement> sourceList) {
        for (ListElement listElement : sourceList) {
            final int listElementIndex = sourceList.indexOf(listElement);
            sourceList.set(listElementIndex, modifyElement(listElement, listElementIndex));
        }
        return sourceList;
    }

    static List<ListElement> forLoop(List<ListElement> sourceList) {
        for (int i = 0; i < sourceList.size(); i++) {
            sourceList.set(i, modifyElement(sourceList.get(i), i));
        }
        return sourceList;
    }

    static List<ListElement> stream(List<ListElement> sourceList) {
        final AtomicInteger listElementIndex = new AtomicInteger();
        return sourceList.stream().map(listElement ->
                modifyElement(listElement, listElementIndex.getAndIncrement())).collect(Collectors.toList());
    }

    private static ListElement modifyElement(ListElement listElement, int elementIndex) {
        return new ListElement(listElement.getName() + " MODIFIED " + elementIndex);
    }

}
