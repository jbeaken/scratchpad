package org.mzuri.algorithms.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Briefly describe your approach for solving this code problem
//What is the run timcat complexity of your solution for this code question

//You are working for a telecommunications company that is trying to upgrade junction boxes

//All the junction boxes are identified by an alphanumeric identifier, followed by a space delmited
//version infomration. The older generation uses space delimited lowercase English strings to identity the version,
//but the newer generatio uses space delimiteed positive integers to identity the version.

// sort by
// 1 Older first, ties sorted by version
//newer generation should be in same order as appear in list
public class JunctionBoxes {

      public static void main(String[] args) {

          List<String> list = Arrays.asList("az0 first qpx", "jkc 82 01", "eo first qpx", "234 cat dog rabbit snake", "az0 first qpx", "06f 12 25 6", "09z cat hamster");

          List<String> results = list.stream()
                  .map(JunctionBoxInfo::new)
                  .filter(JunctionBoxInfo::isNewer)
                  .sorted(Comparator.comparing(JunctionBoxInfo::getVersion))
                  .map(JunctionBoxInfo::getFull)
                  .collect(Collectors.toList());

          List<String> newer = list.stream()
                  .map(JunctionBoxInfo::new)
                  .filter(j -> j.isNewer() == false)
                  .map(JunctionBoxInfo::getFull)
                  .collect(Collectors.toList());

          results.addAll(newer);





      }

        static class JunctionBoxInfo {
          private String full;
          private String version;
          private boolean isNewer;
          private String identifier;

            JunctionBoxInfo(String s) {

                setFull(s);

                int index = s.indexOf(" ");


                setIdentifier(s.substring(0, index));

                setVersion(s.substring(index));

                setNewer(true);

                try {
                    Integer.parseInt(getVersion().replace(" ", ""));
                } catch (NumberFormatException e) {
                    setNewer(false);
                }

            }

           public String getFull() {
                return full;
            }

            public void setFull(String full) {
                this.full = full;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public boolean isNewer() {
                return isNewer;
            }

            public void setNewer(boolean newer) {
                isNewer = newer;
            }

            public String getIdentifier() {
                return identifier;
            }

            public void setIdentifier(String identifier) {
                this.identifier = identifier;
            }
        }

    }

