package kantine;

public class Datum {

    private int dag;
    private int maand;
    private int jaar;

    private int[] februari = {28, 29};
    private int[] dagInMaand = {31, februari[0], 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public Datum() {
        dag = maand = jaar = 0;
    }

    public Datum(int dag, int maand, int jaar) {
        this(); //Zet de standaard waarden

        if(bestaatDatum(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
    }


    public boolean bestaatDatum(int dag, int maand, int jaar) {
        //Kijk of de gegeven datum binnen de randvoorwaarden ligt
        if(dag >= 1 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
            //Kijk of het gegeven jaar een schrikkeljaar is
            if(jaar % 4 == 0)
                if(jaar % 100 != 0 || jaar % 400 == 0)
                    dagInMaand[1] = februari[1]; //Schrikkeljaar
                else if(jaar % 100 != 0 && jaar % 400 != 0)
                    dagInMaand[1] = februari[1]; //Schrikkeljaar
                else
                    dagInMaand[1] = februari[0]; //Geen schrikkeljaar
            else
                dagInMaand[1] = februari[0]; //Geen schrikkeljaar

            //Kijk of de gegeven dag mogelijk is voor het gegeven jaar
            if(dag <= dagInMaand[maand - 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Getter voor Sting weergave van datum
     * @return Geboortedatum
     */
    public String getDatumAsString() {
        // TODO
        return "";
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getMaand() {
        return maand;
    }

    public void setMaand(int maand) {
        this.maand = maand;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
}
