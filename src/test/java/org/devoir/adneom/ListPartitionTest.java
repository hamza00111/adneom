package org.devoir.adneom;

import org.devoir.adneom.partitioner.ListPartition;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListPartitionTest {

    @Test
    public void should_return_1_2_3_4_5_6_7and_when_chunk_size_is_1() {
        List<Integer> listToChunk = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int chunkSize = 1;

        List<Integer> firstPartition = Arrays.asList(1);
        List<Integer> secondPartition = Arrays.asList(2);
        List<Integer> thirdPartition = Arrays.asList(3);
        List<Integer> fourthPartition = Arrays.asList(4);
        List<Integer> fifthPartition = Arrays.asList(5);
        List<Integer> sixthPartition = Arrays.asList(6);
        List<Integer> seventhPartition = Arrays.asList(7);
        Assert.assertEquals(Arrays.asList(firstPartition, secondPartition, thirdPartition,
                fourthPartition, fifthPartition, sixthPartition, seventhPartition),
                ListPartition.partition(listToChunk, chunkSize));
    }

    @Test
    public void should_return_123_and_456_when_chunk_size_is_3() {
        List<Integer> listToChunk = Arrays.asList(1, 2, 3, 4, 5, 6);
        int chunkSize = 3;

        List<Integer> firstPartition = Arrays.asList(1, 2, 3);
        List<Integer> secondPartition = Arrays.asList(4, 5, 6);
        Assert.assertEquals(Arrays.asList(firstPartition, secondPartition),
                ListPartition.partition(listToChunk, chunkSize));
    }

    @Test
    public void should_return_123_456_7_when_chunk_size_is_3() {
        List<Integer> listToChunk = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int chunkSize = 3;

        List<Integer> firstPartition = Arrays.asList(1, 2, 3);
        List<Integer> secondPartition = Arrays.asList(4, 5, 6);
        List<Integer> thirdPartition = Arrays.asList(7);
        Assert.assertEquals(Arrays.asList(firstPartition, secondPartition, thirdPartition),
                ListPartition.partition(listToChunk, chunkSize));
    }

    @Test
    public void should_return_ab_cd_ef_g_when_chunk_size_is_2() {
        List<Character> listToChunk = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g');
        int chunkSize = 2;


        List<Character> firstPartition = Arrays.asList('a', 'b');
        List<Character> secondPartition = Arrays.asList('c', 'd');
        List<Character> thirdPartition = Arrays.asList('e', 'f');
        List<Character> fourthPartition = Arrays.asList('g');
        Assert.assertEquals(Arrays.asList(firstPartition, secondPartition, thirdPartition, fourthPartition),
                ListPartition.partition(listToChunk, chunkSize));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_argument_exception_if_chunk_size_is_negative() {

        List<Integer> listToChunk = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int chunkSize = -1;

        ListPartition.partition(listToChunk, chunkSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_argument_exception_if_chunk_size_is_0() {

        List<Integer> listToChunk = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int chunkSize = 0;

        ListPartition.partition(listToChunk, chunkSize);
    }

}
