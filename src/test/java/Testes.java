/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author matheus
 */

class Money  {
    protected int amount;
    private String currency;

    static Money dollar(int amount)  {
      return new Money(amount, "USD");
    }

    static Money franc(int amount) {
       return new Money(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }
    
    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    };

    String currency() {
        return currency;
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
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
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
