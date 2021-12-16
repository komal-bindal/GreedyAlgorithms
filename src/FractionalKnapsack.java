import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = {
                new Item(50, 600),
                new Item(20, 500),
                new Item(30, 400),
        };
        int knapsackWeight = 70;
        System.out.println(fractionalKnapsack(arr, knapsackWeight));

    }

    public static double fractionalKnapsack(Item[] arr, int knapsackWeight) {
        Arrays.sort(arr);
        double profit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].weight <= knapsackWeight) {
                profit += arr[i].profit;
                knapsackWeight -= arr[i].weight;
            } else {
                profit = profit + (arr[i].profit * (double) knapsackWeight) / (double) arr[i].weight;
                break;
            }
        }
        return profit;
    }
}

class Item implements Comparable<Item> {

    int weight;
    int profit;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }

    @Override
    public int compareTo(Item item) {
        return (this.profit - item.weight) - (this.weight * item.profit);
    }
}
