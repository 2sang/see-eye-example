package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
        Calculator calc = new Calculator();
        int output = calc.calculate("1+1");
        assertThat(output, is(2));
    } 
    
    public void testCalculatorSub () {
	Calculator calc = new Calculator();
	int output = calc.calculate("3-4");
	assertThat(output, is(-1));
    }

    public void testCalculatorMul () {
	Calculator calc = new Calculator();
	int output = calc.calculate("5*7");
	assertThat(output, is(35));
    }

    public void testCalculatorDiv () {
	Calculator calc = new Calculator();
	int output = calc.calculate("30/5");
	assertThat(output, is(6));
    }

    public void testCalculatorCom1 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("(5-3)*6");
	assertThat(output, is(12));
    }

    public void testCalculatorCom2 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("((3-7)*(6/2))*(2-4)");
	assertThat(output, is(24));
    }

    public void testCalculatorCom3 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("5*((9/3)-10)");
	assertThat(output, is(-35));
    }

    public void testCalculatorCom4 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("4+3*5");
	assertThat(output, is(19));
    }

    public void testCalculatorCom5 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("((10*2-(2+4))*(5-4))/2");
	assertThat(output, is(7));
    }

    public void testCalculatorCom6 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("(((3-6)*2)+8)/2");
	assertThat(output, is(1));
    }

    public void testCalculatorCom7 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("10/5*2");
	assertThat(output, is(4));
    }

    public void testCalculatorCom8 () {
	Calculator calc = new Calculator();
	int output = calc.calculate("(((200/10)/(156-151))+((645+35)-(67*10)))");
	assertThat(output, is(14));
    }




