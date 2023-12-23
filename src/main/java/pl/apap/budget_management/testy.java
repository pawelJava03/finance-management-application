package pl.apap.budget_management;

public class testy {
    public static void main(String[] args) {
        DatabaseService DatabaseService = new DatabaseService();
        DatabaseService.newUser("name", "surname", "email@email", "password");
        DatabaseService.checkUser("email@email","password");
    }
}