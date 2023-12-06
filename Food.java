import java.util.Arrays;
import java.util.Random;

public class Food implements Comparable<Food> {

    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};
    private String type;
    private int calories;

    public Food(String type, int calories) {
        if (Arrays.asList(TYPES).contains(type)) {
            this.type = type;
            this.calories = calories;
        } else {
            throw new IllegalArgumentException("Kein richtiges Food!");
        }
    }

    public String toString() {
        return "Type: " + type + ", Calories: " + calories;
    }

    public int compareTo(Food o) {
        int wert1 = this.type.length() * this.calories;
        int wert2 = o.type.length() * o.calories;
        return Integer.compare(wert1, wert2);
    }

    public String getType() {
        // Ist das richtig?
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public static Food[] createSortedRandomList(int n) {
        Random random = new Random();
        Food[] foodList = new Food[n];

        for (int i = 0; i < n; i++) {
            String randomType = TYPES[random.nextInt(TYPES.length)];
            int randomCalories = random.nextInt(1000);
            foodList[i] = new Food(randomType, randomCalories);
        }

        Arrays.sort(foodList);
        return foodList;
    }

    public static void main(String[] args) {
        Food[] randomFoodList = createSortedRandomList(5);
        for (Food food : randomFoodList) {
            String type = food.getType();
            int calories = food.getCalories();

            if (calories < 0) {
                System.out.println("Type: " + type + ", Calories: " + calories);
            } else {
                System.out.println("Type: " + type + ", Calories: " + calories);
            }
        }
    }
}
