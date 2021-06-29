package Practic;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileReader;

/**
 * @author Bytsenko Aleksey Vladimirovich
 * @version "Application" 2.3
 */
public class Main {

    public static void main (String[] args) throws IOException {

        Scanner choice = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat actualTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat actualDate = new SimpleDateFormat("dd.MM.yyyy");

        //[Start
        //Графический интерфейс
        {
            try {
                UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
                for (int idx = 0; idx < installedLookAndFeels.length; idx++)
                    if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                        UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                        break;
                    }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ContactEditor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ContactEditor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ContactEditor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(ContactEditor.class.getName()).log(Level.SEVERE, null, ex);
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ContactEditor().setVisible(true);
                }
            });
        }
        //Графический интерфейс
        // End]

        int userChoice, counterWrite = 1;
        Random rand = new Random();

        do {

            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить клиента(ов);");
            System.out.println("2. Добавить автомобиль(и);");
            System.out.println("3. Зарегистрировать аренду;");
            System.out.println("Для выхода из программы закройте окно графического интерфейса.");
            System.out.print("\nВведите цифру: ");

            userChoice = choice.nextInt();

            switch (userChoice)
            {
                case 1:
                {
                    String surname, name, patronymic;
                    String city, street;
                    int id, houseNumber;
                    String numberTelephone;
                    int numberOfHits;

                    ArrayList<Client> clientsList = new ArrayList<>();
                    File ClientList = new File("ClientList.txt");

                    do {
                        id = ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
                        System.out.println("\nID = " + id);

                        System.out.print("\nВведите - Фамилию: ");
                        surname = inputText.next();

                        System.out.print("\nВведите - Имя: ");
                        name = inputText.next();

                        System.out.print("\nВведите - Отчество: ");
                        patronymic = inputText.next();

                        System.out.print("\nВведите - Город: ");
                        city = inputText.next();

                        System.out.print("\nВведите - Улицу: ");
                        street = inputText.next();

                        System.out.print("\nВведите - Номер дома: ");
                        houseNumber = inputNumber.nextInt();

                        System.out.print("\nВведите - Номер телефона: ");
                        numberTelephone = inputText.next();

                        System.out.print("\nВведите - Введите количество обращений: ");
                        numberOfHits = inputNumber.nextInt();

                        System.out.println("\nВремя добавления клиента:");
                        System.out.println(actualTime.format(calendar.getTime()));

                        System.out.println("\nДата добавления клиента:");
                        System.out.println(actualDate.format(calendar.getTime()));

                        Client testClient = new Client(id, surname, name, patronymic, city, street, houseNumber, numberTelephone, numberOfHits);
                        clientsList.add(testClient);

                        try(FileWriter writer = new FileWriter(ClientList, true))
                        {
                            writer.write( "ID: " + id + "\n" + "\nФамилия: " + surname + ";\nИмя: " + name + ";\nОтчество: " + patronymic +
                                    ";\nГород: " + city + ";\nУлица: " + street + ";\nНомер дома: " + houseNumber +
                                    ";\nНомер телефона: " + numberTelephone + ";\nКоличество обращений: " + numberOfHits +
                                    ";\nВремя добавления: " + actualTime.format(calendar.getTime()) +
                                    ";\nДата добавления: " + actualDate.format(calendar.getTime()) + ".\n\n");
                            writer.flush();
                        }
                        catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }

                        System.out.print("\nКлиент был добавлен!\nЕсли желаете продолжить добавление новых клиентов, "
                                + "введите любое число, кроме \"0\",\nиначе введите \"0\".\nДействие: ");

                        userChoice = choice.nextInt();

                    } while(userChoice != 0);
                    break;
                }
                case 2:
                {
                    String brand, name;
                    int id, cost, rentalCost, pledgeAmount;

                    ArrayList<Car> carList = new ArrayList<>();
                    File CarList = new File("CarList.txt");

                    do {

                        id = ThreadLocalRandom.current().nextInt(1000, 9000);
                        System.out.println("\nID = " + id);


                        System.out.print("\nВведите - Название брэнда: ");
                        brand = inputText.next();

                        System.out.print("\nВведите - Стоимость авто: ");
                        cost = inputNumber.nextInt();

                        System.out.print("\nВведите - Полное название авто: ");
                        name = inputText.next();

                        System.out.print("\nВведите - Стоимость аренды($): ");
                        rentalCost = inputNumber.nextInt();

                        System.out.print("\nВведите - Залог для его аренды: ");
                        pledgeAmount = inputNumber.nextInt();

                        Car testCar = new Car (id, brand, cost, name, rentalCost, pledgeAmount);
                        carList.add(testCar);

                        try(FileWriter writer = new FileWriter(CarList, true))
                        {
                            writer.write("Автомобиль:\nБрэнд : " + brand + ";\nСтоимость : "
                                    + cost + "$;\nНазвание: " + name
                                    + ";\nСтоимость аренды: " + rentalCost + "$."
                                    + ";\nЗалог аренды: " + pledgeAmount +
                                    "\nВремя добавления: " + actualTime.format(calendar.getTime()) +
                                    "\nДата добавления: " + actualDate.format(calendar.getTime()) +"\n\n");
                            writer.flush();
                        }
                        catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }

                        System.out.print("\nАвтомобиль был добавлен!\nЕсли желаете продолжить добавление новых автомобилей, "
                                + "введите любое число, кроме \"0\",\nиначе введите \"0\".\nДействие №");

                        userChoice = choice.nextInt();

                    } while(userChoice != 0);
                    break;
                }
                case 3:
                {
                    File rentList = new File("rentList.txt");

                    BufferedReader clientReader = new BufferedReader(new FileReader("clientList.txt"));
                    BufferedReader rentReader = new BufferedReader(new FileReader("rentList.txt"));

                    int readerRentList, counterClient = 0, counterCar = 0;
                    String idString = "", idClient = "", idCar = "";

                    do {
                        do {

                        System.out.print("\nВведите ID клиента:");
                        idClient = inputText.next();

                        System.out.print("\nВведите ID атомобиля:");
                        idCar = inputText.next();

                        System.out.println();

                            readerRentList = rentReader.read();

                            char symbolRentList = (char) readerRentList;

                            if (symbolRentList == '#')
                            {
                                for (int i = 0; i < 5; i++)
                                {
                                    symbolRentList = (char) readerRentList;
                                    readerRentList = rentReader.read();
                                    if (symbolRentList != '#')
                                    {
                                        idString += symbolRentList;
                                    }
                                }

                                System.out.println("idString = " + idString);
                            }

                            do {

                                symbolRentList = (char) readerRentList;
                                readerRentList = rentReader.read();

                                if (idString == idClient)
                                {
                                    System.err.println("\nОшибка! Данный клиент уже зарегистрирован в системе заказов!");
                                }

                            } while (readerRentList != -1);


                            if (counterClient == 0 && counterCar == 0)
                            {
                                try(FileWriter writer = new FileWriter(rentList, true))
                                {
                                    writer.write("Заказ №" + counterWrite +  "\nID Клиента: #" + idClient + "\nID автомобиля: #" + idCar +
                                            "\nВремя регистрации: " + actualTime.format(calendar.getTime()) +
                                            "\nДата регистрации: " + actualDate.format(calendar.getTime()) +"\n\n");
                                    writer.flush();

                                    System.out.print("Аренда была оформлена успешно!\nЕсли желаете продолжить "
                                            + "регистрацию аренды автомобилей клиентами, введите любое число, кроме \"0\","
                                            + "\nиначе введите \"0\".\nДействие №");

                                    userChoice = inputNumber.nextInt();

                                    if (userChoice == 0)
                                    {
                                        readerRentList = -1;
                                    }

                                    counterWrite++;

                                }
                                catch(IOException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            else if (counterClient != 0 || counterCar != 0)
                            {
                                System.err.println("Ошибка! Данный клиент и/или автомобиль уже зарегистрирован в какам-либо заказе!");
                            }

                            idString = "";

                        }while (readerRentList != -1);
                    } while (userChoice != 0);
                    break;
                }
                default:
                {
                    System.err.println("\nОшибка! Введено некорректное значение!\n");
                }
            }

            userChoice = 1;
        } while (userChoice != 0);
    }
}