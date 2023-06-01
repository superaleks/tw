import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    public static void main(String[] args) throws InterruptedException {
        String passphrase = "jelly ceiling absent erode cart curious wrong honey canvas bracket tray few";
        System.out.println(extractPassPhrase(passphrase));

    }


    public static List<String> extractPassPhrase(String str) {
        List<String> list = new ArrayList<String>(Arrays.asList(str
                .split("[,\\s+]")));
        list.removeIf(s -> s.isEmpty()
                || !s.chars().allMatch(Character::isAlphabetic));
        return list;
    }

}