package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_119_PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(new LeetCode_119_PascalsTriangleII().getRow(6));
    }

    public List<Integer> getRow(int rowIndex) {

        return generate(rowIndex).get(rowIndex - 1);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(1);
        list1.add(1);
        lists.add(list1);
        if (numRows == 1) {
            return lists;
        }
        ArrayList<Integer> list2 = new ArrayList<>(2);
        list2.add(1);
        list2.add(1, 1);
        lists.add(list2);
        if (numRows == 2) {
            return lists;
        }
        for (int i = 1; i < numRows - 1; i++) {
            lists.add(generateRow(lists.get(i)));
        }
        return lists;

    }

    public List<Integer> generateRow(List<Integer> list) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        for (int i = 0, j = 1; j < list.size(); i++, j++) {
            integerList.add(list.get(i) + list.get(j));
        }
        integerList.add(1);

        return integerList;

    }
}
