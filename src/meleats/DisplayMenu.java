package meleats;

// Display menu items
class DisplayMenu {
    protected static void displayMainMenu() {
        System.out.printf("\n\n%s", "Welcome to Melbourne Eats");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select from main menu");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Browse by category");
        System.out.printf("\n%-2s %s", "2)", "Search by restaurant");
        System.out.printf("\n%-2s %s", "3)", "Checkout");
        System.out.printf("\n%-2s %s", "4)", "Exit");
    }

    protected static void displayCategoryMenu() {
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", ">", "Select by category");
        System.out.printf("\n%s", "-----------------------------------------------------");
        System.out.printf("\n%-2s %s", "1)", "Restaurant");
        System.out.printf("\n%-2s %s", "2)", "Cafe");
        System.out.printf("\n%-2s %s", "3)", "Fast food");
        System.out.printf("\n%-2s %s", "4)", "Go to main menu");
    }
}
