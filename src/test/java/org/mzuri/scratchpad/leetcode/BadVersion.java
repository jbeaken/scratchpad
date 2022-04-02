package org.mzuri.scratchpad.leetcode;

public class BadVersion extends VersionControl {

    public static void main(String[] args) {
        final BadVersion badVersion = new BadVersion();
        badVersion.badVersionPosition = 4;

        assert badVersion.firstBadVersion(5) == 4;
    }

    public int firstBadVersion(int n) {

        int start = 0;
        int end = n;

        while(true) {
            if(start >= end) return start;
            int pos = n/2;
            if(isBadVersion( pos )) {
                end = pos;
            } else {
                if(isBadVersion( pos + 1)) {
                    return pos + 1;
                }
                start = pos;
            }
        }
    }
}

class VersionControl {
    public int badVersionPosition;

    boolean isBadVersion(int position) {
        return badVersionPosition == position ? true : false;
    }
}
