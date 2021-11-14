package es.iestetuan.dvj.dao.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import es.iestetuan.dvj.dao.IDepartamentos;
import es.iestetuan.dvj.dao.vo.Departamentos;

public class ConsultasDepartamentos implements IDepartamentos {
	
	
	public static Connection getConexion() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://dam2.actividad,cf:5432/aadd-dam2", "aadd", "d1m2p0sgr3sql");
            if (conexion != null)            
                System.out.println("Connected");           
            else          
                System.out.println("Not Connected");         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conexion;
		
	}

	@Override
	public void crearDepartamento(Departamentos departamento) {
		
        int DeptNum = 50;
        String DeptNombre = "Informática";
        String DeptLocalizacion = "Madrid";
            
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "insert into departamentos values('" +DeptNum+ "', '" +DeptNombre+
                                  "', '" +DeptLocalizacion+ "')";
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully Inserted");           
            else          
                System.out.println("Insert Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
		
	}

	@Override
	public void modificarDepartamento(Departamentos departamento) {
		
        int DeptNum = 60;
        String DeptNombre = "Comunicaciones";
        String DatoModificar = "Informatica y Comunicaciones";
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "UPDATE departamentos set dnombre = '" + DatoModificar +
                    "' WHERE dept_no = '" +DeptNum+ "' AND dnombre = '" + DeptNombre + "'";
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully update");           
            else          
                System.out.println("Update Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
	}

	@Override
	public void borrarDepartamento(int idDepartamento) {
		
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            // Deleting from database
            String q1 = "DELETE from departamentos WHERE dept_no = '" + idDepartamento + "'";     
            
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully delete");           
            else          
                System.out.println("Delete Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
	}

	@Override
	public void consultarDepartamento(int idDepartamento) {
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "select * from departamentos WHERE dept_no = '" + idDepartamento +
                    "'";
			ResultSet rs = stmt.executeQuery(q1);
			 if (rs.next())
			   {
			       System.out.println("dept_no : " + rs.getString(1));
			       System.out.println("dnombre :" + rs.getString(2));
			       System.out.println("localizacion :" + rs.getString(3
			    		   ));
			    }
			else
			{
			 System.out.println("No such user id is already registered");
			}    
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
	}

}
