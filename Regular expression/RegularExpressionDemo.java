import java.util.regex.*;
public class RegularExpressionDemo{
    public static void main(String[] args){
        Pattern p=Pattern.compile("ab*");
        System.out.println(p.matcher("a").matches());
        System.out.println(p.matcher("abcdefg").find());
        //System.out.println(p.matcher("ab").group(0));
        System.out.println(p.matcher("abcde").replaceAll("xy"));
    }
}