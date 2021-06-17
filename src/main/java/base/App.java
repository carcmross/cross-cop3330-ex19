package base;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright Marc-Anthony Cross
 */

/*
 * You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.
 *
 * Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight
 * in pounds. The program should prompt the user for weight and height.
 *
 * Calculate the BMI by using the following formula:
 *
 * bmi = (weight / (height × height)) * 703
 *
 * If the BMI is between 18.5 and 25, display that the person is at a normal weight. If they are out of that range,
 * tell them if they are underweight or overweight and tell them to consult their doctor.
 * Example Output
 *
 * Your BMI is 19.5.
 * You are within the ideal weight range.
 *
 * or
 *
 * Your BMI is 32.5.
 * You are overweight. You should see your doctor.
 *
 * Constraint
 *
 *     Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.
 *
 * Challenges
 *
 *     Make the user interface accept height and weight in Imperial or metric units. You’ll need a slightly different
 *     formula for metric units.
 *     For Imperial measurements, prompt for feet and inches and convert feet to inches so the user doesn’t have to.
 *     Use a GUI interface with sliders for height and weight. Update the user interface on the fly. Use colors as
 *     well as text to indicate health.
 *
 */

public class App {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String height = getHeight();
        while (isNumerical(height) == false)
            height = getHeight();

        String weight = getWeight();
        while (isNumerical(weight) == false)
            weight = getWeight();

        String bmi = calcBMI(height, weight);
        String outputString = generateOutput(bmi);
        System.out.println(outputString);
    }

    public static boolean isNumerical(String input) {
        String regex = "[0-9]+";
        return input.matches(regex);
    }

    public static int withinRange(double bmi) {
        if (bmi >= 18.5 && bmi <= 25)
            return 1;
        else if (bmi < 18.5)
            return 0;
        else
            return 2;
    }

    public static String generateOutput(String bmi) {
        double bmi_double = Double.parseDouble(bmi);

        if (withinRange(bmi_double) == 0)
            return String.format("Your BMI is %.1f.\nYou are underweight. You should see a doctor.", bmi_double);
        else if (withinRange(bmi_double) == 1)
            return String.format("Your BMI is %.2f.\nYou are within ideal weight range.", bmi_double);
        else
            return String.format("Your BMI is %.2f.\nYou are overweight. You should see a doctor.", bmi_double);
    }

    public static String calcBMI(String height, String weight) {
        int height_int = Integer.parseInt(height);
        int weight_int = Integer.parseInt(weight);
        double bmi = ((double) weight_int / (height_int * height_int)) * 703;
        return String.valueOf(bmi);
    }

    public static String getWeight() {
        System.out.print("Enter your weight, in pounds: ");
        return in.nextLine();
    }

    public static String getHeight() {
        System.out.print("Enter your height, in inches: ");
        return in.nextLine();
    }
}
