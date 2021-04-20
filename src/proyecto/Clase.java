package proyecto;

public class Clase {
    
    public String setDBValue(String value){
        System.out.println("Value received: " + value);
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
        System.out.println("Value returned: " + returnValue);
        return returnValue;
    }
    
    public String setClassValue(String value){
        System.out.println("Value Received: " + value);
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
        System.out.println("Value returned: " + returnValue);
        return returnValue;
    }
    
    public String generateClassID(String dia, String horas, String mins){
        String ID = "";
        ID += dia.charAt(0);
        ID = ID.toUpperCase();
        ID += dia.charAt(1);
        ID += horas;
        ID += mins;
        System.out.println("ID: " + ID);
        return ID;
    }
}
