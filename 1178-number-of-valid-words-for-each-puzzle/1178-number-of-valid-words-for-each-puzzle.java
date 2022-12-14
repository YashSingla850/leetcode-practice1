class Solution {
    private int bitmask(String word) {
        // Build a bitmask of chars to represent each word
        // the builtin std::bitset also works
        int mask = 0;
        for (char letter : word.toCharArray()) {
            mask |= 1 << (letter - 'a');
        }
        return mask;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCount = new HashMap<>(); // a vector instead of unordered_map also works
        for (String word : words) {
            int mask = bitmask(word);
            wordCount.put(mask, wordCount.getOrDefault(mask, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int first = 1 << (puzzle.charAt(0) - 'a');
            int count = wordCount.getOrDefault(first, 0);

            // Make bitmask but ignore the first character since it must always be there.
            int mask = bitmask(puzzle.substring(1));

            // iterate over the submask
            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                count += wordCount.getOrDefault(submask | first, 0); // add first character
            }
            result.add(count);
        }
        return result;
    }
};



// class Solution {
//     public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//         HashMap<Character, ArrayList<Integer>>map = new HashMap<>();
//         List<Integer>ans = new ArrayList<>();
//         for(int i= 0;i<26 ; i++){
//             map.put((char)('a'+i) , new ArrayList<>());
//         }
//         for(String word : words){
//             int mask =0 ;
//             for(char ch: word.toCharArray()){
//                 int bit = ch-'a';
//                 mask = mask|(1<<bit);
//             }
//             HashSet<Character> uq = new HashSet<>();
//             for(char ch : word.toCharArray()){
//                 if(uq.contains(ch)){
//                     continue;
//                 }
//                 uq.add(ch);
//                 map.get(ch).add(mask);
//             }
//         }
// //          puzzles 
//          for(String puzzle : puzzles){
//             int pmask =0 ;
//             for(char ch: puzzle.toCharArray()){
//                 int bit = ch-'a';
//                 pmask = pmask|(1<<bit);
//             }
//              char fch  = puzzle.charAt(0);
//              ArrayList<Integer>temp  = map.get(fch);
//              int count = 0;
//              for(int wmask : temp){
//                  if((wmask &pmask)==wmask){
//                      count++;
//                  }
//              }
//              ans.add(count);
//          }
//         return ans;
//     }
// }