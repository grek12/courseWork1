package sample;

public class Realtor {
    private String Fam;//фамилия риелтора
    private String numberFam;//номер телефона риелтора
    private Contracts firstCont;//указатель на первого клиента
    private Contracts rearCont;//указатель на последнего клиента
    private float priceSum;//сумма сделок риелтора
    private int countCont;//кол-во клиентов

    //объявление конструктора класса(создание нового риелтора с необходимыми свойствами)
    public Realtor(String aFam, String numberaFam) {
        Fam = aFam;
        numberFam = numberaFam;
        this.countCont = 0;
        this.priceSum = getPriceSum();
    }


    public String getFam() {
        return Fam;
    }//Метод доступа фамилии риелтора

    public String getNumberFam() {
        return numberFam;
    }//Метод доступа номера риелтора

    public void addContract(String fam, float price) {//метод добавления нового клиента
        Contracts a = new Contracts(fam, price);
        if (firstCont == null) {
            firstCont = a;
            rearCont = a;
        } else {
            rearCont.nextCont = a;
            rearCont = a;
        }
        countCont++;
    }

    public void removeContract() {//Метод удаления клиента
        Contracts t = firstCont;
        if (t != null) {
            firstCont = firstCont.getNextCont();
            countCont--;
        }

    }

    public Contracts getCont() {//метод доступа клиента
        Contracts contracts = firstCont;
        return contracts;
    }


    public float getPriceSum() {//метод доступа получения суммы сделок риелтора
        Contracts t = firstCont;
        float sum = 0;
        while (t != null) {
            sum = t.getPrice() + sum;
            t = t.nextCont;
        }
        return sum;
    }


    public String getDataa2() {//метод доступа получения данных клиента
        Contracts t = firstCont;
        String s = "";
        while (t != null) {
            s = s + t.dataCont();
            t = t.nextCont;
        }
        return s;
    }

    public String getDataa() {//метод доступа получения данных риелтора и его клиентов
        String s = "";
        if (getDataa2() != "") {
            s = getFam() + " " + getNumberFam() + "\n" + "{" + "\n" + getDataa2() + "}" + "\n";
            return s;
        } else {
            s = getFam() + " " + getNumberFam() + "\n";
        }
        return s;
    }
}
