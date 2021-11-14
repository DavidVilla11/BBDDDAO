package es.iestetuan.dvj.dao;

import es.iestetuan.dvj.dao.vo.Empleados;

public interface IEmpleados {

	public void crearEmpleado(Empleados empleado);
	public void modificarEmpleado(Empleados empleado);
	public void borrarEmpleado(int idEmpleado);
	public void consultarEmpleado(int idEmpleado);
	public void consultarEmpleadosApellidoSalario(String apellido, Float salario);

	
}
