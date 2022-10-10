package org.example;

import org.example.exceptions.NotEnoughBoxesForPackageException;
import org.example.exceptions.PackageIsToHeavyException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostOffice {
    private List<PostedItem> postedItems;

    public PostOffice() {
        postedItems = new ArrayList<>();
    }

    public PostOffice(List<PostedItem> postedItems) {
        this.postedItems = postedItems;
    }

    public void addPostedItem(PostedItem item){
        postedItems.add(item);
    }

    public void listAllPostedItemsOnGivenDate(LocalDate date){
        for (PostedItem item: postedItems) {
            if(item.getDate().equals(date)){
                System.out.println(item);
            }
        }
    }

    public double getTotalIncomeFromGivenType(String type){
        return switch (type.toLowerCase()) {
            case "letter" -> getTotalIncomeFromLetters();
            case "small box" -> getTotalIncomeFromBoxes(BoxType.SMALL);
            case "big box" -> getTotalIncomeFromBoxes(BoxType.BIG);
            case "package" -> getTotalIncomeFromPackages();
            default -> 0.0;
        };
    }

    private double getTotalIncomeFromPackages() {
        double income = 0.0;
        for (PostedItem item : postedItems) {
            if(item.getClass().getSimpleName().equals("Package")){
                income += item.getPrice();
            }
        }
        return income;
    }

    private double getTotalIncomeFromBoxes(BoxType type) {
        double income = 0.0;
        for (PostedItem item : postedItems) {
            if(item.getClass().getSimpleName().equals("Box") && ((Box) item).getType() == type){
                income += item.getPrice();
            }
        }
        return income;
    }

    public double getTotalIncomeFromLetters(){
        double income = 0.0;
        for (PostedItem item : postedItems) {
            if(item.getClass().getSimpleName().equals("Letter")){
                income += item.getPrice();
            }
        }
        return income;
    }

    public void createPackage(List<Box> boxes){
        try {
            postedItems.add(new Package(boxes));
        } catch (NotEnoughBoxesForPackageException | PackageIsToHeavyException e){
            System.out.println(e.getMessage());
        }
    }

    public void addBoxToPackage(Box box){
        for (PostedItem item: postedItems) {
            if(item.getClass().equals(Package.class) && canGoWithPackage(item, box)){
                try{
                    ((Package) item).addBox(box);
                    break;
                } catch (PackageIsToHeavyException p){
                    System.out.println(p.getMessage());
                }
            }
        }
    }

    private boolean canGoWithPackage(PostedItem item, Box box) {
        return item.getSender().equals(box.getSender())
                && item.getAddress().equals(box.getAddress()) && item.getDate().equals(box.getDate());
    }
}
