import edu.duke.FileResource;

public class CommonWords {

    public String[] getCommon(){
        FileResource commonFile = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String words : commonFile.words()){
            common[index] = words;
            index++;
        }

        return common;
    }


    public void ShakespeareCommon(){
        String[] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt"
                ,"romeo.txt","macbeth.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];

        for (String play : plays) {
            FileResource source = new FileResource("data/" + play);
            countWords(source, common, counts);
            System.out.println(play + " is done ");
        }

        for (int k = 0; k < common.length; k++) {
            System.out.println(common[k] + " = " + counts[k]);
        }
        
    }

    private void countWords(FileResource source, String[] common, int[] counts) {
        for(String words : source.words()){
            words = words.toLowerCase();
            int index = indexOf(common,words);
            if (index != -1){
                counts[index]++;
            }
        }
    }

    private int indexOf(String[] common, String words) {
        for (int i = 0; i < common.length; i++) {
            if(common[i].equals(words)){
                return i;
            }
        }
        return -1;
    }


}


class CommonWordsMain{
    public static void main(String[] args) {
        CommonWords commonWords = new CommonWords();
        commonWords.ShakespeareCommon();
    }
}
