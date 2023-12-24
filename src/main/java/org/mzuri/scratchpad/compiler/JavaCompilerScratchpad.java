package org.mzuri.scratchpad.compiler;

import java.nio.ByteBuffer;

public class JavaCompilerScratchpad {

        public static void main(String[] args) {
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.flip();
            System.out.println("Baeldung: --release option test is successful");
        }
    }
