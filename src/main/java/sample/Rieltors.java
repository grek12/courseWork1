package sample;


public class Rieltors {
    private Realtor[] realtors;//массив с риелторами
    private int realtorCount;//кол-во риелторов
    private String AgencyName;//название компании

    public Rieltors(String agencyName) {//объявление конструктора класса(создание агентства с необходимыми свойствами)
        AgencyName = agencyName;
        realtorCount = 0;
        realtors = new Realtor[10];//задаем размерность массива
    }

    public Realtor[] getRealtors() {
        return realtors;
    }//Метод доступа массива с риелторами

    public int getRealtorCount() {
        return realtorCount;
    }//метод доступа кол-ва риелторов

    //Метод добавления нового риелтора ПОСЛЕ выбранного риелтора
    public int addRealtorItem(String findName, String aFamRealtor, String numberaFam) {
        if (this.realtors != null) {
            Realtor newRealtor = new Realtor(aFamRealtor, numberaFam);
            if (realtorCount == 0) {
                realtors[realtorCount] = newRealtor;
                realtorCount++;
            } else if (realtorCount < realtors.length - 1) {
                for (int i = 0; i < realtorCount; i++) {
                    if (realtors[i].getFam().equals(findName)) {
                        int in = i;
                        for (int i1 = realtorCount; i1 > in; i1--) {
                            realtors[i1 + 1] = realtors[i1];
                        }
                        realtors[in + 1] = newRealtor;
                        realtorCount++;
                    }
                }
            } else if (realtorCount == realtors.length - 1) {

                return (-1);
            }
        }
        return 0;
    }

    //Метод добавления нового риелтора ДО выбранного риелтора
    public int addRealtorTo(String findName, String aFamRealtor, String numberaFam) {
        if (this.realtors != null) {
            Realtor newRealtor = new Realtor(aFamRealtor, numberaFam);
            if (realtorCount == 0) {
                realtors[realtorCount] = newRealtor;
                realtorCount++;
            } else if (realtorCount < realtors.length - 1) {
                for (int i = 0; i < realtorCount; i++) {
                    if (realtors[i].getFam().equals(findName)) {
                        int in = i;
                        for (int i1 = realtorCount; i1 >= in; i1--) {
                            realtors[i1 + 1] = realtors[i1];
                        }
                        realtors[in] = newRealtor;
                        realtorCount++;
                        i++;
                    }
                }
            } else if (realtorCount == realtors.length - 1) {

                return (-1);
            }
        }
        return 0;
    }

    public Realtor remove(String aFam) {//метод удаления выбранного риелтора
        if (realtors == null) {
            return null;
        } else {
            for (int i = 0; i < realtorCount; i++) {
                if (realtors[i].getFam().equals(aFam)) {
                    int in = i;
                    for (int i1 = in; i1 < realtorCount; i1++) {
                        realtors[i1] = realtors[i1 + 1];
                    }
                    realtorCount--;
                }
            }

            return realtors[realtorCount];
        }
    }


    public Realtor getRealtor(String aFam) {//метод доступа получения ссылки на риелтора
        if (realtors != null) {
            for (int i = 0; i < realtorCount; i++) {
                if (realtors[i].getFam().equals(aFam)) {
                    return realtors[i];
                }
            }
        }
        return null;
    }

    public void removeAll() {//метод удаления всех риелторов
        realtors = new Realtor[10];
        realtorCount = 0;
    }

    public String data() {//метод получения данных риелторов
        String s = "";
        for (int i = 0; i < getRealtorCount(); i++) {
            s = s + realtors[i].getDataa();
        }
        return s;
    }
    public String sumAgentstvo(){//метод получения суммы сделок агентства
        float s = 0;

        for (int i = 0; i < getRealtorCount(); i++) {
            s = s + realtors[i].getPriceSum();
        }
        return String.valueOf(s);
    }

    //метод добавления риелторов из файла
    public int addRealtorFile(String aFamRealtor, String numberaFam) {
        if (this.realtors != null) {
            Realtor newRealtor = new Realtor(aFamRealtor, numberaFam);

            realtors[realtorCount] = newRealtor;
            realtorCount++;
        }
        return 0;
    }
}