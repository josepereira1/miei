package socios.testes;

import socios.business.Quota;
import socios.business.SGS;
import socios.business.Socio;

import java.time.LocalDate;
import java.util.HashMap;

public class SGSTeste {

    public static void main(String[] args){
        Socio s1 = new Socio("José", "A82880", "21", 'M', new HashMap<String,Quota> ());
        Socio s2 = new Socio(s1);
        Socio s3 = new Socio("Ricardo", "A82881", "20", 'M', new HashMap<String,Quota> ());
        
        SGS sgs = new SGS(new HashMap<String, Socio>(), "0");
        sgs.add(s1);
        sgs.add(s2);
        
        System.out.println(sgs.contains(s3));
    }
}
