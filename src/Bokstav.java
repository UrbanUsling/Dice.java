public class Bokstav {
    public static void main(String[] args) {
        String s = "Hur många bokstäver n finns det i meningen?";
        s= s.toLowerCase();
        int x = 0;
        for(int i =0; i<s.length(); i++ ){
            if (s.charAt(i) == 'n'){
                System.out.println("n finns i index: " + i);
                x=x+1;
            }
        }
        System.out.println("Antal n är: "+ x);
    }
}
