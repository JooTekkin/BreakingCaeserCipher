public class WordPlay {
    public boolean isVowel(char ch){
        String vowel = "aeiou";
        return vowel.contains(Character.toString(ch).toLowerCase());
    }

    public String replaceVowels(String phrase, char ch){
        StringBuilder input = new StringBuilder(phrase);
        for (int i = 0; i < input.length(); i++) {
            if(isVowel(input.charAt(i))){
                input.setCharAt(i,ch);
            }
        }
        return input.toString();
    }


    public String emphasize(String phrase, char ch){
        StringBuilder input = new StringBuilder(phrase);
        int index = input.indexOf(String.valueOf(ch));
        while (index != -1){
            if(index % 2 == 0){
                input.setCharAt(index,'*');
            } else {
                input.setCharAt(index,'+');
            }
            index = input.indexOf(String.valueOf(ch),index + 1);
        }

        return input.toString();
    }
}

class Main{
    public static void main(String[] args) {
        WordPlay wp = new WordPlay();
        System.out.println(wp.isVowel('a'));
        System.out.println(wp.replaceVowels("Hello World",'*'));
        System.out.println(wp.emphasize("Mary Bella Abracadabra",'a'));
    }
}