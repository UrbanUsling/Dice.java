import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class MiniräknareV2 {//klassen
    public static void main(String[] args) {//main
        DecimalFormat df = new DecimalFormat("###.##");//avrundning
        boolean rätt = true;//avgör om en beräkning genomförs. BLir false om ingen genomförs
        boolean negativ1 = false;//ifall första talet är negativt blir den true
        boolean negativ2 = false;//ifall andra talet är negativt blir den true
        int x = 0;
        double tal1 = 0;
        double tal2 = 0;//olika typer av variabler som kommer användas deklareras här
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv in ett matematiskt uttryck med ett av de fyra räknesätten");
        String helString = scan.nextLine();//hela skrivna raden läses och sparas som string
        helString = helString.trim();//trimmar mellanslag

        if (helString.isBlank()) {
            System.out.println("Du måste skriva något");
            System.exit(0);//stänger av direkt om det inte är nåt skrivet då inga fler fel kommer hittas
        }

        if (!Character.isDigit(helString.charAt(helString.length() - 1))) {
            System.out.println("Beräkningen måste sluta med en siffra och inget annat");
            rätt = false;//sista tecknet är ej ett tal, så ingen beräkning kommer ske
        }
        if (helString.indexOf('-') < 0 && helString.indexOf('+') < 0 && helString.indexOf('*') < 0 && helString.indexOf('/') < 0) {
            System.out.println("Innehåller ingen operator för beräkning");
            rätt = false;//inga operander i stringen. ingen beräkning sker
        }
        for (int i = 0; i < helString.length(); i++) {
            if (!Character.isDigit(helString.charAt(i)) && helString.charAt(i) != '-' && helString.charAt(i) != '+' &&
                    helString.charAt(i) != '*' && helString.charAt(i) != '/' && helString.charAt(i) != '.') {
                rätt = false;
                System.out.println("Kan inte innehålla bokstäver eller otillåtna tecken");
                break;//bokstäver eller otillåtna tecken. ingen beräkning sker
            }
        }
        if (helString.charAt(0) == '-' && Character.isDigit(helString.charAt(1))) {
            negativ1 = true;
            helString = helString.substring(1);//första siffran är negativ. boolean ändras. tecknet skalas bort
        } else if ((helString.charAt(1) == '-' || helString.charAt(1) == '+' || helString.charAt(1) == '/'
                || helString.charAt(1) == '*') && !Character.isDigit(helString.charAt(0))) {
            System.out.println("För många operatorer efter varandra framför första uttrycket");
            rätt = false;//för många operatorer framför första operanden. ingen beräkning sker
        } else if (helString.charAt(0) == '+' || helString.charAt(0) == '/' || helString.charAt(0) == '*') {
            System.out.println("Kan ej börja med en sådan operator");
            rätt = false;//otillåten första operator. ingen beräkning sker

        }

        while (!Character.isDigit(helString.charAt(0))) {
            helString = helString.substring(1);
            if (helString.isBlank()) {
                System.out.println("Det finns inga tal i uttrycket");
                System.exit(0);
                //kontroll om det finns siffror över huvud taget. om inga så stängs programmet då ej fler fel kan hittas
            }
        }

        String stringTal1 = TalBeräkning(helString);//metoden talberäkning anropas för att plocka ut första operanden
        if (!Objects.equals(stringTal1.indexOf('.'), stringTal1.lastIndexOf('.'))) {
            System.out.println("Första operanden innehåller flera decimaltecken");
            rätt = false;//om operanden har två kommatecken så sker ingen beräkning
        } else
            tal1 = Double.parseDouble(stringTal1);//stringen görs om till en int
        if (negativ1)
            tal1 = tal1 * (-1);//om första tecknet var negativt så görs nu talet negativt

        if (helString.equals(stringTal1)) {
            System.out.println("Ingen andra operand finns");
            System.exit(0);
            //kontroll ifall stringen bara är en operand. Stängs av ifall så är fallet då fler fel ej kan hittas
        }


        String halvString = helString.substring(stringTal1.length() + 1);
        //det finns mer på stringen, så första beräknade operanden kapas bort samt det första efterföljande tecknet
        if (halvString.isBlank()){
            System.out.println("Ingen andra operand finns");
            System.exit(0);
        }//om det inte finns mer efter det första efterföljande tecknet så avslutas programmet då fler fel ej hittas

        String sTest = halvString;
        while (!Character.isDigit(sTest.charAt(0))) {
            sTest = sTest.substring(1);
            if (sTest.isBlank()) {
                System.out.println("Ingen andra operand finns");
                System.exit(0);
            }
        }
        //en teststring bara för att kontrollera att det finns siffror efter det första efterföljande tecknet
        if (halvString.charAt(0) == '-' && Character.isDigit(halvString.charAt(1))) {
            negativ2 = true;
            halvString = halvString.substring(1);
            //negativ2=true om negativ andra operand. skalar bort minustecknet
        } else if (halvString.charAt(0) == '-' && (halvString.charAt(1) == '-' || halvString.charAt(1) == '+'
                || halvString.charAt(1) == '/' || halvString.charAt(1) == '*')) {
            System.out.println("För många operatorer mellan operanderna");
            rätt = false;//för många operatorer mellan operanderna så ingen beräkning genomförs
        } else if (halvString.charAt(0) == '+' || halvString.charAt(0) == '/' || halvString.charAt(0) == '*') {
            System.out.println("För många operatorer mellan operanderna");
            rätt = false;//samma fall som ovan
        }
        String stringTal2 = TalBeräkning(halvString);//metoden talberäkning anropas för att få fram andra operanden

        if (!Objects.equals(stringTal2.indexOf('.'), stringTal2.lastIndexOf('.'))) {
            System.out.println("Andra operanden innehåller flera decimaltecken");
            rätt = false;//ifall 2 decimaltecken så sker ingen beräkning
        } else
            tal2 = Double.parseDouble(stringTal2);//gör om stringen till en int
        if (negativ2)
            tal2 = tal2 * (-1);//gör operanden negativ ifall det var minustecken framför


        if (!stringTal2.equals(sTest) && rätt) {//test för att se om det är för många operander. Ska vara max 2
            if (sTest.indexOf('-') > 0 || sTest.indexOf('+') > 0 || sTest.indexOf('*') > 0 || sTest.indexOf('/') > 0) {
                String stringTal3 = TalBeräkning(sTest.substring(stringTal2.length() + 1));
                if (!stringTal3.isBlank() && Objects.equals(stringTal3.indexOf('.'), stringTal3.lastIndexOf('.')))
                    System.out.println("För många beräkningar");//för många operander. för många beräkningar
                else if (!stringTal3.isBlank())//för många beräkningar och den 3:e har dessutom för många decimaler
                    System.out.println("För många beräkningar och för många decimaler i extra beräkningen");
            }
        }

        if (!rätt)
            System.exit(0);
        //om något av felen har aktiverats fram till nu så kommer ingen beräkning ske och programmet avslutas


        if (helString.charAt(stringTal1.length()) == '+')
            x = 1;
        else if (helString.charAt(stringTal1.length()) == '-')
            x = 2;
        else if (helString.charAt(stringTal1.length()) == '*')
            x = 3;
        else if (helString.charAt(stringTal1.length()) == '/')
            x = 4;
        /*Ovan kontrolleras var det var för tecken som var i plats stringtal1.lenght. Vi vet att det inte
        var en siffra då metoden talberäkning kapade just framför. om rätt=true så måste det vara ett av
        de fyra räknesätten. Vi tilldelar variablen x en siffra beroende på vilken operator det är.
         */
        if (Objects.equals(halvString, stringTal2) && x == 1)
            System.out.println("Summan blir: " + df.format(tal1 + tal2));
        else if (Objects.equals(halvString, stringTal2) && x == 2)
            System.out.println("Summan blir: " + df.format(tal1 - tal2));
        else if (Objects.equals(halvString, stringTal2) && x == 3)
            System.out.println("Produkten blir: " + df.format(tal1 * tal2));
        else if (Objects.equals(halvString, stringTal2) && x == 4) {
            if (tal2 == 0)
                System.out.println("Division med 0 ej möjligt");
            else
                System.out.println("Kvoten blir: " + df.format(tal1 / tal2));
        }/*bara om halvsträngen är samma som strängtal2 genomförs beräkningen.
        Ett eventuellt minustecken efter operatorn mellan operanderna har redan skalats bort
        och ingen beräkning ska ju ske ifall det finns någonting som helst efter den andra operanden*/
    }

    private static String TalBeräkning(String s) {
        StringBuilder t = new StringBuilder();
        while (!Character.isDigit(s.charAt(0))) {
            s = s.substring(1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
                t.append(s.charAt(i));
            } else
                break;
        }
        return String.valueOf(t);
    }/*metoden för operandberäkningen. Skalar bort allting som inte är en siffra i början.
    När väl första siffran i stringen har hittats så skapas en ny string där denna siffra och varje
    efterföljande siffra eller "." tecken läggs på. Så fort det kommer ett tecken som inte motsvarar dessa
    så bryts for-loopen och den erhållna stringen motsvarar då operanden
    */

}