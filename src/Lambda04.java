import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

            /*
        TASK :
        fields --> Universite (String)
                   bolum (String)
                   ogrcSayisi (int)
                   notOrt (int)
                   olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
         */

    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilg muh",1080,77);
        Universite u05 = new Universite("odtu","gemi mh",333,74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));

        System.out.println(matVarMi(unv));

        System.out.println();
        ogrSayisiBykKck(unv);

        System.out.println(ogrSayisiBykKck(unv));

        System.out.println();
        System.out.println(task4(unv));

        System.out.println();
        System.out.println(task5(unv));

        System.out.println();
        System.out.println(task6(unv));
    }

    //task 01--> bütün üniv.lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74BykUnv (List<Universite> unv){

        return unv.
                stream().
                allMatch(t-> t.getNotOrt()>74);

    }

    ////////////////////////////////

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matVarMi (List<Universite> unv){

       return unv.
               stream().
               anyMatch(t->t.getBolum().equalsIgnoreCase("matematik"));
    }


    //////////////////////

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayisiBykKck (List<Universite> unv){

        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()). // Universiteler ogr sayisina gore tersten siralandi
                collect(Collectors.toList());// stream yapisi List yapisina donusturuldu

    }

    ///////////////////////////////

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int task4 (List<Universite> unv){

        return (int) unv.
                stream().
                filter(t->t.getBolum().equalsIgnoreCase("matematik")).
                count();

    }

    /////////////////////////

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static Optional<Integer> task5 (List<Universite> unv){

      return unv.
              stream().
              filter(t->t.getOgrSayisi()>550).
              map(Universite::getNotOrt).
              reduce(Integer::max);

    }

    //////////////////////

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt task6(List<Universite> unv){

        return unv.stream().filter(t->t.getOgrSayisi()<1050).mapToInt(t->t.getNotOrt()).min();

    }

}
