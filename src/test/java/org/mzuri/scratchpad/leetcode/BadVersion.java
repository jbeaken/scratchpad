package org.mzuri.scratchpad.leetcode;

public class BadVersion extends VersionControl {

    public static void main(String[] args) {
        final BadVersion badVersion = new BadVersion();
        badVersion.badVersionPosition = 4;

        final int i = badVersion.firstBadVersion(5);
        assert i == 4;
    }

    public int firstBadVersion(int n) {

        int start = 0;
        int end = n;

        while(start < end) {
            int pos = start + ((end - start) /2);

            if(isBadVersion( pos )) {
                end = pos;
            } else {
                start = pos + 1;
            }
        }

        return start;
    }
}

class VersionControl {
    int badVersionPosition;

    boolean isBadVersion(int position) {
        return badVersionPosition <= position ? true : false;
    }
}
