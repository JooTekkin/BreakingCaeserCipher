import edu.duke.FileResource;

public class WordLengths {

    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        int[] numsWord = countWordLengths(resource,counts);
        int position = indexOfMax(numsWord);
        for (int i = 0; i < numsWord.length; i++) {
            if(numsWord[i] != 0) {
                System.out.println(numsWord[i] + " Words of length " + i);
            }
        }
        System.out.println("most Length = " + position);
    }

    private int[] countWordLengths(FileResource resource, int[] counts) {
        for(String words : resource.words()){
            boolean firstChar = Character.isLetter(words.charAt(0));
            boolean lastChar = Character.isLetter(words.charAt(words.length()-1));
            if((firstChar && !lastChar) || (!firstChar && lastChar) ){
                counts[words.length()-1]++;
            } else {
                counts[words.length()]++;
            }
        }
        return counts;
    }


    public int indexOfMax(int[] values){
        int mostLength = 0;
        for(int length : values){
         if(length > mostLength){
             mostLength = length;
         }
        }
        return mostLength;
    }
}


class WordLengthsMain {
    public static void main(String[] args) {
        WordLengths wl = new WordLengths();
        wl.testCountWordLengths();
    }
}
