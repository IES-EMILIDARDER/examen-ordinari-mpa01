package examen.utils;

import EXAMEN.model.*;
import java.io.BufferedWriter;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GestorExamen {
    private Set<Department> departments = new HashSet<>();
    private Map<String, Employee> employees = new HashMap<>();
    private Map<Department, List<Employee>> departmentsXemployees = new HashMap<>();
    
    
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);

    public void carregaDades()  throws SQLException, IOException {
        /* 1. Carregar les estructures:
            'departments'
            'empleats'
            (1,50 punts) Map<Department, List<Employee>> departmentsXempleats;
         */
        String server ="jdbc:mysql://192.168.126.245:3306/";
        String dbase = "gbd";
        String user = "root";
        String passwd = "";

        String sql = """
                     SELECT email, first_name, last_name, e.department_id, department_name
                     FROM departments d, employees e
                     WHERE d.department_id = e.department_id
                     """;
       
    }

    
    public void mostraDepartments() throws SQLException, IOException {
        /*
           2. Mostra 'departments'
        */
        String sql = """
                     SELECT department_id, department_name
                     FROM departments
                     """;
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql, (String) "departments" ) ) {
            while (resultSet.next()) 
                departments.add(new Department(resultSet.getInt("department_id"),
                                               resultSet.getString("department_name") )
                );
            
            departments.stream().forEach(System.out::println);
        } catch (SQLException | IOException e) {
            System.err.println("Error carregant departaments BBDD: " + e.getMessage());
        }
        System.out.println("DEPARTMENTS");

    }   

    public void mostraEmployees() {
        /*
           2. Mostra 'employees'
        */
        String sql = """
                     SELECT first_name, last_name, email
                     FROM employees e;
                     """;
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql, (String) "employees" ) ) {
            Set<Department> Department;
            while (resultSet.next()) 
                employees.values().stream().toList().add((new Employee(resultSet.getString("first_name"),
                                                resultSet.getString("last_name"),
                                                resultSet.getString("email") ) )
                        );
                        
            
            employees.values().stream().forEach(System.out::println);
        } catch (SQLException | IOException e) {
            System.err.println("Error carregant empleats BBDD: " + e.getMessage());
        }
        
        System.out.println("EMPLOYEES");
    } 
    
    public void mostraDepartmentsXEmployees() {
        /*
           2. Mostra 'departmentsXemployees'
        */
        System.out.println("DEPARTMENTS X EMPLOYEES");

    } 
    
    public void desaDepartmentsXEmpleatsCSV(String path) {
        /*
           3. Emmagatzema 'departmentsXemployees' en un arxiu .csv amb el següent format:
              #departmentId, name, email1;email2;email3;...;
        */
        
    }

}
