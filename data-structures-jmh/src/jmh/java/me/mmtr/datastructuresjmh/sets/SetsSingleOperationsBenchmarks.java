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
public class SetsSingleOperationsBenchmarks {
    @Param({"100", "1000", "10000"})
    public int iterations;

    @Benchmark
    public Set<Integer> testAddRepeatedlyHashSet() {
        var set = new HashSet<Integer>();
        for (int i = 0; i < iterations; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public IntOpenHashSet testAddRepeatedlyFastutilIntOpenHashSet() {
        var set = new IntOpenHashSet();
        for (int i = 0; i < iterations; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public IntHashSet testAddRepeatedlyEclipseIntHashSet() {
        var set = new IntHashSet();
        for (int i = 0; i < iterations; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public UnifiedSet<Integer> testAddRepeatedlyEclipseUnifiedSet() {
        var set = new UnifiedSet<Integer>();
        for (int i = 0; i < iterations; i++) {
            set.add(i);
        }

        return set;
    }
}
