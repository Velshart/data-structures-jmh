package me.mmtr.datastructuresjmh.sets;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.Set;
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
public class SetsBulkOperationsBenchmarks {
    @Param({"100", "1000", "10000"})
    public int iterations;

    private Set<Integer> sourceHashSet;
    private IntHashSet eclipseIntHashSourceSet;
    private UnifiedSet<Integer> eclipseUnifiedSourceSet;

    @Setup(Level.Trial)
    public void setup() {
        sourceHashSet = new HashSet<>();
        eclipseIntHashSourceSet = new IntHashSet();
        eclipseUnifiedSourceSet = new UnifiedSet<>();

        for (int i = 0; i < iterations; i++) {
            sourceHashSet.add(i);
            eclipseIntHashSourceSet.add(i);
            eclipseUnifiedSourceSet.add(i);
        }
    }

    @Benchmark
    public Set<Integer> testAddAllHashSet() {
        Set<Integer> set = new HashSet<>();
        set.addAll(sourceHashSet);

        return set;
    }

    @Benchmark
    public IntOpenHashSet testAddAllFastutilIntOpenHashSet() {
        var set = new IntOpenHashSet();
        set.addAll(sourceHashSet);

        return set;
    }

    @Benchmark
    public IntHashSet testAddAllEclipseIntHashSet() {
        var set = new IntHashSet();
        set.addAll(eclipseIntHashSourceSet);
        return set;
    }

    @Benchmark
    public UnifiedSet<Integer> testAddAllEclipseUnifiedSet() {
        UnifiedSet<Integer> set = new UnifiedSet<>();
        set.addAll(eclipseUnifiedSourceSet);

        return set;
    }
}
