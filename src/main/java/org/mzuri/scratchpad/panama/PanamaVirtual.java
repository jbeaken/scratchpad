package org.mzuri.scratchpad.panama;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.MemorySegment;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static java.lang.foreign.ValueLayout.*;

public class PanamaVirtual {

    static Linker LINKER = Linker.nativeLinker();
    static SymbolLookup STDLIB = LINKER.defaultLookup();

    public static void main(String[] args) throws Throwable {
        strlen();
        strlen_virtual();
        qsort();
        printf();
    }

    public static void strlen() throws Throwable {
        MethodHandle strlen = LINKER.downcallHandle(
                STDLIB.find("strlen").get(),
                FunctionDescriptor.of(JAVA_LONG, ADDRESS)
        );

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment hello = arena.allocateFrom("Hello");
            long len = (long) strlen.invokeExact(hello); // 5
            System.out.println(len);
        }
    }

    public static void strlen_virtual() throws Throwable {
        MethodHandle strlen_virtual = LINKER.downcallHandle(
                FunctionDescriptor.of(JAVA_LONG, ADDRESS)
        );

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment hello = arena.allocateFrom("Hello");
            long len = (long) strlen_virtual.invokeExact(
                    STDLIB.find("strlen").get(),
                    hello); // 5
            System.out.println(len);
        }
    }

    static class Qsort {
        static int qsortCompare(MemorySegment addr1, MemorySegment addr2) {
            return addr1.get(JAVA_INT, 0) - addr2.get(JAVA_INT, 0);
        }
    }

    public static void qsort() throws Throwable {
        MethodHandle qsort = LINKER.downcallHandle(
                STDLIB.find("qsort").get(),
                FunctionDescriptor.ofVoid(ADDRESS, JAVA_LONG, JAVA_LONG, ADDRESS)
        );
        FunctionDescriptor comparDesc = FunctionDescriptor.of(JAVA_INT,
                ADDRESS.withTargetLayout(JAVA_INT),
                ADDRESS.withTargetLayout(JAVA_INT));
        MethodHandle comparHandle = MethodHandles.lookup()
                .findStatic(Qsort.class, "qsortCompare",
                        comparDesc.toMethodType());

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment comparFunc = LINKER.upcallStub(
                    comparHandle, comparDesc, arena);

            MemorySegment array = arena.allocateFrom(JAVA_INT, 0, 9, 3, 4, 6, 5, 1, 8, 2, 7);
            qsort.invokeExact(array, 10L, 4L, comparFunc);
            int[] sorted = array.toArray(JAVA_INT); // [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
            System.out.println(Arrays.toString(sorted));
        }
    }

    public static void printf() throws Throwable {
        MethodHandle printf = LINKER.downcallHandle(
                STDLIB.find("printf").get(),
                FunctionDescriptor.of(JAVA_INT, ADDRESS, JAVA_INT, JAVA_INT, JAVA_INT),
                Linker.Option.firstVariadicArg(1) // first int is variadic
        );
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment s = arena.allocateFrom("%d plus %d equals %d\n");
            int res = (int) printf.invokeExact(s, 2, 2, 4);
        }
    }
}