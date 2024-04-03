package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the painter's calculator application. To help you calculate this we will refer to all surfaces (ie ceiling or walls) that you wish to paint as Interior Surfaces");
        Scanner reader = new Scanner(System.in);

            double totalArea = 0; // initial area to add to each time for every interior surface
            System.out.println("How many interior surfaces will you be painting?");
            int numOfInteriorSurfaces = reader.nextInt(); // takes number of interior surfaces
            for (int i = 1; i <= numOfInteriorSurfaces; i++) { // for every interior surface questions regarding dimensions and properties are asked
                System.out.println("Please provide details for Interior Surface " + i + ":");

                System.out.println("What is the length of this Interior Surface in meters?");
                double length = reader.nextDouble();
                System.out.println("What is the width of this Interior Surface in meters?");
                double width = reader.nextDouble();
                System.out.println("What is the shape of the Interior Surface? Please input one of the following options: rectangle, square, triangle, circle, trapezium or irregular");
                String shape = reader.next().toLowerCase();

                double area = 0.0;
                switch (shape) {
                    case "rectangle":
                    case "square":
                        area = length * width;
                        break;
                    case "triangle":
                        System.out.println("What is the height of the triangle?");
                        double triangleHeight = reader.nextDouble();
                        area = 0.5 * width * triangleHeight;
                        break;
                    case "circle":
                        System.out.println("What is the radius of the circle?");
                        double circleRadius = reader.nextDouble();
                        area = Math.PI * Math.pow(circleRadius, 2);
                        break;
                    case "trapezium":
                        System.out.println("What is the length of the top side of the trapezium?");
                        double trapeziumTopLength = reader.nextDouble();
                        System.out.println("What is the length of the bottom side of the trapezium?");
                        double trapeziumBottomLength = reader.nextDouble();
                        System.out.println("What is the height of the trapezium?");
                        double trapeziumHeight = reader.nextDouble();
                        area = 0.5 * (trapeziumTopLength + trapeziumBottomLength) * trapeziumHeight;
                        break;
                    case "irregular":
                        System.out.print("Enter the number of component shapes: ");
                        int numShapes = reader.nextInt();
                        double totalAreaIrregularShape = 0.0;

                        for (int k = 1; k <= numShapes; k++) { // for each component shape within a compound shape dimensions and properties are stored
                            System.out.println("Component Shape " + k + ":");
                            System.out.print("Enter the type of shape (rectangle, triangle, circle): ");
                            String shapeType = reader.next().toLowerCase();

                            double areaIrrShape = 0.0;

                            switch (shapeType) {
                                case "rectangle":
                                    System.out.print("Enter length of rectangle: ");
                                    double lengthIrrShape = reader.nextDouble();
                                    System.out.print("Enter width of rectangle: ");
                                    double widthIrrShape = reader.nextDouble();
                                    areaIrrShape = lengthIrrShape * widthIrrShape;
                                    break;
                                case "triangle":
                                    System.out.print("Enter base length of triangle: ");
                                    double base = reader.nextDouble();
                                    System.out.print("Enter height of triangle: ");
                                    double height = reader.nextDouble();
                                    areaIrrShape = 0.5 * base * height;
                                    break;
                                case "circle":
                                    System.out.print("Enter radius of circle: ");
                                    double radius = reader.nextDouble();
                                    areaIrrShape = Math.PI * radius * radius;
                                    break;
                                default:
                                    System.out.println("Invalid shape type.");
                            }

                            totalAreaIrregularShape += areaIrrShape;

                        }
                        System.out.println("Total area of compound shape: " + totalAreaIrregularShape + " square units");

                        area = totalAreaIrregularShape;

                        break;
                        default:
                        System.out.println("Invalid shape. Please try again.");
                        return;
                }

                System.out.println("The area of wall " + i + " is: " + area + " square meters.");
                totalArea += area;

                System.out.println("Are there any areas of this surface interior that you will not be painting(e.g., doors, windows, area covered by radiators)? (yes/no)");
                String isThereNonPaintArea = reader.next().toLowerCase();

                double totalNonPaintArea = 0;
                if (isThereNonPaintArea.equals("yes")) {
                    System.out.println("I will need some more information regarding this.");
                    System.out.println("Please tell me the number of non-paint areas");
                    int numOfNonPaintAreas = reader.nextInt();

                    for (int j = 1; j <= numOfNonPaintAreas; j++) {
                        System.out.println("Please provide details for non-paint area " + j + ":");
                        System.out.println("What is the length of this non-paint area in meters?");
                        double nonPaintLength = reader.nextDouble();
                        System.out.println("What is the width of this non-paint area in meters?");
                        double nonPaintWidth = reader.nextDouble();
                        System.out.println("What is the shape of this non-paint area? (e.g., rectangle, square)");
                        String nonPaintAreaShape = reader.next().toLowerCase();

                        double nonPaintSectionArea = 0.0;
                        switch (nonPaintAreaShape) {
                            case "rectangle":
                            case "square":
                                nonPaintSectionArea = nonPaintLength * nonPaintWidth;
                                break;
                            case "triangle":
                                System.out.println("What is the height of the triangle?");
                                double triangleHeight = reader.nextDouble();
                                nonPaintSectionArea = 0.5 * nonPaintWidth * triangleHeight;
                                break;
                            case "circle":
                                System.out.println("What is the radius of the circle?");
                                double circleRadius = reader.nextDouble();
                                nonPaintSectionArea = Math.PI * Math.pow(circleRadius, 2);
                                break;
                            case "trapezium":
                                System.out.println("What is the length of the top side of the trapezium?");
                                double trapeziumTopLength = reader.nextDouble();
                                System.out.println("What is the length of the bottom side of the trapezium?");
                                double trapeziumBottomLength = reader.nextDouble();
                                System.out.println("What is the height of the trapezium?");
                                double trapeziumHeight = reader.nextDouble();
                                nonPaintSectionArea = 0.5 * (trapeziumTopLength + trapeziumBottomLength) * trapeziumHeight;
                                break;
                            case "irregular":
                                System.out.print("Enter the number of component shapes: ");
                                int numShapes = reader.nextInt();
                                double totalAreaIrregularShape = 0.0;

                                for (int k = 1; k <= numShapes; k++) {
                                    System.out.println("Component Shape " + k + ":");
                                    System.out.print("Enter the type of shape (rectangle, triangle, circle): ");
                                    String shapeType = reader.next().toLowerCase();

                                    double areaIrrShape = 0.0;

                                    switch (shapeType) {
                                        case "rectangle":
                                            System.out.print("Enter length of rectangle: ");
                                            double lengthIrrShape = reader.nextDouble();
                                            System.out.print("Enter width of rectangle: ");
                                            double widthIrrShape = reader.nextDouble();
                                            areaIrrShape = lengthIrrShape * widthIrrShape;
                                            break;
                                        case "triangle":
                                            System.out.print("Enter base length of triangle: ");
                                            double base = reader.nextDouble();
                                            System.out.print("Enter height of triangle: ");
                                            double height = reader.nextDouble();
                                            areaIrrShape = 0.5 * base * height;
                                            break;
                                        case "circle":
                                            System.out.print("Enter radius of circle: ");
                                            double radius = reader.nextDouble();
                                            areaIrrShape = Math.PI * radius * radius;
                                            break;
                                        default:
                                            System.out.println("Invalid shape type.");
                                    }

                                    totalAreaIrregularShape += areaIrrShape;

                                }
                                System.out.println("Total area of compound shape: " + totalAreaIrregularShape + " square units");

                                area = totalAreaIrregularShape;

                            default:
                                System.out.println("Invalid shape. Please try again.");
                                return;
                        }
                        System.out.println("The area of non-paint area " + j + " is: " + nonPaintSectionArea + " square meters.");
                        totalNonPaintArea += nonPaintSectionArea;
                    }
                    System.out.println("The total area of all non-paint areas for Interior Surface " + i + ": " + totalNonPaintArea + " square meters.");
                }
                double totalPaintedArea = area - totalNonPaintArea;
                System.out.println("The total area of Interior Surface " + i + ": " + totalPaintedArea + " square meters.");
                totalPaintedArea+= totalArea;
            }

            double totalLitres = totalArea/10;
            double numOfCans = Math.ceil(totalLitres);
            double cost = numOfCans * 6.40;

        System.out.println("The total surface area to paint is " + totalArea + " square meters." +
                "This means you require" + (totalLitres) + "litres of paint" +
                "This will cost you" + (cost) + "for" + (numOfCans) + "1 litre cans of paint");
    }


}

