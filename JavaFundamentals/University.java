public class University {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        double discount = (discountPercent / 100.0) * fee;
        double reducedFee = fee - discount;
        System.out.println("Fee to be paid after Discount: " + reducedFee);
    }
}

