package tools;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno {

    public static String getDNIFromName(String name){
        String statement = "SELECT `DNI` FROM `alumnos` WHERE `Nombre` = '" + name + "'";
        List<String[]> DNI = DBConnection.getInstance().selectStatement(statement, 1);
        System.out.println("DNI: " + DNI.get(0)[0]);
        return DNI.get(0)[0];
    }
    public static String getNameFromDNI(String DNI){
        String statement = "SELECT `Nombre` FROM `alumnos` WHERE `DNI` = '" + DNI + "'";
        List<String[]> nombre = DBConnection.getInstance().selectStatement(statement, 1);
        System.out.println("Nombre: " + nombre.get(0)[0]);
        return nombre.get(0)[0];
    }
    
    public static void checkWeekBirthdays(){
        List<String[]> cumplesSemana = new ArrayList();
        LocalDate currentDate = LocalDate.now();
        LocalDate dateNextSunday = currentDate.plusDays(6);
        
        String statement = "SELECT `nombre`, `fechanacimiento` FROM `alumnos`";
        List<String[]> listCumples = DBConnection.getInstance().selectStatement(statement, 2);
        for(int i = 0; i < listCumples.size(); i++){
            if(listCumples.get(i)[1] != null){
                String[] yearMonthDay = listCumples.get(i)[1].split("-");
                LocalDate cumple = LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));
                if((cumple.isEqual(currentDate)|| cumple.isAfter(currentDate)) && (cumple.isEqual(dateNextSunday) || cumple.isBefore(dateNextSunday))){
                    cumplesSemana.add(listCumples.get(i));
                }
            }
        }
        if(!cumplesSemana.isEmpty()){
            new PopupBirthweeks(cumplesSemana).setVisible(true);
        }
    }
    public static void checkTodayBirthday(){
        LocalDate currentDate = LocalDate.now();
        String statement = "SELECT `nombre`, `fechanacimiento` FROM `alumnos`";
        List<String[]> listCumples = DBConnection.getInstance().selectStatement(statement, 2);
        for(int i = 0; i < listCumples.size(); i++){
            if(listCumples.get(i)[1] != null){
                String[] yearMonthDay = listCumples.get(i)[1].split("-");
                LocalDate cumple = LocalDate.of(LocalDate.now().getYear(), Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));
                if(cumple.isEqual(currentDate)){
                    new PopupMessage("Hoy cumple " + listCumples.get(i)[0] + "!!!", Color.BLACK).setVisible(true);
                }
            }
        }
    }
    
    public static int getAge(String fecha){
        LocalDate currentDate = LocalDate.now();
        if(fecha != null){
            String[] yearMonthDay = fecha.split("-");
            LocalDate cumple = LocalDate.of(Integer.parseInt(yearMonthDay[0]), Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));

            int age = currentDate.getYear() - cumple.getYear();
            if(cumple.getMonthValue() > currentDate.getMonthValue() || (cumple.getMonthValue() == currentDate.getMonthValue() && cumple.getDayOfMonth() > currentDate.getDayOfMonth())){
                age--;
            }
            return age;
        }else{
            return 0;
        }
    }
    
}
