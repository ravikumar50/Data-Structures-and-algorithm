import java.util.*;

class DataPoint {
    double age;
    double loan;
    String defaultStatus;

    public DataPoint(double age, double loan, String defaultStatus) {
        this.age = age;
        this.loan = loan;
        this.defaultStatus = defaultStatus;
    }
}

public class Main {
    // Sample dataset
    private static List<DataPoint> dataset = new ArrayList<>();

    public static void main(String[] args) {
        // Populate the dataset with some sample data
        initializeDataset();
        Scanner sc = new Scanner(System.in);
        // New data point to predict
        System.out.println("Enter the age");
        int age = sc.nextInt();
        System.out.println("Enter the loan amount");
        int loan = sc.nextInt();
        DataPoint newDataPoint = new DataPoint(age, loan, "");

        // Perform KNN prediction
        String predictedClass = predictClass(newDataPoint, 3);

        // Display the predicted class
        System.out.println("Predicted class for age=" + newDataPoint.age +
                ", loan=" + newDataPoint.loan + ": " + predictedClass);
    }

    // Initialize the dataset with sample data
    private static void initializeDataset() {
        dataset.add(new DataPoint(25, 40000, "no"));
        dataset.add(new DataPoint(35, 60000, "no"));
        dataset.add(new DataPoint(45, 80000, "no"));
        dataset.add(new DataPoint(20, 20000, "no"));
        dataset.add(new DataPoint(33, 150000, "yes"));
        dataset.add(new DataPoint(52, 18000, "no"));
        dataset.add(new DataPoint(23, 95000, "yes"));
        dataset.add(new DataPoint(40, 62000, "yes"));
        dataset.add(new DataPoint(60, 100000, "yes"));
        dataset.add(new DataPoint(48, 220000, "yes"));
        dataset.add(new DataPoint(45, 120000, "no"));
        // Add more data points as needed
    }

    // Perform KNN prediction
    private static String predictClass(DataPoint newDataPoint, int k) {
        // Calculate distances to all data points
        List<DataPointDistance> distances = new ArrayList<>();
        for (DataPoint dataPoint : dataset) {
            double distance = calculateEuclideanDistance(newDataPoint, dataPoint);
            distances.add(new DataPointDistance(dataPoint, distance));
        }

        // Sort distances in ascending order
        Collections.sort(distances);

        // Count the votes for each class from the nearest neighbors
        int yesCount = 0;
        int noCount = 0;
        for (int i = 0; i < k; i++) {
            DataPointDistance neighbor = distances.get(i);
            if (neighbor.dataPoint.defaultStatus.equals("yes")) {
                yesCount++;
            } else {
                noCount++;
            }
        }

        // Make the final prediction based on majority vote
        return (yesCount > noCount) ? "yes" : "no";
    }

    // Calculate Euclidean distance between two data points
    private static double calculateEuclideanDistance(DataPoint point1, DataPoint point2) {
        double sum = Math.pow(point1.age - point2.age, 2) + Math.pow(point1.loan - point2.loan, 2);
        return Math.sqrt(sum);
    }

    // Helper class to store a data point along with its distance
    static class DataPointDistance implements Comparable<DataPointDistance> {
        DataPoint dataPoint;
        double distance;

        public DataPointDistance(DataPoint dataPoint, double distance) {
            this.dataPoint = dataPoint;
            this.distance = distance;
        }

        @Override
        public int compareTo(DataPointDistance other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}
