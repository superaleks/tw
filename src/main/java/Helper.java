import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    public static void main(String[] args) throws InterruptedException {
        String passphrase = "pause coconut bulk much stuff horror mystery modify army raccoon inject cost";
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