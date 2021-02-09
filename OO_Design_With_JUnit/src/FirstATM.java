/* login - card & 4 numbers
 deposit
* withdrawl
user - id, money, loginPW, first, lastname, email */

import java.text.DecimalFormat;
import java.util.HashMap;

class AllUsers {


}

class ATMUser {

    HashMap<Long, ATMUser> allUsers;
    long id;
    double money;
    String loginPW;
    String firstName;
    String lastName;
    String email;

    public ATMUser() {
        this.allUsers = new HashMap<>();
    }

    public ATMUser(long id, double money, String loginPW, String firstName, String lastName, String email) {
        this.id = id;
        this.money = money;
        this.loginPW = loginPW;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addUser(ATMUser user) {
        allUsers.put(user.id, user);
    }

    public ATMUser getUser(Long userId) {
        return this.allUsers.get(userId);
    }

    public void deposit(ATMUser user, double moMoney) {
        user.money += moMoney;
    }

    public void withdrawl(ATMUser user, double moMoney) {
        user.money -= moMoney;
    }
}



class ATM {

    public static void main(String[] args) {
        ATMUser allUsers = new ATMUser();
        ATMUser user1 = new ATMUser(1,45.32,"3241", "brent", "rucker", "brnet@gmail.com");
        allUsers.addUser(user1);
        ATMUser thisUser =  allUsers.getUser(Long.valueOf(1));
        System.out.println("Money = "+thisUser.money+", email = "+thisUser.email);
        user1.deposit(thisUser, 22.45);
        System.out.println("After Deposit Money = "+thisUser.money);
        user1.withdrawl(thisUser, 12.00);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("After Withdrawl Money = "+df.format(thisUser.money));

        ATMUser user2 = new ATMUser(2,4115.32,"3242", "brentley", "rucker motha fucka", "brent@gmail.com");
        allUsers.addUser(user2);
        user2.deposit(user2, 22.45);
        System.out.println("After Deposit Money = "+df.format(user2.money));
        user2.withdrawl(user2, 12.00);
        System.out.println("After Withdrawl Money = "+df.format(user2.money));
    }

    
}
