package org.mzuri.scratchpad;

public class InnerClassTest {

        public static class Ship {
            private enum Sail {
                // w1
                TALL {protected int getHeight() {return
                        100;}},
                SHORT {protected int getHeight() {return 2;}};
                protected abstract int getHeight();

                Sail() {

                }

            }


            public Sail getSail() {
                return Sail.TALL;
            }
        }
        public static void main(String[] stars) {
            var bottle = new InnerClassTest();
            Ship q = new InnerClassTest.Ship(); // w2
            System.out.print(q.getSail());
        }
    }


