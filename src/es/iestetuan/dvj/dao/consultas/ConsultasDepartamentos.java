package es.iestetuan.dvj.dao.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import es.iestetuan.dvj.dao.IDepartamentos;
import es.iestetuan.dvj.dao.vo.Departamentos;

public class ConsultasDepartamentos implements IDepartamentos {
	
	
	public static Connection getConexion() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/aadd", "DVilla11", "admin");
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
		
        int DeptNum = departamento.getDeptNum();
        String DeptNombre = departamento.getDeptNombre();
        String DeptLocalizacion = departamento.getLocalizacion();
            
        try
        {
            Connection conexion =getConexion();
            String SentenciaSQL = "insert into departamentos values(?, ? , ?)";
            PreparedStatement statement = conexion.prepareStatement(SentenciaSQL);
            statement.setInt(1, DeptNum); 
            statement.setString(2, DeptNombre);
            statement.setString(3, DeptLocalizacion);
            int x = statement.executeUpdate();
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
		
        int DeptNum = departamento.getDeptNum();
        String DeptNombre = departamento.getDeptNombre();
        //HABRIA QUE CREAR OTRO PARAMETRO PARA A�ADIR NUEVO VALOR
        String DatoModificar = "Informatica y Comunicaciones";
        try
        {
            Connection conexion =getConexion();
            String SentenciaSQL = "UPDATE departamentos set dnombre = ?, WHERE dept_no = ?, AND dnombre = ?";
            PreparedStatement statement = conexion.prepareStatement(SentenciaSQL);

            statement.setString(1, DatoModificar);
            statement.setInt(2, DeptNum); 
            statement.setString(3, DeptNombre);

            int x = statement.executeUpdate();
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
            
            // Deleting from database
            String SentenciaSQL = "DELETE from departamentos WHERE dept_no = ?";     
            PreparedStatement statement = conexion.prepareStatement(SentenciaSQL);
            statement.setInt(1, idDepartamento);
            int x = statement.executeUpdate(SentenciaSQL);
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
