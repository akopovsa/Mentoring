package module6.citizen;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindCitizen {

    private static Map<Passport,Citizen> profile = new HashMap<Passport,Citizen>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindCitizen that = (FindCitizen) o;
        return Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile);
    }

    private static void findByPassport(Passport passport){
        Citizen citizen =  profile.get(passport);
        System.out.println("Search result: "+"\n" + "Name: "+citizen.getName()+"\n"+"Surname: "+citizen.getSurname()+"\n" + "Passport: "+ passport.getSeries()+ " "+ passport.getNumber());
        System.out.println("============================");
    }

    public static void main (String[] args){
        Citizen c1 = new Citizen("Clark","Kent");
        Passport p1 = new Passport("KB", 111111);
        Citizen c2 = new Citizen("Jack","Daniels");
        Passport p2 = new Passport("CB", 222222);
        Citizen c3 = new Citizen("Bruce","Wayne");
        Passport p3 = new Passport("BA", 3333333);

        profile.put(p1,c1);
        profile.put(p2,c2);
        profile.put(p3,c3);

        findByPassport(p1);
        findByPassport(p2);
    }


}
