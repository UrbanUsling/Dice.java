class Slacker {
    double energi = 10;
    private double sömn = 10;
    private double mat = 5;

    boolean liv = true;
    public void sov(){
        if (energi <= 5)
            energi = energi +sömn;
        else
            System.out.println("Kan inte sova så snart. Njut av dagsaktiviteter!");
    }
    public void ät(){
        if (energi <= 5)
            energi = energi +mat;
        else
            System.out.println("Kan inte äta nu. Magen är full än. Njut av dagsaktiviteter!");
    }

    public double getEnergi(){
        return energi;
    }
    public void promenad(double km){
        if (km >0 && km <= 5 && energi >= km)
            energi = energi - km;
        else if (km>5)
            System.out.println("Slacker kan bara gå max 5km");
        else if (km<=0)
            System.out.println("Måste vara större än 0");
        else if (km<=5 && energi <= km ){
            System.out.println("Din energi tog slut och du kollapsade under pomenaden. Vila ut och ta nya tag imorrn!");
            energi = energi - km;
            liv = false;
        }
    }
    public void partnersKlagande(double tid){
        if (tid<=0)
            System.out.println("Partnern måste klaga minst 1 minut");
        else if (tid <= 60){
            energi = energi/2;
            System.out.print("Även 1 minut av klagande kan kännas som en timme och tar halva din energi");
        }
        else{
            energi = 0;
            liv=false;
            System.out.println("Att lyssna på över en timmes klagande tar slut på allas energi. Lägg dig och sov nu");
        }
    }
}

class Athlete extends Slacker{
    public void träna(double tid){
        if (tid < 20)
            System.out.println("Måste träna minst 20min");
        else if (tid > 120)
            System.out.println("Kan inte träna över 2h");
        else if (tid <=120){
            energi = energi - (tid * 0.03);
            if (energi < 0)
                System.out.println("Du kollapsade under ditt gympass. Nya tag imorgon");
            else
                System.out.println("Bra gympass!");
        }
    }
    public void promenad(double km){
        if (km >0 && km <= 10 && energi >= 2*km)
            energi = energi - 0.5*km;
        else if (km>10)
            System.out.println("Även en atlete har begränsningar. Max 10km");
        else if (km<=0)
            System.out.println("Måste vara större än 0");
        else if (km<=10 && energi <= 2*km ){
            System.out.println("Din energi tog slut och du kollapsade under pomenaden. Vila ut och ta nya tag imorrn!");
            energi = energi - 0.5*km;
        }
    }

}