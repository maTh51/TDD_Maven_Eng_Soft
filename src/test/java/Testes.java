/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author matheus
 */

abstract class Money  {
    protected int amount;
    private String currency;
   
    public boolean equals(Object object)  {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    static Money dollar(int amount)  {
      return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
       return new Franc(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
	
    abstract Money times(int multiplier);

    String currency() {
        return currency;
    }
   
}

class Dollar extends Money {
    
    Dollar(int amount, String currency)  {
      super(amount, currency);
    }

    Money times(int multiplier)  {
       return Money.dollar(amount * multiplier);
    }
 }	

class Franc extends Money{
   
    Franc(int amount, String currency) {
      super(amount, currency);
    }

    Money times(int multiplier)  {
       return Money.franc(amount * multiplier);
    }

}


public class Testes {
    
    public Testes() {
    }

    @Test
    public void testMultiplication() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
    
    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
    
    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
     } 
    
    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
