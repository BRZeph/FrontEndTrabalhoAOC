import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    private static HashMap<Double, Integer> rest = new HashMap<>();
    public static List<String> erros =  new ArrayList<>();
    private static HashMap<Character, Integer> extendedNumbers = new HashMap<>();
    public static HashMap<Double, Integer> getRest(){
        return rest;
    }
    public static void registerLetters(){
        extendedNumbers.put('a',10);
        extendedNumbers.put('b',11);
        extendedNumbers.put('c',12);
        extendedNumbers.put('d',13);
        extendedNumbers.put('e', 14);
        extendedNumbers.put('f', 15);
        extendedNumbers.put('g', 16);
        extendedNumbers.put('h', 17);
        extendedNumbers.put('i', 18);
        extendedNumbers.put('j', 19);
        extendedNumbers.put('k', 20);
        extendedNumbers.put('l', 21);
        extendedNumbers.put('m', 22);
        extendedNumbers.put('n', 23);
        extendedNumbers.put('o', 24);
        extendedNumbers.put('p', 25);
        extendedNumbers.put('q', 26);
        extendedNumbers.put('r', 27);
        extendedNumbers.put('s', 28);
        extendedNumbers.put('t', 29);
        extendedNumbers.put('u', 30);
        extendedNumbers.put('v', 31);
        extendedNumbers.put('w', 32);
        extendedNumbers.put('x', 33);
        extendedNumbers.put('y', 34);
        extendedNumbers.put('z', 35);
    }
    public static void allowedNumberBaseCombination(String numeroInicial, double baseInicial){
        System.out.println("checando se o número " + numeroInicial + " é permitido na base " + baseInicial);
        boolean numeroPermitido = true;
        for (char digitChar : numeroInicial.toCharArray()){
            if (isNumericValue(digitChar)){
                double digitValue = getNumericValue(digitChar);
                if (digitValue >= baseInicial){
                    numeroPermitido = false;
                    System.out.println("Numero " + numeroInicial + " NÃO permitido na base " + baseInicial);
                    Utils.erros.add("Número inicial maior que a base inicial");
                }
            }
        }
        if (numeroPermitido) {
            System.out.println("Numero " + numeroInicial + " permitido na base " + baseInicial);
        }
    }
    public static boolean isNumericValue(char c){
        System.out.println("Checando se " + c + " é um dígito aceitável");
        if (Character.isDigit(c)){
            System.out.println(c + " é um número permitido");
            return true;
        }
        for (char c2 : extendedNumbers.keySet()){
            if (Character.toLowerCase(c) == c2){
                System.out.println(c + " é uma letra permitida");
                return true;
            }
        }
        System.out.println(c + " nao é um dígito permitido");
        erros.add("Número nao registrado: " + c);
        return false;
    }
    public static double getNumericValue(char c){
        System.out.println("Procurando o valor número de " + c);
        if (Character.isDigit(c)){
            System.out.println(c + " é um número, retornando " + c);
            return Character.getNumericValue(c);
        }
        for (char c2 : extendedNumbers.keySet()){
            if (Character.toLowerCase(c) == c2){
                System.out.println(c + " é uma letra, retornando " + extendedNumbers.get(c2));
                return extendedNumbers.get(c2);
            }
        }
        throw new IllegalArgumentException();
    }
    public static String getLetterValue(double i){
        System.out.println("Transformando " + i + " em letra");
        if (i < 10){
            System.out.println("Valor " + i + " numérico, retornando " + i);
            return String.valueOf((int) i);
        } else {
            for (char c : extendedNumbers.keySet()){
                if (extendedNumbers.get(c) == i){
                    System.out.println("Valor encontrado para " + i + ": " + c);
                    return String.valueOf(c);
                }
            }
            erros.add("Número nao registrado: " + i);
            return null;
        }
    }
    public static String transformToBase10(String numeroInicial, int baseInicial) {
        System.out.println("Transformando (" + numeroInicial + ")" + baseInicial + " para base 10");
        String temp = numeroInicial;

        BigDecimal base = new BigDecimal(baseInicial);
        BigDecimal finalNumber = BigDecimal.ZERO;
        int length = numeroInicial.length();

        for (int i = 0; i < length; i++) {
            char digitChar = numeroInicial.charAt(i);
            BigDecimal digitValue = BigDecimal.valueOf(Character.getNumericValue(digitChar));
            BigDecimal power = base.pow(length - 1 - i);
            BigDecimal additive = digitValue.multiply(power);
            finalNumber = finalNumber.add(additive);
            System.out.println("Final Number: " + finalNumber.toPlainString());
        }

        System.out.println("numero transformado: (" + temp + ")" + baseInicial + " = (" + finalNumber.toPlainString() + ")10");
        return finalNumber.toPlainString();
    }


    public static String transformFromBase10(String numeroInicial, double baseFinal){
        System.out.println("Transformando (" + numeroInicial + ")10 para base " + baseFinal);

        boolean dividing = true;
        double count = 1;
        double firstDividend = Double.parseDouble(numeroInicial);
        while (dividing) {
            double newDividend = firstDividend / (Math.pow(baseFinal, count - 1));
            double quotient = newDividend / baseFinal;
            int newRemainder = (int) (newDividend % baseFinal);
            rest.put(count, newRemainder);
            count++;
            if (quotient < 1) {
                dividing = false;
            }
        }
        StringBuilder sb = new StringBuilder(rest.size());
        for (double i = rest.size(); i > 0; i--) {
            int j = rest.get(i);
            String append = getLetterValue(j).toUpperCase();
            sb.append(append);
        }

        System.out.println("numero transformado: (" + numeroInicial + ")10 = (" + sb + ")" + baseFinal);
        return sb.toString();
    }
    public static boolean baseAceitavel(String base){
        System.out.println("Checando se a base " + base + " é permitida");
        for(char c : base.toCharArray()){
            if(!Character.isDigit(c)){
                Utils.erros.add("A base " + base + " não é um número entre 2 e 35");
                System.out.println("BASE ILEGAL ENCONTRADA: A base " + base + " não é um número entre 2 e 35");
                return false;
            }
        }
        if(Integer.parseInt(base) > 36 || Integer.parseInt(base) < 2){
            Utils.erros.add("A base " + base + " nao está entre 2 e 35");
            System.out.println("BASE ILEGAL ENCONTRADA: A base " + base + " não está entre 2 e 35");
            return false;
        }
        System.out.println("Base permitida: " + base);
        return true;
    }
}