import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by youngman on 2018-12-17.
 */
public class main {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("geonyoung", "youngjun", "chunso", "younsang");

        //기존 코드
        long count = 0;
        for (String name : names) {
            if (name.equals("youngjun"))
                count++;
        }

        System.out.println(count);

        count = 0;

        //중개연산1. 필터링-조건에 맞는 것만 거른다
        //Collection같은 객체집합.스트림생성().중개연산().최종연산()
        count = names.stream().filter(x -> x.equals("youngjun")).count();
        System.out.println(count);


        //중개연산2. Map-스트림의 각 요소 연산에 사용
        names.stream().map((x) -> {
            return x.concat("-sku");
        }).forEach(x -> System.out.println(x));


        //최종연산1. Foreach-map이나 peek의 최종연산, 각요소의 처리
        //(param)->{ }
        names.stream().map((x) -> {
            return x.length();
        }).forEach(x -> System.out.println(x));


        //최종연산2. Collectors.toList() -> Stream에서 작업한 결과를 담은 리스트로 반환, 종료작업이다.
        names = names.stream().map((x) -> {
            return x.concat("-sku");
        }).collect(Collectors.toList());
        //출력
        names.stream().forEach(x -> System.out.println(x));


        //Optional of
        Optional<String> opt1 = Optional.of("Null이 아닌 객체를 담는 Optional 객체 생성");
        System.out.println(opt1.get());


        //Optional ofNullable
        Optional<String> opt2 = Optional.ofNullable("Null인지 아닌지 확실할 수 없는 객체를 담는 Optional 객체 생성");
        System.out.println(opt2.get());


        //null체크
        opt1 = Optional.empty();
        if (opt1.isPresent()) {//true
            System.out.println("null이 아니다");
        } else //false
            System.out.println("null");


        /*
         *Optional은 null처리를 직접하지 않고 Optional클래스에 위임하기 위한것이다
         *Optional을 위와같이 코딩하면 기존 null체크와 차이가 없다
         *null을 대하는 방식을 조건문이 아닌 함수형사고로 바꾸자
         */
        opt1 = Optional.empty();
        String opt3 = opt1.orElse(new String("null이다"));
        System.out.println(opt3);

        opt3 = opt2.orElse(new String("null이다"));
        System.out.println(opt3);

    }

}
