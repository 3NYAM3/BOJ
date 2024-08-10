import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1013 {
    static int testCaseNum;
    static final String vega = "(100+1+|01)+";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCaseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCaseNum; i++){
            String testCase = br.readLine();

            if (testCase.matches(vega)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}

/*

@@@@@@@자바의 정규표현식@@@@@@@

^       문자열의 시작을 의미     만약 [^] 이렇게 대괄호 안에 있다면 부정의 의미([^a] : a를 제외한 문자1개)
$       문자열의 끝을 의미
?       바로 앞의 문자가 없거나 1개만 있거나
*       바로 앞의 문자가 없거나 있거나(여러개)
+       바로 앞의 문자가 하나 이상
{n}     바로 앞의 문자가 n개
{n, m}  바로 앞의 문자가 n개 이상 m개 이하
{n,}    바로 앞의 문자가 n개 이상
|       패턴 안에서 or 연산
()      하나의 문자로 인식
-       사이의 문자 혹은 숫자 [a-z] : a~z 의 문자 하나
\b      공백,탭, ",", "/" 등을 의미
\B      \b의 부정
\s      공백, 탭
\S      \s의 부정
\w      알파벳이나 숫자 [a-zA-Z_0-9]와 동일
\W      \w의 부정
\d      0~9의 숫자 [0-9]와 동일
\D      \d의 부정 [^0-9]
(?!)    대소문자구분 안함

*/
