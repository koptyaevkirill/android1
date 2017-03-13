package ru.startandroid.programcalc;

import android.util.Log;

public class TranslateUtils {

    public static String convert(String number, int baseFrom, int baseTo){
        Log.d("CONVERT-LONG10", Long.parseLong(number, baseFrom) + "");
        String result = Long.toString(Long.parseLong(number, baseFrom), baseTo);
        Log.d("CONVERT-RESULT", result + "");
        return result;
    }


/*
    //из 10 в 2
    public static String fromDecToBin(int chisloDec) {

        List<Integer> list = new ArrayList<>();
        Integer chastnoe = 3;
        Integer ostatok = null;

        while (chastnoe != 0) {
            chastnoe = chisloDec / 2;
            ostatok = chisloDec - chastnoe * 2;
            list.add(ostatok);
            chisloDec = chastnoe;
            Log.d("OSTATOK", ostatok + "");
        }

        Log.d("LISTSIZE", list.size() + "");
        String chisloBin = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            chisloBin = chisloBin + list.get(i);
            Log.d("LIST", chisloBin + "");
        }
        Log.d("CHISLOBIN", chisloBin + "");
        return chisloBin;
    }

    //из 10 в 8
    public static String fromDecToOct(int chisloDec) {

        List<Integer> list = new ArrayList<>();
        Integer chastnoe = 3;
        Integer ostatok = null;

        while (chastnoe != 0) {
            chastnoe = chisloDec / 8;
            ostatok = chisloDec - chastnoe * 8;
            list.add(ostatok);
            chisloDec = chastnoe;
            Log.d("OSTATOK", ostatok + "");
        }

        Log.d("LISTSIZE", list.size() + "");
        String chisloOct = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            chisloOct = chisloOct + list.get(i);
            Log.d("LIST", chisloOct + "");
        }
        Log.d("CHISLOOCT", chisloOct + "");
        return chisloOct;
    }

    //из 10 в 16
    public static String fromDecToHex(int chisloDec) {

        List<Integer> list = new ArrayList<>();
        Integer chastnoe = 3;
        Integer ostatok = null;

        while (chastnoe != 0) {
            chastnoe = chisloDec / 16;
            ostatok = chisloDec - chastnoe * 16;
            list.add(ostatok);
            chisloDec = chastnoe;
            Log.d("OSTATOK", ostatok + "");
        }

        Log.d("LISTSIZE", list.size() + "");
        String chisloHex = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            switch (list.get(i)) {
                case 10: {
                    chisloHex = chisloHex + "A";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 11: {
                    chisloHex = chisloHex + "B";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 12: {
                    chisloHex = chisloHex + "C";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 13: {
                    chisloHex = chisloHex + "D";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 14: {
                    chisloHex = chisloHex + "E";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 15: {
                    chisloHex = chisloHex + "F";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                default: {
                    chisloHex = chisloHex + list.get(i);
                    Log.d("LIST", chisloHex + "");
                    break;
                }
            }
        }
        Log.d("CHISLOHEX", chisloHex + "");
        return chisloHex;
    }

    //из 2 в 10
    public static String fromBinToDec(String chisloBin) {

        String result = "";
        String strChisloBin = chisloBin;
        Log.d("CHISLOBIN", strChisloBin + "");
        for (int i = 0; i < strChisloBin.length(); i++) {
            char chrSimvol = strChisloBin.charAt(i);
            char[] mass = {chrSimvol};
            int cifra = Integer.parseInt(new String(mass));
            result = result + cifra + "*" + "2^" + (strChisloBin.length() - i - 1) + "+";
        }
        Log.d("RESULT", result + "");
        result = result.substring(0, result.length() - 1);
        Log.d("RESULT", result + "");
        Expression expression = new Expression(result);
        int res = (int) expression.calculate();
        Log.d("RES", res + "");
        String chisloDec = String.valueOf(res);
        return chisloDec;
    }

    //из 2 в 8
    public static String fromBinToOct(String chisloBin) {

        Log.d("CHISLOBIN", "" + chisloBin);

        double del = chisloBin.length() / 3.0;
        Log.d("del", "" + del);

        String resultStr = String.valueOf(del);
        String stringAfterDot = "";
        int posDot;
        for (posDot = 1; posDot < resultStr.length(); posDot++) {
            if (resultStr.charAt(posDot) == '.') {
                stringAfterDot = resultStr.substring(posDot + 1);
                Log.d("stringAfterDot", "" + stringAfterDot);
                break;
            }
        }

        int kol = Integer.parseInt(resultStr.substring(0, posDot));
        for (int posNotZero = 0; posNotZero < stringAfterDot.length(); posNotZero++) {
            if (stringAfterDot.charAt(posNotZero) != '0') {
                kol = kol + 1;
                break;
            }
        }
        Log.d("kol", "" + kol);

        boolean check = true;
        List<String> list = new ArrayList<>();
        for (int i = chisloBin.length() - 3; i >= 0; i -= 3) {
            if (check) {
                String stroka = "";
                String str = chisloBin.substring(i);
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    char[] chars = {ch};
                    String simvol = new String(chars);
                    stroka = stroka + simvol + "*" + "2^" + (str.length() - j - 1) + "+";
                }
                Log.d("STROKA", "" + stroka);
                stroka = stroka.substring(0, stroka.length() - 1);
                Log.d("STROKA", "" + stroka);
                list.add(stroka);

                if (list.size() + 1 == kol) {
                    if (chisloBin.substring(0, i).length() < 3) {
                        String s = "";
                        String st = chisloBin.substring(0, i);
                        for (int j = 0; j < st.length(); j++) {
                            char c = st.charAt(j);
                            char[] chrs = {c};
                            String sim = new String(chrs);
                            s = s + sim + "*" + "2^" + (st.length() - j - 1) + "+";
                        }
                        Log.d("STROKA", "" + s);
                        s = s.substring(0, s.length() - 1);
                        Log.d("STROKA", "" + s);
                        list.add(s);
                    }
                }

                check = false;
            } else {
                String stroka = "";
                String str = chisloBin.substring(i, i + 3);
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    char[] chars = {ch};
                    String simvol = new String(chars);
                    stroka = stroka + simvol + "*" + "2^" + (str.length() - j - 1) + "+";
                }
                Log.d("STROKA", "" + stroka);
                stroka = stroka.substring(0, stroka.length() - 1);
                Log.d("STROKA", "" + stroka);
                list.add(stroka);

                if (list.size() + 1 == kol) {
                    if (chisloBin.substring(0, i).length() < 3) {
                        String s = "";
                        String st = chisloBin.substring(0, i);
                        for (int j = 0; j < str.length(); j++) {
                            char ch = str.charAt(j);
                            char[] chars = {ch};
                            String simvol = new String(chars);
                            s = s + simvol + "*" + "2^" + (st.length() - j - 1) + "+";
                        }
                        Log.d("STROKA", "" + stroka);
                        s = s.substring(0, s.length() - 1);
                        Log.d("STROKA", "" + s);
                        list.add(s);
                    }
                }
            }
        }

        String chisloOct = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            Expression ex = new Expression(list.get(i));
            chisloOct = chisloOct + String.valueOf((int) ex.calculate());
        }

        Log.d("CHISLOOCT", chisloOct);
        return chisloOct;
    }

    //из 2 в 16
    public static String fromBinToHex(String chisloBin) {

        Log.d("CHISLOBIN", "" + chisloBin);

        double del = chisloBin.length() / 4.0;
        Log.d("del", "" + del);

        String resultStr = String.valueOf(del);
        String stringAfterDot = "";
        int posDot;
        for (posDot = 1; posDot < resultStr.length(); posDot++) {
            if (resultStr.charAt(posDot) == '.') {
                stringAfterDot = resultStr.substring(posDot + 1);
                Log.d("stringAfterDot", "" + stringAfterDot);
                break;
            }
        }

        int kol = Integer.parseInt(resultStr.substring(0, posDot));
        for (int posNotZero = 0; posNotZero < stringAfterDot.length(); posNotZero++) {
            if (stringAfterDot.charAt(posNotZero) != '0') {
                kol = kol + 1;
                break;
            }
        }
        Log.d("kol", "" + kol);

        boolean check = true;
        List<String> list = new ArrayList<>();
        for (int i = chisloBin.length() - 4; i >= 0; i -= 4) {
            if (check) {
                String stroka = "";
                String str = chisloBin.substring(i);
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    char[] chars = {ch};
                    String simvol = new String(chars);
                    stroka = stroka + simvol + "*" + "2^" + (str.length() - j - 1) + "+";
                }
                Log.d("STROKA", "" + stroka);
                stroka = stroka.substring(0, stroka.length() - 1);
                Log.d("STROKA", "" + stroka);
                list.add(stroka);

                if (list.size() + 1 == kol) {
                    if (chisloBin.substring(0, i).length() < 4) {
                        String s = "";
                        String st = chisloBin.substring(0, i);
                        for (int j = 0; j < st.length(); j++) {
                            char c = st.charAt(j);
                            char[] chrs = {c};
                            String sim = new String(chrs);
                            s = s + sim + "*" + "2^" + (st.length() - j - 1) + "+";
                        }
                        Log.d("STROKA", "" + s);
                        s = s.substring(0, s.length() - 1);
                        Log.d("STROKA", "" + s);
                        list.add(s);
                    }
                }

                check = false;
            } else {
                String stroka = "";
                String str = chisloBin.substring(i, i + 4);
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    char[] chars = {ch};
                    String simvol = new String(chars);
                    stroka = stroka + simvol + "*" + "2^" + (str.length() - j - 1) + "+";
                }
                Log.d("STROKA", "" + stroka);
                stroka = stroka.substring(0, stroka.length() - 1);
                Log.d("STROKA", "" + stroka);
                list.add(stroka);

                if (list.size() + 1 == kol) {
                    if (chisloBin.substring(0, i).length() < 4) {
                        String s = "";
                        String st = chisloBin.substring(0, i);
                        for (int j = 0; j < str.length(); j++) {
                            char ch = str.charAt(j);
                            char[] chars = {ch};
                            String simvol = new String(chars);
                            s = s + simvol + "*" + "2^" + (st.length() - j - 1) + "+";
                        }
                        Log.d("STROKA", "" + stroka);
                        s = s.substring(0, s.length() - 1);
                        Log.d("STROKA", "" + s);
                        list.add(s);
                    }
                }
            }
        }

        String chisloHex = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            Expression ex = new Expression(list.get(i));
            switch ((int) ex.calculate()) {
                case 10: {
                    chisloHex = chisloHex + "A";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 11: {
                    chisloHex = chisloHex + "B";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 12: {
                    chisloHex = chisloHex + "C";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 13: {
                    chisloHex = chisloHex + "D";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 14: {
                    chisloHex = chisloHex + "E";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                case 15: {
                    chisloHex = chisloHex + "F";
                    Log.d("LIST", chisloHex + "");
                    break;
                }
                default: {
                    chisloHex = chisloHex + (int) ex.calculate();
                    Log.d("LIST", chisloHex + "");
                    break;
                }
            }
        }
        Log.d("CHISLOHEX", chisloHex);
        return chisloHex;
    }

    //из 8 в 10
    public static String fromOctToDec(String chisloOct) {

        String result = "";
        String strChisloOct = chisloOct;
        Log.d("CHISLOBIN", strChisloOct + "");
        for (int i = 0; i < strChisloOct.length(); i++) {
            char chrSimvol = strChisloOct.charAt(i);
            char[] mass = {chrSimvol};
            int cifra = Integer.parseInt(new String(mass));
            result = result + cifra + "*" + "8^" + (strChisloOct.length() - i - 1) + "+";
        }
        Log.d("RESULT", result + "");
        result = result.substring(0, result.length() - 1);
        Log.d("RESULT", result + "");
        Expression expression = new Expression(result);
        int res = (int) expression.calculate();
        Log.d("RES", res + "");
        String chisloDec = String.valueOf(res);
        return chisloDec;
    }*/
}
