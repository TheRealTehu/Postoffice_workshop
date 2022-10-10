package org.example;

import org.example.exceptions.BoxInWrongPackageException;
import org.example.exceptions.NotEnoughBoxesForPackageException;
import org.example.exceptions.PackageIsToHeavyException;

import java.util.List;

public class Package extends PostedItem{
    private List<Box> boxes;
    private final double WEIGHT_LIMIT = 5000;
    private final double DISCOUNT_MULTIPLIER = 0.9;

    public Package(List<Box> boxes) throws NotEnoughBoxesForPackageException, PackageIsToHeavyException {
        super(boxes.get(0).getAddress(), boxes.get(0).getSender(), boxes.get(0).getDate());
        if(boxes.size() < 2){
            throw new NotEnoughBoxesForPackageException("Packages need at least 2 boxes!");
        }
        this.boxes = boxes;
        if(getTotalWeight() > WEIGHT_LIMIT){
            throw new PackageIsToHeavyException("This package is " + (getTotalWeight() - WEIGHT_LIMIT) + " grams over the weight limit!");
        }
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public void addBox(Box box) throws BoxInWrongPackageException, PackageIsToHeavyException {
        if(!this.getSender().equals(box.getSender()) || !this.getAddress().equals(box.getAddress()) ||
        this.getDate() != box.getDate()){
            throw new BoxInWrongPackageException();
        } else if(getTotalWeight() + box.getWeight() > WEIGHT_LIMIT){
            throw new PackageIsToHeavyException("This package is " + (getTotalWeight() - WEIGHT_LIMIT) + " grams over the weight limit!");
        } else {
            boxes.add(box);
        }
    }

    public double getTotalWeight(){
        double totalWeight = 0.0;
        for (Box box : boxes) {
            totalWeight += box.getWeight();
        }
        return totalWeight;
    }

    @Override
    protected double calculatePrice() {
        double price = 0.0;
        for (Box box : boxes) {
            price += box.getPrice();
        }

        return price * DISCOUNT_MULTIPLIER;
    }
}
