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
public class ListsBulkOperationsBenchmarks {
    @Param({"100", "1000", "10000"})
    public int iterations;

    private List<Integer> sourceArrayList;
    private IntArrayList fastutilIntArraySourceList;
    private org.eclipse.collections.impl.list.mutable.primitive.IntArrayList eclipseIntArraySourceList;

    @Setup(Level.Trial)
    public void setup() {
        sourceArrayList = new ArrayList<>(iterations);
        eclipseIntArraySourceList = new org.eclipse.collections.impl.list.mutable.primitive.IntArrayList();
        fastutilIntArraySourceList = new IntArrayList();

        for (int i = 0; i < iterations; i++) {
            sourceArrayList.add(i);
            eclipseIntArraySourceList.add(i);
            fastutilIntArraySourceList.add(i);
        }
    }

    @Benchmark
    public List<Integer> testAddAllArrayList() {
        var list = new ArrayList<Integer>();
        list.addAll(sourceArrayList);
        return list;
    }

    @Benchmark
    public IntArrayList testAddAllFastutilIntArrayList() {
        var list = new IntArrayList();
        list.addAll(fastutilIntArraySourceList);

        return list;
    }

    @Benchmark
    public org.eclipse.collections.impl.list.mutable.primitive.IntArrayList testAddAllEclipseIntArrayList() {
        var list = new org.eclipse.collections.impl.list.mutable.primitive.IntArrayList();
        list.addAll(eclipseIntArraySourceList);

        return list;
    }

    @Benchmark
    public FastList<Integer> testAddAllEclipseFastList() {
        var list = new FastList<Integer>();
        list.addAll(sourceArrayList);

        return list;
    }
}
