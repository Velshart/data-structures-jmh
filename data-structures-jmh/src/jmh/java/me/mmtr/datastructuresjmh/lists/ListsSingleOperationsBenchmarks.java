package me.mmtr.datastructuresjmh.lists;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(
        iterations = 5,
        time = 1,
        timeUnit = TimeUnit.SECONDS
)
@Fork(3)
@Measurement(
        iterations = 5,
        time = 1,
        timeUnit = TimeUnit.SECONDS
)
@State(Scope.Benchmark)
public class ListsSingleOperationsBenchmarks {
    // Czas wykonania pojedynczej operacji można otrzymać dzieląc wynik Benchmarku (Score)
    // przez liczbę iteracji (zmienna iterations).

    @Param({"100", "1000", "10000"})
    public int iterations;

    @Benchmark
    public List<Integer> testAddRepeatedlyArrayList() {
        var list = new ArrayList<Integer>();

        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    public IntArrayList testAddRepeatedlyFastutilIntArrayList() {
        var list = new IntArrayList();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    public org.eclipse.collections.impl.list.mutable.primitive.IntArrayList testAddRepeatedlyEclipseIntArrayList() {
        var list = new org.eclipse.collections.impl.list.mutable.primitive.IntArrayList();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    public FastList<Integer> testAddRepeatedlyEclipseFastList() {
        var list = new FastList<Integer>();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return list;
    }
}
