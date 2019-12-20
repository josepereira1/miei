import java.util.Iterator;

public class HoteisIncTeste
{
    public static void main(String[] args){
      
        HoteisInc hi1 = new HoteisInc();
        System.out.println("hi1 = " + hi1);
        HoteisInc hi2 = hi1.clone();
        System.out.println("hi2 = " + hi2);
        System.out.println("hi1.equals(hi2) = " + hi1.equals(hi2));
        
        Hotel h1 = new HotelStandard("12345", "hotel standard", "Braga", 3, 125, 100, false, 1);
        Hotel h2 = new HotelPremium("12346", "hotel premium", "Braga", 4, 90, 200, 2, 0.15);
        Hotel h3 = new HotelPremium("12347", "hotel premium", "Porto", 5, 300, 375, 2, 0.27);
        hi1.adiciona(h1);
        hi1.adiciona(h2);
        hi1.adiciona(h3);
        System.out.println("hi1 = " + hi1);
        System.out.println("hi1.quantos(Braga) = " + hi1.quantos("Braga"));
        System.out.println("hi1.quantos() = " + hi1.quantos());
        System.out.println("hi1.existeHotel(12347) = " + hi1.existeHotel("12347"));
        System.out.println("hi1.quantosT(HotelPremium) = " + hi1.quantosT("HotelPremium"));
        System.out.println("hi1.quantosT(HotelStandard) = " + hi1.quantosT("HotelStandard"));
        hi1.mudaPara();
        System.out.println("hi1 = " + hi1);
        System.out.println("hi1.valorTotal() = " + hi1.valorTotal());
        System.out.println("TreeSet<Hotel> ordenados = " + hi1.ordenarHoteis());
        
        System.out.println("\n\nIterator----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        Iterator<Hotel> it = hi1.ordenarHoteis("qualquer coisa");
        while(it.hasNext()){
            Hotel h = it.next();
            System.out.println(h + "\n");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
    }
}