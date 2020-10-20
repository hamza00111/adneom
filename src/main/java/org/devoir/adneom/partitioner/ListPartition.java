package org.devoir.adneom.partitioner;

import java.util.ArrayList;
import java.util.List;

public class ListPartition<T> {

    public static <T> List<List<T>> partition(List<T> listToChunk, int chunkSize) {
        if (chunkSize <= 0) {
            throw new IllegalArgumentException("Size of partition should be > 0");
        }

        return new Partition(listToChunk, chunkSize).chunk();
    }

    private static class Partition<T> {
        List<T> listToChunk;
        int chunkSize;

        Partition(List<T> listToChunk, int chunkSize) {
            this.listToChunk = listToChunk;
            this.chunkSize = chunkSize;
        }

        public List<List<T>> chunk() {
            List<List<T>> chunkedList = new ArrayList();
            int partitionsSize = partitionsSize();
            for (int i = 0; i < partitionsSize; i++) {
                chunkedList.add(get(i));
            }

            return chunkedList;
        }

        private List<T> get(int index) {
            int start = index * chunkSize;
            int end = Math.min(start + chunkSize, listToChunk.size());
            if (start > end) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of the list range <0," + (partitionsSize() - 1) + ">");
            }
            return listToChunk.subList(start, end);
        }

        private int partitionsSize() {
            return (int) Math.ceil((double) listToChunk.size() / (double) chunkSize);
        }
    }
}
