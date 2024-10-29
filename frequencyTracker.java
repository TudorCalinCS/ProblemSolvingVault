/*
Design a data structure that keeps track of the values in it and answers some queries regarding their frequencies.

Implement the FrequencyTracker class.

FrequencyTracker(): Initializes the FrequencyTracker object with an empty array initially.
void add(int number): Adds number to the data structure.
void deleteOne(int number): Deletes one occurrence of number from the data structure. The data structure may not contain number, and in this case nothing is deleted.
bool hasFrequency(int frequency): Returns true if there is a number in the data structure that occurs frequency number of times, otherwise, it returns false.
 

Example 1:

Input
["FrequencyTracker", "add", "add", "hasFrequency"]
[[], [3], [3], [2]]
Output
[null, null, null, true]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(3); // The data structure now contains [3]
frequencyTracker.add(3); // The data structure now contains [3, 3]
frequencyTracker.hasFrequency(2); // Returns true, because 3 occurs twice

Example 2:

Input
["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
[[], [1], [1], [1]]
Output
[null, null, null, false]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(1); // The data structure now contains [1]
frequencyTracker.deleteOne(1); // The data structure becomes empty []
frequencyTracker.hasFrequency(1); // Returns false, because the data structure is empty

Example 3:

Input
["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
[[], [2], [3], [1]]
Output
[null, false, null, true]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.hasFrequency(2); // Returns false, because the data structure is empty
frequencyTracker.add(3); // The data structure now contains [3]
frequencyTracker.hasFrequency(1); // Returns true, because 3 occurs once

 

Constraints:

1 <= number <= 105
1 <= frequency <= 105
At most, 2 * 105 calls will be made to add, deleteOne, and hasFrequency in total.
 */

import java.util.HashMap;

class FrequencyTracker {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> freqMap;

    public FrequencyTracker() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void add(int number) {
        int oldFreq = map.getOrDefault(number, 0);
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
           
            if (!freqMap.containsKey(map.get(number)))
                freqMap.put(map.get(number), 1);
            else
                freqMap.put(map.get(number), freqMap.get(map.get(number)) + 1);
        } else {
            map.put(number, 1);
            
            if (!freqMap.containsKey(1))
                freqMap.put(1, 1);
            else
                freqMap.put(1, freqMap.get(1) + 1);
        }
        if (freqMap.containsKey(oldFreq) && freqMap.get(oldFreq) == 1) {
            freqMap.remove(oldFreq);
        } else if (freqMap.containsKey(oldFreq))
            freqMap.put(oldFreq, freqMap.get(oldFreq) - 1);

    }

    public void deleteOne(int number) {
        int oldFreq = map.getOrDefault(number, 0);
        int currentFreq;
        if (map.containsKey(number)) {
            
            if (map.get(number) == 1) {
                map.remove(number);
                
                if (freqMap.get(1) == 1)
                    freqMap.remove(1);
                else
                    freqMap.put(1, freqMap.get(1) - 1);
                
                    currentFreq = map.getOrDefault(number, 0);
            } else {
                map.put(number, map.get(number) - 1);
                currentFreq = map.getOrDefault(number, 0);
                
                if (freqMap.get(oldFreq) == 1)
                    freqMap.remove(oldFreq);
                else
                    freqMap.put(oldFreq, freqMap.get(oldFreq) - 1);

                if (freqMap.containsKey(currentFreq))
                    freqMap.put(currentFreq, freqMap.get(currentFreq) + 1);
                else
                    freqMap.put(currentFreq, 1);
            }
        }

    }

    public boolean hasFrequency(int frequency) {
        if (freqMap.containsKey(frequency))
            return true;
        return false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */