
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

import static java.time.LocalDateTime.now;

public void main() throws Exception {

    System.out.println(STR."\{ now() } Started");
    Thread.sleep(5000);

    ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
    System.out.println(STR."\{ now() } Allocated (Direct)");
    Thread.sleep(5000);

    try (Arena arena = Arena.ofConfined()) {
        MemorySegment segment = arena.allocate(4L * 1024L * 1024L * 1024L);
        System.out.println(STR."\{ now() } Allocated (FMI)");
        Thread.sleep(5000);
    }

    buffer = null;
    System.out.println(STR."\{ now() } Deallocated");
    Thread.sleep(5000);
}
