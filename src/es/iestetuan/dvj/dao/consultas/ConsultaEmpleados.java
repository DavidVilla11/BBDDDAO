package es.iestetuan.dvj.dao.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import es.iestetuan.dvj.dao.IEmpleados;
import es.iestetuan.dvj.dao.vo.Empleados;

public class ConsultaEmpleados implements IEmpleados {
	
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
	public void crearEmpleado(Empleados empleado) {
	
        int NumEmpleado = empleado.getNumEmpleado();
        String Apellido = empleado.getApellido();
        String Oficio = empleado.getOficio();
        int CodigoDirector = empleado.getCodigoDirector();
        String FechaAlta = empleado.getFechaAlta();
        float Salario = empleado.getSalario();
        float Comision = empleado.getComision();
        int NumDept = empleado.getNumDept();
            
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "insert into empleados values('" +NumEmpleado+ "', '" +Apellido+
                                  "', '" +Oficio+ "', '" +CodigoDirector+ "', '" +FechaAlta+ "', '" +Salario+ 
                                  "', '" +Comision+ "', '" +NumDept+ "' )";
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
	public void modificarEmpleado(Empleados empleado) {
        int NumEmpleado = empleado.getNumEmpleado();
        String Apellido = empleado.getApellido();
        String Oficio = empleado.getOficio();
        int CodigoDirector = empleado.getCodigoDirector();
        String FechaAlta = empleado.getFechaAlta();
        float Salario = empleado.getSalario();
        float Comision = empleado.getComision();
        int NumDept = empleado.getNumDept();
        //COMO OBTENER ESTOS DATOS
        String NuevoNumEmpleado = null;
        String NuevoSalario = null;
        
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "UPDATE empleados set emp_no = '" + NuevoNumEmpleado + "' AND salario = '" + NuevoSalario + 
                    "' WHERE emp_no = '" +NumEmpleado+ "' AND dept_no = '" + NumDept + "'";
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
	public void borrarEmpleado(int idEmpleado) {
		
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            // Deleting from database
            String q1 = "DELETE from empleados WHERE emp_no = '" + idEmpleado +
                  "'";     
            
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
	public void consultarEmpleado(int idEmpleado) {
		
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "select * from empleados WHERE emp_no = '" + idEmpleado + "'" ;
			ResultSet rs = stmt.executeQuery(q1);
			 if (rs.next())
			   {
			       System.out.println("Dept_no : " + rs.getString(1));
			       System.out.println("Emp_no :" + rs.getString(2));
			       System.out.println("Apellido :" + rs.getString(3));
			       System.out.println("Oficio :" + rs.getString(4));
			       System.out.println("dir :" + rs.getString(5));
			       System.out.println("Fecha_Alta :" + rs.getString(6));
			       System.out.println("salario :" + rs.getString(7));
			       System.out.println("dnombre :" + rs.getString(9));
			       System.out.println("localizacion :" + rs.getString(10));
			       
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

	@Override
	public void consultarEmpleadosApellidoSalario(String apellido, Float salario) {
		
		
		
	}

}
