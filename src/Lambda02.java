import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        printCiftVeKare(sayi);

        System.out.println();
        printTekVeKupArtiBir(sayi);

        System.out.println();
        maxElBul(sayi);

        System.out.println();
        printCiftKareEnbuyukSayi(sayi);

        System.out.println();
        tumElToplami(sayi);

        System.out.println();
        ciftElCarpimi(sayi);

        System.out.println();
        bestenBykTekKucuk(sayi);

        System.out.println();
        ciftKareKcktnByg(sayi);

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz





    public static void printCiftVeKare(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul). //listedeki çift sayıları filtreledim
                map(t->t*t). //16,4,36 -- map Stream icerisindeki elemanları baska degerlere donusturdu
                forEach(Lambda01::yazdir);

    }


    ////////////////////////////////////////

    // Task 2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir
    // fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static boolean tekBul(int a) {
        return a % 2 != 0;
    }

    public static void printTekVeKupArtiBir (List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda02::tekBul).
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);

    }

    ///////////////////////////////////////

            // Task-3 : Functional Programming ile listin cift elemanlarinin
            // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftlerinKarekoku (List<Integer>sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.println(t+" "));

    }

    //////////////////////////////////////////

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul (List<Integer>sayi){

        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); //Eğer benim resultım tek bir deger ise o zaman reduce terminal operator kullanilir
        System.out.println(maxSayi);

    }

    //////////////////////////

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void printCiftKareEnbuyukSayi (List<Integer>sayi){

        Optional<Integer> maxCiftKareSayi = sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t-> t*t).
                reduce(Integer::max); // Math::max'a göre daha hızlı çalışır

        System.out.println(maxCiftKareSayi);

    }

    /////////////////////////////////////

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void tumElToplami (List<Integer>sayi){

        int toplam = sayi.
                stream().
                reduce(0,(a,b)->a+b);

        System.out.println(toplam);

        /*
            * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
                bu örnekte 0 oluyor
            * b degerini her zamana  stream()'dan akısdan alır
            * a ilk degerinden sonraki her değeri action(işlem)'dan alır

         */

    }

    ////////////////////////////////////

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftElCarpimi (List<Integer>sayi){

        Optional<Integer> carpim = sayi.
                stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);

        System.out.println(carpim);

    }

    ///////////////////////////////////

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static void minBul(List<Integer>sayi){

        System.out.println(sayi.
                stream().
                reduce(Integer::min));

    }

    ///////////////////////////

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykTekKucuk (List<Integer>sayi){

        System.out.println(sayi.
                            stream().
                            filter(a -> a > 5 && a % 2 == 1).
                            reduce(Integer::min));

    }

    ////////////////////////////////

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareKcktnByg (List<Integer>sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                sorted().
                forEach(Lambda01::yazdir);

    }

}
