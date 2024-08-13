import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str,"0");
        int zeroCount = st.countTokens();

        st = new StringTokenizer(str,"1");
        int oneCount = st.countTokens();

        System.out.println(Math.min(oneCount, zeroCount));

    }
}
