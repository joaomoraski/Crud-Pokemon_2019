package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author teles
 */
public class Tools {

    public String primeiraLetraMaiscula(String s) {
        return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, s.length());
    }

    public String primeiraLetraMinuscula(String s) {
        return String.valueOf(s.charAt(0)).toLowerCase() + s.substring(1, s.length());
    }

    public String converteDeDateParaString(Date data) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return simpleDateFormat.format(data); //converte a data para string
        } catch (Exception e) {
            return null;//se algo estiver errado na data, retorne null
            //tem que tratar o erro na classe que chamou
        }
    }

    public Date converteDeStringParaDate(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return simpleDateFormat.parse(s);//converte
        } catch (Exception e) {
            return null;// se algo estiver errado, retorne null
        }
    }

}
