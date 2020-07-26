/*
* Generador de licencias v1.0.0
*
* @Author: Ismael Romero
*
* la instancia de la clase junto con el metodo Generate, retorna una cadena de texto
* coon los datos de la licencia. para esta version la licensia retornada incluye:
* 1- Serie: A, B, C ... Z o el valor designado propio
* 2- Tipo de licencia: Paga, Demo, Gratis
* 3- Nombre corto de la licencia
* 4- Dia - valor de 1 a 2 digitos
* 5- Mes - valor de 1 a 2 digitos
* 6- Año - valor de 4 digitos
* 7- Numero de licencias activas
* 8- Codigo de activacion - Valor de 4 digitos
* 9- Codigo de activacion - Valor de 4 digitos
*
* Ejemplo de licencias retornada:
*
* A-D-ADFDS-26-6-2020-0010-8556-5588    Serie A, tipo Demo
* A-F-ADFDS-26-6-2020-0120-4817-8873    Seria A, tipo Gratuita
* A-P-ADFDS-26-6-2020-2400-7815-3245    Serie A, tipo paga
* */

import java.util.Calendar;

@SuppressWarnings("all")
public class licenseGenerator {

    private String license;

    private String generate(String _Serie, int _Type, String _Name, String numLicense){
        switch (_Type){
            case 1:
                license = _Serie+"-D-"+sliceName(_Name)+"-"+getDateActivation()+"-"+numLicenses(numLicense)+"-"+getCodeActivation()+"-"+getCodeActivation();
                break;
            case 2:
                license = _Serie+"-F-"+sliceName(_Name)+"-"+getDateActivation()+"-"+numLicenses(numLicense)+"-"+getCodeActivation()+"-"+getCodeActivation();
                break;
            case 3:
                license = _Serie+"-P-"+sliceName(_Name)+"-"+getDateActivation()+"-"+numLicenses(numLicense)+"-"+getCodeActivation()+"-"+getCodeActivation();
                break;
            default:
                license  = "X-X-XXXXX-XX-X-XXXX-XXXX-XXXX-XXXX";
        }
        return license;
    }
    /*
    * Metodo para acortar el nombre en caso de que el nombre sea demasiado grande
    * Unicamente se podra tener una longitud maxima de 5
    * */
    private String sliceName(String name){
        String aux_short = "";
        int _size = name.length();

        name = name.toUpperCase();

        if(_size == 5){
            aux_short = name;
        }else if(_size > 5){
            for(int i = 0; i < _size; i++ ){
                if (i == 5) { break; } else {
                    aux_short = aux_short + name.charAt(i);
                }
            }
        }
        return aux_short;
    }

    /*
    * Metodo para obtener la fecha en que la licencia es creada
    * */
    private String getDateActivation(){
        Calendar calendar = Calendar.getInstance();
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        String month = Integer.toString(calendar.get(Calendar.MONTH));
        String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));

        return day+"-"+month+"-"+year;
    }
    /*
    * Metodo para obtener un codigo de activacion de 4 digitos los cuales son obtenido de manera
    * aleatoria de 0 a 9 por cada interacion
    * */
    private String getCodeActivation(){
        String code = "";
        for (int i = 0; i < 4; i++){
            int numCode = (int) Math.floor(Math.random()*(0-9+1)+9);
            code += numCode;
        }
        return code;
    }

    /*
    * Metodo para establecer la cadena de cantidad de licencias adquiridas por un cliente
    * */
    private String numLicenses(String num){
        String numLicense = "";
        switch (num.length()){
            case 1:
                numLicense = "000"+num;
                break;
            case 2:
                numLicense = "00"+num;
                break;
            case 3:
                numLicense = "0"+num;
                break;
            case 4:
                numLicense = num;
                break;
            default:
                numLicense = "0000";
                break;
        }
        return numLicense;
    }

    public static void main(String [] args){
        for (int i = 0; i < 1000; i++){
            System.out.println(new licenseGenerator().generate("A",3,"FREEE", Integer.toString(i)));
        }
    }
}
