package socios.testes;

import socios.business.Quota;

import java.time.LocalDate;

public class QuotaTeste {

    public static void main(String[] args){
        Quota q1 = new Quota(LocalDate.now(),5,"1");
        Quota q2 = new Quota(LocalDate.now(),5,"2");
        Quota q3 = new Quota(q1);

        System.out.println(q1.equals(q3));
    }
}
