package LeetCode_Easy;

public class LeetCode_1603_DesignParkingSystem {

    class ParkingSystem {

        private int big = 0;
        private int medium = 0;
        private int small = 0;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big > 0) {
                big--;
                return true;
            }
            if (carType == 2 && medium > 0) {
                medium--;
                return true;
            }
            if (carType == 3 && small > 0) {
                small--;
                return true;
            }
            return false;
        }
    }

}
