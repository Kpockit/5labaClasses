package laba5_Pokitku;

import java.util.Scanner;

public class Main {
    //считывание с консоли
    private static String readLine(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static Plant[] plants = new Plant[4];

    public static void addPlants(){
        if (Bush.getCount()==0){
            addBushes();
            addTrees();
        }
        else{
            boolean startMenuAgain;
            do {
                startMenuAgain = false;
                System.out.println("___Объекты уже созданы! Хотите заменить?");
                System.out.println("___1) Да");
                System.out.println("___2) Нет");
                System.out.print("___>>");
                switch (readLine()){
                    case "1":
                        addBushes();
                        addTrees();
                        break;
                    case "2":
                        return;
                    default:
                        System.out.println("Нет такого пункта! Выберите еще раз");
                        startMenuAgain = true;
                }
            } while (startMenuAgain);
        }
    }

    public static void addBushes(){
        boolean ok;
        String n, m;
            for (int i = 0; i < 2; i++){
                do {
                    ok = true;
                    System.out.println("Название " + (i + 1) + " кустарника:");
                    System.out.print(">>");
                    n = readLine();
                    System.out.println("Месяц цветения " + (i + 1) + " кустарника:");
                    System.out.print(">>");
                    m = readLine();
                    try {
                        plants[i] = new Bush(n, m);
                    } catch (IllegalArgumentException e) {
                        ok = false;
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        ok = false;
                        System.out.println("Ошибка, введите заново!");
                    }
                }while (!ok);
            }
    }

    public static void addTrees(){
        boolean ok;

            for(int i = 2, j = 1; i < 4; i++, j++) {
                do {
                    ok = true;
                    System.out.println("Название " + j + " дерева:");
                    System.out.print(">>");
                    String n1 = readLine();
                    System.out.println("Возраст " + j + " дерева:");
                    System.out.print(">>");
                    String a1 = readLine();
                    int a11 = 0;
                    try {
                        a11 = Integer.parseInt(a1);
                    } catch (Exception e) {
                        ok = false;
                        System.out.println("Введите число");
                    }
                    if (ok) {
                        try {
                            plants[i] = new Tree(n1, a11);
                        } catch (IllegalArgumentException e) {
                            ok = false;
                            System.out.println(e.getMessage());
                        } catch (Exception e) {
                            ok = false;
                            System.out.println("Ошибка, введите заново!");
                        }
                    }
                } while (!ok);
            }
    }

    public static void changeBush(int n){
        System.out.println(plants[n].info());
        boolean startMenuAgain;
        do {
            startMenuAgain = false;
            System.out.println("___Что хотите изменить?");
            System.out.println("___1) Название");
            System.out.println("___2) Месяц цветения");
            System.out.print("___>>");
            switch (readLine()) {
                case "1":
                    System.out.println("Введите название");
                    System.out.print(">>");
                    plants[n].setName(readLine());
                    System.out.println("Название изменено!");
                    break;
                case "2":
                    System.out.println("Введите месяц цветения");
                    boolean ok;
                    do {
                        ok = true;
                        System.out.print(">>");
                        Bush b = (Bush) plants[n];
                        try {
                            b.setMonth(readLine());
                            System.out.println("Месяц цветения изменен!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + "Введите заново");
                            ok = false;
                        } catch (Exception e) {
                            System.out.println("Ошибка, введите заново!");
                            ok = false;
                        }
                    } while (!ok);
                    break;
                default:
                    System.out.println("Нет такого пункта! Выберите еще раз");
                    startMenuAgain = true;
            }
        } while (startMenuAgain);
    }

    public static void changeTree(int n){
        System.out.println(plants[n].info());
        boolean startMenuAgain;
        do {
            startMenuAgain = false;
            System.out.println("___Что хотите изменить?");
            System.out.println("___1) Название");
            System.out.println("___2) Возраст");
            System.out.print("___>>");
            switch (readLine()) {
                case "1":
                    System.out.println("Введите название");
                    System.out.print(">>");
                    plants[n].setName(readLine());
                    System.out.println("Название изменено!");
                    break;
                case "2":
                    System.out.println("Введите возраст");
                    boolean ok;
                    do {
                        ok = true;
                        System.out.print(">>");
                        String a1 = readLine();
                        int a11 = 0;
                        try {
                            a11 = Integer.parseInt(a1);
                        } catch (Exception e) {
                            ok = false;
                            System.out.println("Введите число");
                        }
                        if (ok) {
                            try {
                                Tree t = (Tree) plants[n];
                                t.setAge(a11);
                            } catch (IllegalArgumentException e) {
                                ok = false;
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                ok = false;
                                System.out.println("Ошибка, введите заново!");
                            }
                        }
                    } while (!ok);
                default:
                    System.out.println("Нет такого пункта! Выберите еще раз");
                    startMenuAgain = true;
            }
        } while (startMenuAgain);
    }

    public static void changePlant(){
        if (Bush.getCount()==0) {
            System.out.println("Нет объектов");
        }
        else {
            System.out.println("\nВыберите объект для изменения:");
            printPlants();
            boolean ok;
            int n;
            do {
                ok = true;
                try {
                    n = Integer.parseInt(readLine());
                    if (ok && n > 0 && n < 5){
                        if (plants[n-1] instanceof Bush) changeBush(n-1);
                        if (plants[n-1] instanceof Tree) changeTree(n-1);
                    }
                    else {
                        System.out.println("Нет объекта под таким номером!");
                        ok = false;
                    }
                } catch (Exception e){
                    ok = false;
                    System.out.println("Введите число!");
                }
            } while (!ok);
        }
    }

    public static void printPlants(){
        for (int i = 0; i < plants.length; i++){
            System.out.println((i+1)+") " + plants[i].info());
        }
    }

    public static void coutCons(){
        if (Bush.getCount() == 0){
            System.out.println("Нет объектов");
        }
        else {
            printPlants();
            for (int i = 0; i < 4; i++) {
                countableCons c = plants[i];
                System.out.println((i + 1) + " - количество согласных в названии: " + c.countCons());
            }
        }
    }

    public static void main(String[] args) {
        boolean startMenuAgain;
        do{
            startMenuAgain = false;
            System.out.println("\n1) Добавить объекты");
            System.out.println("2) Изменить объекты");
            System.out.println("3) Просмотреть объекты");
            System.out.println("4) Запрос");
            System.out.println("5) Выход");
            System.out.print(">>");
            switch (readLine()){
                case "1":
                    addPlants();
                    startMenuAgain = true;
                    break;
                case "2":
                    changePlant();
                    startMenuAgain = true;
                    break;
                case "3":
                    if (Bush.getCount()==0) {
                        System.out.println("Нет объектов");
                    }
                    else printPlants();
                    startMenuAgain = true;
                    break;
                case "4":
                    coutCons();
                    startMenuAgain = true;
                    break;
                case "5":
                    System.out.println("Выход из программы");
                    System.exit(0);
                default:
                    System.out.println("Нет такого пункта! Выберите еще раз");
                    startMenuAgain = true;
            }
        } while (startMenuAgain);
    }
}