
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.utils.money.MoneyTools;
import junit.framework.TestCase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristian
 */
public class TestMoney extends TestCase{

    public void testSumar() {
        BigDecimal addend = new BigDecimal("30.00");
        BigDecimal augend = new BigDecimal("20.00");
        BigDecimal sum = MoneyTools.sumar(addend, augend);
        assertEquals(new BigDecimal("50.00"), sum);
    }

    public void testSumarCon4Decimales() {
        BigDecimal addend = new BigDecimal("30.1020");
        BigDecimal augend = new BigDecimal("20.1020");
        BigDecimal sum = MoneyTools.sumar(addend, augend, 4);
        assertEquals(new BigDecimal("50.2040"), sum);
    }

    public void testSumarConCantidadesDiferentesDecimales() {
        BigDecimal n1 = new BigDecimal("1250.22");
        BigDecimal n2 = new BigDecimal("2455.1221");
        BigDecimal sum = MoneyTools.sumar(n1, n2);
        assertEquals(new BigDecimal("3705.34"), sum);
    }

    public void testRestar() {
        BigDecimal addend = new BigDecimal("30.00");
        BigDecimal augend = new BigDecimal("20.00");
        BigDecimal resta = MoneyTools.restar(addend, augend);
        assertEquals(new BigDecimal("10.00"), resta);
    }

    public void testRestarCon4Decimales() {
        BigDecimal addend = new BigDecimal("30.5050");
        BigDecimal augend = new BigDecimal("20.2020");
        BigDecimal resta = MoneyTools.restar(addend, augend, 4);
        assertEquals(new BigDecimal("10.3030"), resta);
    }

    public void testRestarConCantidadesDiferentesDecimales() {
        BigDecimal n1 = new BigDecimal("2250.22");
        BigDecimal n2 = new BigDecimal("1455.1221");
        BigDecimal sum = MoneyTools.restar(n1, n2);
        assertEquals(new BigDecimal("795.10"), sum);
    }

    public void testMultiplicar() {
        BigDecimal cantidad1 = new BigDecimal("61.50");
        BigDecimal cantidad2 = new BigDecimal("3.45");
        BigDecimal result = MoneyTools.multiplicar(cantidad1, cantidad2);
        assertEquals(new BigDecimal("212.18"), result);
    }

    public void testMultiplicarCon4Decimales() {
        BigDecimal cantidad1 = new BigDecimal("61.5022");
        BigDecimal cantidad2 = new BigDecimal("3.4511");
        BigDecimal result = MoneyTools.multiplicar(cantidad1, cantidad2, 4);
        assertEquals(new BigDecimal("212.2502"), result);
    }

    public void testMultiplicarConCantidadesDiferentesDecimales() {
        BigDecimal n1 = new BigDecimal("2250.22");
        BigDecimal n2 = new BigDecimal("1455.1221");
        BigDecimal sum = MoneyTools.multiplicar(n1, n2);
        assertEquals(new BigDecimal("3274344.85"), sum);
    }

    public void testDivision() {
        BigDecimal cantidad1 = new BigDecimal("-61.50");
        BigDecimal cantidad2 = new BigDecimal("3.45");        
        BigDecimal result = MoneyTools.dividir(cantidad1, cantidad2);
        assertEquals(new BigDecimal("-17.83"), result);
    }

    public void testDivisionCon4Decimales() {
        BigDecimal cantidad1 = new BigDecimal("61.5013");
        BigDecimal cantidad2 = new BigDecimal("3.4522");
        BigDecimal result = MoneyTools.dividir(cantidad1, cantidad2,4);
        assertEquals(new BigDecimal("17.8151"), result);
    }

    public void testDivisionConCantidadesDiferentesDecimales() {
        BigDecimal n1 = new BigDecimal("2250.22");
        BigDecimal n2 = new BigDecimal("14.1221");
        BigDecimal sum = MoneyTools.dividir(n1, n2);
        assertEquals(new BigDecimal("159.34"), sum);
    }
   
    public void testSumarTodo() {
        List<BigDecimal> listaASumar = new ArrayList<BigDecimal>();
        listaASumar.add(new BigDecimal("20.00"));
        listaASumar.add(new BigDecimal("30.00"));
        listaASumar.add(new BigDecimal("89.00"));
        BigDecimal result = MoneyTools.sumarTodo(listaASumar);
        assertEquals(new BigDecimal("139.00"), result);
    }

    public void testSumarTodoEmptyList(){
        List<BigDecimal> listaASumar = new ArrayList<BigDecimal>();
        BigDecimal result = null;
        try {
         result = MoneyTools.sumarTodo(listaASumar);
        } catch (IllegalArgumentException iae) {
        assertNull(result);
        }
        try {
         result = MoneyTools.sumarTodo(listaASumar,4);
        } catch (IllegalArgumentException iae) {
        assertNull(result);
        }
    }

    public void testSumarTodoCon4Decimales() {
        List<BigDecimal> listaASumar = new ArrayList<BigDecimal>();
        listaASumar.add(new BigDecimal("20.1010"));
        listaASumar.add(new BigDecimal("30.1010"));
        listaASumar.add(new BigDecimal("89.1010"));
        BigDecimal result = MoneyTools.sumarTodo(listaASumar,4);
        assertEquals(new BigDecimal("139.3030"), result);
    }

    public void testSumarTodoConVarargs() {
        BigDecimal b1 = new BigDecimal("20.1010");
        BigDecimal b2 = new BigDecimal("30.1020");
        BigDecimal b3 = new BigDecimal("89.2222");
        BigDecimal result = MoneyTools.sumarTodo(b1,b2,b3);
        assertEquals(new BigDecimal("139.42"), result);
    }

    public void testSumarTodoConVarargsCon4Decimales() {
        BigDecimal b1 = new BigDecimal("20.1010");
        BigDecimal b2 = new BigDecimal("30.1020");
        BigDecimal b3 = new BigDecimal("89.2222");
        BigDecimal result = MoneyTools.sumarTodo(4, b1,b2,b3);
        assertEquals(new BigDecimal("139.4252"), result);
    }

    public void testRestarTodo() {
        List<BigDecimal> listaARestar = new ArrayList<BigDecimal>();
        listaARestar.add(new BigDecimal("100.00"));
        listaARestar.add(new BigDecimal("30.00"));
        listaARestar.add(new BigDecimal("20.00"));
        BigDecimal result = MoneyTools.restarTodo(listaARestar);
        assertEquals(new BigDecimal("50.00"), result);
    }

    public void testRestarTodoEmptyList(){
        List<BigDecimal> listaARestar = new ArrayList<BigDecimal>();
        BigDecimal result = null;
        try {
         result = MoneyTools.restarTodo(listaARestar);
        } catch (IllegalArgumentException iae) {
        assertNull(result);
        }
        try {
         result = MoneyTools.restarTodo(listaARestar,4);
        } catch (IllegalArgumentException iae) {
        assertNull(result);
        }
    }

    public void testRestarTodoCon4Decimales() {
        List<BigDecimal> listaASumar = new ArrayList<BigDecimal>();
        listaASumar.add(new BigDecimal("100.1010"));
        listaASumar.add(new BigDecimal("30.1010"));
        listaASumar.add(new BigDecimal("20.1010"));
        BigDecimal result = MoneyTools.restarTodo(listaASumar,4);
        assertEquals(new BigDecimal("49.8990"), result);
    }

    public void testRestarTodoConVarargs() {
        BigDecimal b1 = new BigDecimal("100.00");
        BigDecimal b2 = new BigDecimal("30.00");
        BigDecimal b3 = new BigDecimal("20.00");
        BigDecimal result = MoneyTools.restarTodo(b1,b2,b3);
        assertEquals(new BigDecimal("50.00"), result);
    }

    public void testRestarTodoConVarargsCon4Decimales() {
        BigDecimal b1 = new BigDecimal("100.2020");
        BigDecimal b2 = new BigDecimal("30.1515");
        BigDecimal b3 = new BigDecimal("20.1010");
        BigDecimal result = MoneyTools.restarTodo(4,b1,b2,b3);
        assertEquals(new BigDecimal("49.9495"), result);
    }

    public void testRestarTodoConVarargsNoArguments() {
        BigDecimal result = null;
        try {
        result = MoneyTools.restarTodo();
        } catch (IllegalArgumentException iae) {
        assertNull(result);
        }
    }

    public void testPorciento() {
        BigDecimal cantidad = new BigDecimal("150.45");
        BigDecimal porciento = new BigDecimal("16");
        BigDecimal result = MoneyTools.porcentaje(cantidad, porciento);
        assertEquals(new BigDecimal("24.07"), result);
    }

    public void testPorcientoCon4Decimales() {
        BigDecimal cantidad = new BigDecimal("150.4522");
        BigDecimal porciento = new BigDecimal("16.3521");
        BigDecimal result = MoneyTools.porcentaje(cantidad, porciento,4);
        assertEquals(new BigDecimal("24.6021"), result);
    }

    public void testPrint() {
        BigDecimal cantidad = new BigDecimal("121528.26");
        String representacion = MoneyTools.print(cantidad);
        assertEquals("121.528,26", representacion);
    }

    public void testPrintEuroFormato() {
        BigDecimal cantidad = new BigDecimal("121528.26");
        String representacion = MoneyTools.print(cantidad,
                MoneyTools.EURO_FORMAT);
        assertEquals("121.528,26", representacion);
    }

    public void testPrintUsaFormato() {
        BigDecimal cantidad = new BigDecimal("121528.26");
        String representacion = MoneyTools.print(cantidad,
                MoneyTools.USA_FORMAT);
        assertEquals("121,528.26", representacion);
    }

}
