package org.mzuri.scratchpad.leetcode;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

public class BadVersionTest extends VersionControl {

    @ParameterizedTest
    @CsvSource("4, 10")
    void testVersion(int badVersionPosition , int numberOfVersions) {
        final BadVersion badVersion = new BadVersion();
        badVersion.badVersionPosition = badVersionPosition;

        final int i = badVersion.firstBadVersion(numberOfVersions);
        assert i == 4;
    }
}

class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {

        int start = 0;
        int end = n;

        while(start <= end) {
            int pos = start + ((end - start) / 2);   //mid position

            if(isBadVersion( pos )) {
                end = pos -1;
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
