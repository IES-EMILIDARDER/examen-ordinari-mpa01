package EXAMEN;

import examen.utils.GestorExamen;

public class Main {
    public static void main(String[] args) {
        GestorExamen gestor = new GestorExamen();
        
        try {
            gestor.carregaDades();

            gestor.mostraDepartments();
            gestor.mostraEmployees();
            gestor.mostraDepartmentsXEmployees();
            
            gestor.desaDepartmentsXEmpleatsCSV("c:\\temp\\departmentXEmpleats.cvs");

            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

/**
 * en un objeto crear departamento
 * y con este ir a buscarlo en el set, si esta
 * me quedo con el que he encontrado, y sino me quedo con el nuevo
 */