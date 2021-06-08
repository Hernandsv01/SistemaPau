package tools;

import java.util.List;

public class Clase {
    
    public static String setDBValue(String value){
        String returnValue = "";
        switch(value){
            case "Lunes":
                returnValue = "0";
                break;
            case "Martes":
                returnValue = "1";
                break;
            case "Miercoles":
                returnValue = "2";
                break;
            case "Jueves":
                returnValue = "3";
                break;
            case "Viernes":
                returnValue = "4";
                break;
            case "Sabado":
                returnValue = "5";
                break;
        }
        return returnValue;
    }
    
    public static String setClassValue(String value){
        String returnValue = "";
        switch(value){
            case "0":
                returnValue = "Lunes";
                break;
            case "1":
                returnValue = "Martes";
                break;
            case "2":
                returnValue = "Miercoles";
                break;
            case "3":
                returnValue = "Jueves";
                break;
            case "4":
                returnValue = "Viernes";
                break;
            case "5":
                returnValue = "Sabado";
                break;
        }
        return returnValue;
    }
    
    public static String generateClassID(String dia, String horas, String mins){
        String ID = "";
        ID += dia.charAt(0);
        ID = ID.toUpperCase();
        ID += dia.charAt(1);
        ID += horas;
        ID += mins;
        System.out.println("ID: " + ID);
        return ID;
    }
    
    public static String generateClassIDFromDisplay(String display){
        String[] diahorario = display.split(" - ");
        String[] horamins = diahorario[1].split(":");
        
        String ID = "";
        ID += diahorario[0].charAt(0);
        ID = ID.toUpperCase();
        ID += diahorario[0].charAt(1);
        ID += horamins[0];
        ID += horamins[1];
        System.out.println("ID: " + ID);
        
        return ID;
    }
    
    public static String generateDisplayFromClassID(String ID){
        String display = "";
        switch(ID.charAt(0)){
            case 'L':
                display += "Lunes - ";
                break;
            case 'M':
                if(ID.charAt(1) == 'a'){
                    display += "Martes - ";
                }else{
                    display += "Miercoles - ";
                }
                break;
            case 'J':
                display += "Jueves - ";
                break;
            case 'V':
                display += "Viernes - ";
                break;
            case 'S':
                display += "Sabado - ";
                break;
        }
        display += ID.charAt(2);
        display += ID.charAt(3);
        display += ":";
        display += ID.charAt(4);
        display += ID.charAt(5);
        System.out.println("Display de ID: " + display);
        
        return display;
    }
    
    public static void updateClassNumber(){
        String statement = "SELECT `ID` FROM `clasesemanal`";
        List<String[]> list = DBConnection.getInstance().selectStatement(statement, 1);
        
        for(int i = 0; i < list.size(); i++){
            String updstatement = "UPDATE `clasesemanal` AS cs SET cs.`Cantidad` = (SELECT COUNT(*) FROM `clasesalumnos` AS ca WHERE ca.`id_clase` = '" + list.get(i)[0] + "') WHERE `ID` = '" + list.get(i)[0] + "'";
            DBConnection.getInstance().modificationStatement(updstatement);
        }
    }
    
    public static int getPositionFromTime(String time){
        int position = 23;
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        
        switch(hours){
            case 8:
                if(minutes == 30){
                    position = 1;
                }else{
                    position = 0;
                }
                break;
            case 9:
                if(minutes == 30){
                    position = 3;
                }else{
                    position = 2;
                }
                break;
            case 10:
                if(minutes == 30){
                    position = 5;
                }else{
                    position = 4;
                }
                break;
            case 11:
                if(minutes == 30){
                    position = 7;
                }else{
                    position = 6;
                }
                break;
            case 12:
                if(minutes == 30){
                    position = 9;
                }else{
                    position = 8;
                }
                break;
            case 13:
                if(minutes == 30){
                    position = 11;
                }else{
                    position = 10;
                }
                break;
            case 14:
                if(minutes == 30){
                    position = 13;
                }else{
                    position = 12;
                }
                break;
            case 15:
                if(minutes == 30){
                    position = 15;
                }else{
                    position = 14;
                }
                break;
            case 16:
                if(minutes == 30){
                    position = 17;
                }else{
                    position = 16;
                }
                break;
            case 17:
                if(minutes == 30){
                    position = 19;
                }else{
                    position = 18;
                }
                break;
            case 18:
                if(minutes == 30){
                    position = 21;
                }else{
                    position = 20;
                }
                break;
            case 19:
                if(minutes == 30){
                    position = 23;
                }else{
                    position = 22;
                }
                break;
        }
        
        return position;
    }
    
    public static int getDurationFromTime(String time){
        int duration = 0;
        switch(time){
            case "00:30":
                duration = 1;
                break;
            case "01:00":
                duration = 2;
                break;
            case "01:30":
                duration = 3;
                break;
            case "02:00":
                duration = 4;
                break;
            case "02:30":
                duration = 5;
                break;
            case "03:00":
                duration = 6;
                break;
        }
        return duration;
    }
}
