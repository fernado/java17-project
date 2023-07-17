package pr.iceworld.fernando.java8.basic;

import java.math.BigDecimal;

interface AccountB {
    BigDecimal balance = new BigDecimal(0.0);
}

class SavingAccount implements AccountB {
    public SavingAccount(BigDecimal intialValue){
        // Cannot assign a value to final variable 'balance'
//        balance = intialValue;
    }
    public String toString(){
        return balance.toString();
    }
}


public class OverrideClassB {
    public static void main(String[] args) {
        SavingAccount instance= new SavingAccount(new BigDecimal(50.00));
        System.out.println(instance);
    }
}
