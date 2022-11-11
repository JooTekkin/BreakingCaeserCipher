public class CountAlph {
    public void counts(String phrase){
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] numsAlph = new int[26];
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = phrase.charAt(i);
            int index = alph.toLowerCase().indexOf(currChar);
            if(index != -1){
                numsAlph[index]++;
            }
        }
        for (int k = 0; k < numsAlph.length; k++) {
            if(numsAlph[k] > 0){
                System.out.println("Alph is = " + alph.charAt(k) + "  times = " + numsAlph[k]);
            }
        }
    }

}

class CountAlphMain{
    public static void main(String[] args) {
        CountAlph ca = new CountAlph();
        ca.counts("yusuf mustafa kamel");
    }
}