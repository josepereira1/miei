public class HotelPremiumTeste{
    
    public static void main(String[] args){
      
        Hotel h1 = new HotelPremium();
        
        System.out.println(h1);
        Hotel h2 = h1.clone();
        System.out.println(h1.equals(h2));
        System.out.println(h1.getClass().getSimpleName());
    }
}
