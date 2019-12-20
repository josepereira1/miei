public class HotelDiscountTeste{
    
    public static void main(String[] args){
      
        Hotel h1 = new HotelDiscount();
        
        System.out.println(h1);
        Hotel h2 = h1.clone();
        System.out.println(h1.equals(h2));
        System.out.println(h1.getClass().getSimpleName());
    }
}
