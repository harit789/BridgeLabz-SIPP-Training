class SpringSeason {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20 && day <= 31) ||   // March 20–31
               (month == 4 && day >= 1 && day <= 30)  ||   // April full month
               (month == 5 && day >= 1 && day <= 31)  ||   // May full month
               (month == 6 && day >= 1 && day <= 20);      // June 1–20
    }
}
