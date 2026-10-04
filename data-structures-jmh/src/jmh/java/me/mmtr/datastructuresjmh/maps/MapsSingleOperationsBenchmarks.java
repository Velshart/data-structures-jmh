package me.mmtr.datastructuresjmh.maps;

import it.unimi.dsi.fastutil.ints.Int2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.TreeMap;
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
public class MapsSingleOperationsBenchmarks {
    @Param({"100", "1000", "10000"})
    public int iterations;

    private static final String VALUE = "value";

    @Benchmark
    public HashMap<Integer, String> testAddRepeatedlyHashMap() {
        var map = new HashMap<Integer, String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public Int2ObjectOpenHashMap<String> testAddRepeatedlyFastutilInt2ObjectOpenHashMap() {
        var map = new Int2ObjectOpenHashMap<String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public IntObjectHashMap<String> testAddRepeatedlyEclipseIntObjectHashMap() {
        var map = new IntObjectHashMap<String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public UnifiedMap<Integer, String> testAddRepeatedlyEclipseUnifiedMap() {
        var map = new UnifiedMap<Integer, String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public TreeMap<Integer, String> testAddRepeatedlyTreeMap() {
        var map = new TreeMap<Integer, String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public Int2ObjectAVLTreeMap<String> testAddRepeatedlyFastutilInt2ObjectAVLTreeMap() {
        var map = new Int2ObjectAVLTreeMap<String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public Int2ObjectRBTreeMap<String> testAddRepeatedlyEclipseInt2ObjectRBTreeMap() {
        var map = new Int2ObjectRBTreeMap<String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }

    @Benchmark
    public TreeSortedMap<Integer, String> testAddRepeatedlyEclipseTreeSortedMap() {
        var map = new TreeSortedMap<Integer, String>();
        for (int i = 0; i < iterations; i++) {
            map.put(i, VALUE);
        }

        return map;
    }
}
