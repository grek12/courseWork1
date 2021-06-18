package sample;

public class Contracts {
    protected Contracts nextCont;//указатель на след. клиента
    private String Fam;//фамилия клиента
    private float Price;//цена сделки

    //объявление конструктора класса(создание клиента с необходимыми свойствами)
    public Contracts(String aFam, float aPrice) {
        Fam = aFam;
        Price = aPrice;
    }

    public Contracts getNextCont() {
        return nextCont;
    }//метод доступа на след клиента

    public String getFam() {
        return Fam;
    }//Метод доступа фамилии клиента

    public float getPrice() {
        return Price;
    }//Метод доступа цены сделки

    public String dataCont() {//метод доступа данных клиента
        String s = "";
        s = getFam() + " " + getPrice() + "\n";
        return s;
    }

}
