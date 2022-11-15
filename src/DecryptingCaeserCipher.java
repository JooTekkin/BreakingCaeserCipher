public class DecryptingCaeserCipher extends CaesarCipher{

    public int[] countLetters(String phrase){
        String alph = "ABCDEFJHIJKLMNOPQRSTUVWXYZ";
        int[] lett = new int[26];
        phrase = phrase.toUpperCase();
        for (int i = 0; i < phrase.length(); i++) {
            int index = alph.indexOf(phrase.charAt(i));
            if(index != -1){
                lett[index]++;
            }
        }
        return lett;
    }


    public String decrypt(String message){
        int[] freqs = countLetters(message);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if(maxDex < 4){
            dKey = 26 - (4 - maxDex);
        }
        return encrypt(message,26 - dKey);
    }

    private int maxIndex(int[] freqs) {
        int maxIndex = 0;
        for (int i = 0; i < freqs.length; i++) {
            if(freqs[i] > freqs[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
//01234567
    public String halfOfString(String message, int start){
        StringBuilder answer = new StringBuilder();
        for (int i = start; i < message.length(); i+=2) {
            if(i % 2 == 0){
                answer.append(message.charAt(i));
            } else {
                answer.append(message.charAt(i));
            }
        }
        
        return answer.toString();
    }


    public int getKey(String s){
        int[] counts = countLetters(s);
        int index = maxIndex(counts);
        int key = index - 4;
        if(index < 4){
            key = 26 - (4 - index);
        }
        return key;
    }


    public String decryptTwoKeys(String encrypted){
        String phrase = halfOfString(encrypted,0);
        int firstKey = getKey(phrase);
        phrase = halfOfString(encrypted,1);
        int secondKey = getKey(phrase);
        System.out.println("Key1 = " + firstKey + " key2 = " + secondKey);
        return encryptTwoKeys(encrypted,26-firstKey,26-secondKey);
    }
}

class DecryptingCaeserCipherMain{
    public static void main(String[] args) {
        DecryptingCaeserCipher dcc = new DecryptingCaeserCipher();
        //encrypt the phrase
        String txt = dcc.encrypt("yusuf mustafa kamel , eeeeeee",16);
        System.out.println(txt);
        //decrypt the phrase
        String txt2 = dcc.decrypt(txt);
        System.out.println(txt2);
        System.out.println("Key = " + dcc.getKey(txt));
        //encrypt the phrase by two keys
        String txt3 = dcc.encryptTwoKeys("yusuf mustafa kamel , eeeeeee",16,12);
        System.out.println(txt3);
        //decrypt the phrase by two keys
        String txt4 = dcc.decryptTwoKeys(txt3);
        System.out.println(txt4);


    }
}
