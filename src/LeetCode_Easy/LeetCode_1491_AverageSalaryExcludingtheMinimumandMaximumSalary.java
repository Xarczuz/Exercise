package LeetCode_Easy;

public class LeetCode_1491_AverageSalaryExcludingtheMinimumandMaximumSalary {

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int nr : salary) {
            max = Math.max(max, nr);
            min = Math.min(min, nr);
            sum += nr;
        }
        return (sum - max - min) / (salary.length - 2d);
    }

}
