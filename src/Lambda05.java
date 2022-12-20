import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5));

        System.out.println(toplaFunctional(5));

        System.out.println(task02(5));

        System.out.println(task03(4));

        System.out.println(task04(4));

       task05(3);

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile,
    // 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    public static int topla (int x){

        int toplam =0;
        for (int i=0; i<=x;i++){

            toplam=toplam+i;

        }
        return toplam;
    }

    public static int toplaFunctional (int x){

       return IntStream. //int bir akış sağladık böylece int ile ilgili methodlar geldi
               range(1,x+1). // range(a,b)--> a'dan b'ye kadar (b dahil değil) olan int degerler akisa alindi
               sum(); //akisdan gelen degerler toplandi



    }

    //////////////////////////////
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int task02 (int x){

        return IntStream.
                range(1,x+1).
                filter(t->t%2==0).
                sum();
    }

    //////////////////////////////
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int task03(int x){

        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();

    }

    //2. way
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2, t->t+2). // 2 den sonsuza kadar elemanları 2 artırarak akışı alır
                limit(x).//x ile sınırlıyorum
                sum(); // akışdan gelen bütün degerleri topluyorum
    }

    //////////////////////////////////
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int task04(int x){

        return IntStream.
                iterate(1,t->t+2).
                limit(x).
                sum();

    }

    /////////////////////
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void task05 (int x){

       IntStream.
               iterate(2,t->t*2).
               limit(x).
               forEach(t-> System.out.print(t + " "));

    }

    /////////////////
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.


}
