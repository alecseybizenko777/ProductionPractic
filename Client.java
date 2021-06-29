package Practic;

public class Client {

    final private int id;
    final private String surname, name, patronymic;
    final private String city, street;
    final private int houseNumber;
    final private String numberTelephone;
    final private int numberOfHits;

    Client(int id, String surname, String name, String patronymic, String city, String street, int houseNumber, String numberTelephone, int numberOfHits) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.numberTelephone = numberTelephone;
        this.numberOfHits = numberOfHits;
    }

    @Override
    public String toString() {
        return "\nID =" + id + "\nКлиент: " + surname + " " + name + " " + patronymic + ", из города \"" + city + "\", проживает на улице \"" + street + "\", в доме №"
                + houseNumber + ".\nКоличество его обращений в пункт проката = " + numberOfHits + "\n";
    }

}