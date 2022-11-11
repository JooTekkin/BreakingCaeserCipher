public class CaesarCipher {

    public String encrypt(String input, int key){
        StringBuilder encrypt = new StringBuilder(input);
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sheftAlph = alph.substring(key) + alph.substring(0,key);
        for (int i = 0; i < encrypt.length(); i++) {
            char currChar = encrypt.charAt(i);
            int index;
            char newChar;
            if (Character.isLowerCase(currChar)){
                index = alph.toLowerCase().indexOf(currChar);
                if(index != -1){
                    newChar = sheftAlph.toLowerCase().charAt(index);
                    encrypt.setCharAt(i,newChar);
                }
            }else {
                index = alph.indexOf(currChar);
                if(index != -1){
                    newChar = sheftAlph.charAt(index);
                    encrypt.setCharAt(i,newChar);
                }
            }

        }
        return encrypt.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
         if (i % 2 == 0){
          str.append(encrypt(Character.toString(input.charAt(i)), key1));
         } else {
             str.append(encrypt(Character.toString(input.charAt(i)), key2));
         }
        }
        return str.toString();
    }

//class ending
}


class CaesarCipherMain{
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys("First Legion",23,17));
    }
}
