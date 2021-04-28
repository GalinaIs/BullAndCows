package ru.myproject.makenumber.checker;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.BullsCows;

import java.util.*;

@Component
public class CheckerStringImpl implements CheckerString {
    @Override
    public BullsCows checkString(String inputtedString, String expectedString) {
        Map<Character, List<Integer>> inputtedCharsetWithListIndexes = convertStringToCharsetWithListIndexes(inputtedString);
        Map<Character, List<Integer>> expectedCharsetWithListIndexes = convertStringToCharsetWithListIndexes(expectedString);
        BullsCows bullsCows = new BullsCows();
        for (Map.Entry<Character, List<Integer>> entry: inputtedCharsetWithListIndexes.entrySet()) {
            List<Integer> indexes = expectedCharsetWithListIndexes.get(entry.getKey());
            if (indexes != null) {
                BullsCows bullsAndCowsForOneLetter = bullsAndCowsForOneLetter(entry.getValue(), indexes);
                bullsCows.add(bullsAndCowsForOneLetter);
            }
        }
        return bullsCows;
    }

    private Map<Character, List<Integer>> convertStringToCharsetWithListIndexes(String string) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] letters = string.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int index = i;
            if (map.computeIfPresent(letters[i], (k, v) -> {
                v.add(index);
                return v;
            }) == null) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                map.put(letters[i], indexes);
            }
        }
        return map;
    }

    private BullsCows bullsAndCowsForOneLetter(List<Integer> indexes1, List<Integer> indexes2) {
        int bulls = 0;
        Iterator<Integer> iterator = indexes1.iterator();
        while (iterator.hasNext()) {
            Integer index = iterator.next();
            if (indexes2.contains(index)) {
                iterator.remove();
                indexes2.remove(index);
                bulls++;
            }
        }
        int cows = Math.min(indexes1.size(), indexes2.size());
        return new BullsCows(bulls, cows);
    }
}
