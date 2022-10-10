package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Letter letter1 = new Letter("Ezstergom", "Peter", LocalDate.of(2020, 5, 11));
        Letter letter2 = new Letter("Dubaj", "Szonja", LocalDate.of(1995, 12, 2));
        Letter letter3 = new Letter("Parizs", "Gabor", LocalDate.of(2010, 11, 23));

        Box box1 = new Box("Tata", "Miklos", LocalDate.of(2020, 5, 11), BoxType.SMALL, 1200.20);
        Box box2 = new Box("Tata", "Miklos", LocalDate.of(2020, 5, 11), BoxType.BIG, 2124.24);
        Box box3 = new Box("Tata", "Miklos", LocalDate.of(2020, 5, 11), BoxType.SMALL, 630.13);

        Box box4 = new Box("Baja", "Ferenc", LocalDate.of(2021, 3, 11), BoxType.SMALL, 1630.13);
        Box box5 = new Box("Komarom", "Istvan", LocalDate.of(2022, 5, 11), BoxType.SMALL, 333.34);
        Box box6 = new Box("Budapest", "Janos", LocalDate.of(2005, 3, 11), BoxType.BIG, 2430.87);
        Box box7 = new Box("Budapest", "Jozsef", LocalDate.of(2020, 5, 11), BoxType.BIG, 4030.94);

        List<Box> boxesForPackage = new ArrayList<>(){{add(box1); add(box2); add(box3);}};
        Package pack = new Package(boxesForPackage);

        PostOffice postOffice = new PostOffice();

        postOffice.addPostedItem(letter1);
        postOffice.addPostedItem(letter2);
        postOffice.addPostedItem(letter3);

        postOffice.addPostedItem(box4);
        postOffice.addPostedItem(box5);
        postOffice.addPostedItem(box6);
        postOffice.addPostedItem(box7);

        postOffice.addPostedItem(pack);

        postOffice.listAllPostedItemsOnGivenDate(LocalDate.of(2020, 5, 11));
        postOffice.getTotalIncomeFromGivenType("Letter");
        postOffice.getTotalIncomeFromGivenType("Letter");
        postOffice.getTotalIncomeFromGivenType("Letter");
    }
}