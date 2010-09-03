/*
 * MoneyTools.java
 * Clase para realizar cálculos de moneda con BigDecimals
 */
package com.utils.money;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Cristian Palau
 */
public class MoneyTools {

    private static int DECIMALS = 2;
    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
    public static final int EURO_FORMAT = 1;
    public static final int USA_FORMAT = 2;

    public static BigDecimal sumar(BigDecimal b1, BigDecimal b2) {
        return sumar(b1, b2, 2);
    }

    public static BigDecimal sumar(BigDecimal b1, BigDecimal b2,
            int numDecimals) {
        return b1.add(b2).setScale(numDecimals, ROUNDING_MODE);
    }

    public static BigDecimal restar(BigDecimal b1, BigDecimal b2) {
        return restar(b1, b2, 2);
    }

    public static BigDecimal restar(BigDecimal b1, BigDecimal b2,
            int numDecimals) {
        return b1.subtract(b2).setScale(numDecimals, ROUNDING_MODE);
    }

    public static BigDecimal multiplicar(BigDecimal b1, BigDecimal b2) {
        return multiplicar(b1, b2, 2);
    }

    public static BigDecimal multiplicar(BigDecimal b1, BigDecimal b2,
            int numDecimales) {
        return b1.multiply(b2).setScale(numDecimales, ROUNDING_MODE);
    }

    public static BigDecimal dividir(BigDecimal cantidad1,
            BigDecimal cantidad2) {
        return dividir(cantidad1, cantidad2, 2);
    }

    public static BigDecimal dividir(BigDecimal cantidad1,
            BigDecimal cantidad2,
            int numDecimals) {
        return cantidad1.divide(cantidad2, ROUNDING_MODE).
                setScale(numDecimals);
    }

    public static BigDecimal sumarTodo(List<BigDecimal> listaASumar) {
        return sumarTodo(listaASumar, 2);
    }

    public static BigDecimal sumarTodo(List<BigDecimal> listaASumar,
            int numDecimals) {
        if (listaASumar.size() == 0) {
            throw new IllegalArgumentException                    
                    ("La lista a sumar no puede estar en blanco!");
        }
        BigDecimal resultSum = new BigDecimal("0");
        for (BigDecimal b : listaASumar) {
            resultSum = resultSum.add(b).setScale(numDecimals, ROUNDING_MODE);
        }
        return resultSum;
    }
    
    public static BigDecimal sumarTodo(BigDecimal... cantidades) {
        return sumarTodo(2, cantidades);
    }

    public static BigDecimal sumarTodo(int numDecimales,
            BigDecimal... cantidades) {
        BigDecimal resultado = new BigDecimal("0");
        for(BigDecimal c: cantidades) {
             resultado = resultado.add(c)
                     .setScale(numDecimales, ROUNDING_MODE);
        }
        return resultado;
    }

    public static BigDecimal restarTodo(List<BigDecimal> listaARestar) {                
        return restarTodo(listaARestar, 2);
    }

    public static BigDecimal restarTodo(List<BigDecimal> listaARestar,
            int numDecimals) {
        if (listaARestar.size() == 0) {
            throw new IllegalArgumentException
                    ("La lista a restar no puede estar en blanco!");
        }
        BigDecimal resultRest = listaARestar.get(0);
        for (int i = 1; i < listaARestar.size(); i++) {
            resultRest = resultRest.subtract
                    (listaARestar.get(i)).setScale(numDecimals, ROUNDING_MODE);
        }
        return resultRest;
    }

    public static BigDecimal restarTodo(BigDecimal... cantidades) {
        return restarTodo(2, cantidades);
    }

    public static BigDecimal restarTodo(int numDecimales, BigDecimal... cantidades) {
        if (cantidades.length == 0) {
            throw new IllegalArgumentException
                    ("El número de argumentos para la resta no puede ser 0!");
        }
        BigDecimal resultRest = cantidades[0];
        for (int i = 1; i < cantidades.length; i++) {
            resultRest = resultRest.subtract
                    (cantidades[i]).setScale(numDecimales, ROUNDING_MODE);
        }
        return resultRest;
    }


    public static BigDecimal porcentaje(BigDecimal cantidad,
            BigDecimal porciento) {
        return porcentaje(cantidad, porciento, 2);
    }

    public static BigDecimal porcentaje(BigDecimal cantidad,
            BigDecimal porciento, int numDecimales) {
        return cantidad.multiply(porciento)
                .setScale(numDecimales, ROUNDING_MODE)
                .divide(new BigDecimal("100"))
                .setScale(numDecimales, ROUNDING_MODE);
    }

    public static String print(BigDecimal cantidad) {
      NumberFormat df = df = DecimalFormat
              .getInstance(new Locale("es","ES"));
      return df.format(cantidad);
    }

    public static String print(BigDecimal cantidad, int formato) {
        
        NumberFormat df = null;
        switch (formato) {
            case EURO_FORMAT:
                 df = DecimalFormat.getInstance(new Locale("es","ES"));
                 break;
            case USA_FORMAT:
                 df = DecimalFormat.getInstance(new Locale("us","US"));
                 break;
            default:     
                 df = DecimalFormat.getInstance(new Locale("es","ES"));
                 break;
        }
        return df.format(cantidad);
    }

}
