package io.bgroup.calc.model;

import java.util.ArrayList;

public class Calc {
    public Calc() {
    }

    public String getResult(String res) {
        char[] list = res.toCharArray();
        ArrayList<String> numbersArrayList = new ArrayList<String>();
        ArrayList<Character> signArrayList = new ArrayList<Character>();
        String a = "";
        boolean flagA = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 'p' && list[i] != '-' && list[i] != '*' && list[i] != '/') {
                flagA = true;
                a += list[i];
            } else {
                if (i == 0) {
                    if (list[i] == '-') {
                        a += list[i];
                        continue;
                    }
                    if (list[i] == 'p') {
                        continue;
                    }
                    if (list[i] == '*' || list[i] == '/') return "Error";
                }
                numbersArrayList.add(a);
                a = "";
                flagA = false;
                signArrayList.add(list[i]);
            }
        }
        if (flagA) numbersArrayList.add(a);
        double summ = 0;
        for (int i = 0; i < numbersArrayList.size(); i++) {
            if (!isValidNumber(numbersArrayList.get(i))) return "Error";
            if (i == 0) {
                summ += getSum("0", numbersArrayList.get(i), 'p');
                continue;
            }
            summ = getSum("" + summ, numbersArrayList.get(i), signArrayList.get(i - 1));
        }
        return summ + "";
    }

    private Double getSum(String a, String b, char sing) {
        double summ = 0.0;
        if (sing == 'p') summ = Double.parseDouble(a) + Double.parseDouble(b);
        if (sing == '-') summ = Double.parseDouble(a) - Double.parseDouble(b);
        if (sing == '*') summ = Double.parseDouble(a) * Double.parseDouble(b);
        if (sing == '/') {
            if (Double.parseDouble(b) == 0) return 0.0;
            summ = Double.parseDouble(a) / Double.parseDouble(b);
        }
        return summ;
    }

    private boolean isValidNumber(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
