package org.mzuri.scratchpad.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracket {

    public String evaluate(String s, List<List<String>> knowledge) {

        StringBuilder output = new StringBuilder();
        StringBuilder lookupKey = new StringBuilder();

        boolean isInsideKeyLookup = false;
        int pos = 0;

        Map<String, String> lookupMap = new HashMap<>();
        for (List<String> knowledgeEntry : knowledge) {
            lookupMap.put(knowledgeEntry.get(0), knowledgeEntry.get(1));
        }

        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == '(') {
                isInsideKeyLookup = true;
                pos++;
                continue;
            }

            if (c == ')' && isInsideKeyLookup) {
                String replacement = lookupMap.get(lookupKey.toString());
                replacement = replacement != null ? replacement : "?";
                output.append(replacement);
                lookupKey = new StringBuilder();
                pos++;
                isInsideKeyLookup = false;
                continue;
            }

            if (isInsideKeyLookup) {
                lookupKey.append(c);
            } else {
                output.append(c);
            }

            pos++;
        }

        return output.toString();

    }
}