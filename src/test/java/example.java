import java.sql.SQLOutput;

public class example {

    public static String reverseStr(String string){

        StringBuilder stb = new StringBuilder(string);

        return  stb.reverse().toString();

    }

    public static String reverseStr2(String string){

        String reverse ="";
        for(int i=string.length()-1; i>=0;i--){
            reverse += string.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args) {

        System.out.println(example.reverseStr2("Techtorial"));
        System.out.println(example.reverseStr("Techtorial"));
    }
}


