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
public class MapsBulkOperationsBenchmarks {
    @Param({"100", "1000", "10000"})
    public int iterations;

    private static final String VALUE = "value";

    private HashMap<Integer, String> sourceHashMap;
    private IntObjectHashMap<String> intObjectSourceHashMap;

    @Setup(Level.Trial)
    public void setup() {
        sourceHashMap = new HashMap<>();
        intObjectSourceHashMap = new IntObjectHashMap<>();

        for (int i = 0; i < iterations; i++) {
            sourceHashMap.put(i, VALUE);
            intObjectSourceHashMap.put(i, VALUE);
        }
    }

    @Benchmark
    public HashMap<Integer, String> testAddAllHashMap() {
        var map = new HashMap<Integer, String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public Int2ObjectOpenHashMap<String> testAddAllFastutilInt2OpenHashMap() {
        var map = new Int2ObjectOpenHashMap<String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public IntObjectHashMap<String> testAddAllEclipseIntObjectHashMap() {
        var map = new IntObjectHashMap<String>();
        map.putAll(intObjectSourceHashMap);

        return map;
    }

    @Benchmark
    public UnifiedMap<Integer, String> testAddAllEclipseUnifiedMap() {
        var map = new UnifiedMap<Integer, String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public TreeMap<Integer, String> testAddAllTreeMap() {
        var map = new TreeMap<Integer, String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public Int2ObjectAVLTreeMap<String> testAddAllFastutilInt2ObjectAVLTreeMap() {
        var map = new Int2ObjectAVLTreeMap<String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public Int2ObjectRBTreeMap<String> testAddAllFastutilInt2ObjectRBTreeMap() {
        var map = new Int2ObjectRBTreeMap<String>();
        map.putAll(sourceHashMap);

        return map;
    }

    @Benchmark
    public TreeSortedMap<Integer, String> testAddAllEclipseTreeSortedMap() {
        var map = new TreeSortedMap<Integer, String>();
        map.putAll(sourceHashMap);

        return map;
    }
}
