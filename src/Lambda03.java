import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec","küşleme","arabAşı","waffle","künefe"));



        alfBykTekrsz(menu);
        System.out.println();
        taskIki(menu);
        System.out.println();
        taskUc(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        System.out.println();
        task5(menu);
        System.out.println();
        task6(menu);
        System.out.println();
        task7(menu);
        System.out.println();
        task8(menu);

    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> menu){

        menu.
                stream(). // akış başladı
                map(String::toUpperCase). //map ile buyuk harf
                sorted(). // doğal sıralama (alfabetik)
                distinct(). //elemanların tekrarsız unique olmasını sağladı
                forEach(t-> System.out.print(t + " ")); //print

    }

    ////////////////////////////////////

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void taskIki (List<String> menu){

        menu.
                stream().//akis alindi
                map(String::length). //akisi elemanlarin uzunlugu olarak güncelledik
                sorted(Comparator.reverseOrder()). // tersten siraladik
                distinct(). // elemanlari tekrarsiz olmasını sagladi
                forEach(t-> System.out.print(t + " ")); //print

    }

    ///////////////////////////////////////

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void taskUc (List<String> menu){

        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t-> System.out.print(t + " "));

    }

    /////////////////////////////////////////////////

    // Task-4 : List elelmmalarinin hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> menu){

        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harften olusuyor" : "List elemanlari 7 harften uzun");

    }

    ///////////////////////////////////////////////

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void task5 (List<String> menu){

        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? " w ile baslayan yemek hiç yok" : "w ile baslayan yemek var ");

    }

    //////////////////////////////////////////

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mı kontrol ediniz.

    public static void task6 (List<String> menu){

        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "x ile biten en az bir eleman var" : "x ile biten hic eleman yok");

    }

    //////////////////////////////////

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void task7 (List<String> menu){

        Stream<String> enUzunEl = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).// En uzundan en kisaya siralandi
                        limit(1);// sadece en bastaki yani en uzununu getir

        System.out.println(Arrays.toString(enUzunEl.toArray()));


    }

    ///////////////////////////////////////////////

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void task8 (List<String> menu){

        menu.
                stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).
                skip(1).
                forEach(t-> System.out.print(t + " "));

    }



}
