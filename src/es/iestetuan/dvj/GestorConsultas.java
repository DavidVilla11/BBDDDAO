package es.iestetuan.dvj;

import es.iestetuan.dvj.dao.IDepartamentos;
import es.iestetuan.dvj.dao.IEmpleados;
import es.iestetuan.dvj.dao.consultas.ConsultaEmpleados;
import es.iestetuan.dvj.dao.consultas.ConsultasDepartamentos;

public class GestorConsultas {

	public static void main(String[] args) {
		
		IDepartamentos ConsultarDepartamentos = new ConsultasDepartamentos();
		ConsultarDepartamentos.crearDepartamento(null);
		ConsultarDepartamentos.consultarDepartamento(0);
		ConsultarDepartamentos.borrarDepartamento(60);

		
		IEmpleados ConsultarEmpleados = new ConsultaEmpleados();
		ConsultarEmpleados.crearEmpleado(null);
		ConsultarEmpleados.consultarEmpleado(0);
		ConsultarEmpleados.consultarEmpleadosApellidoSalario("J%", (float) 1500);

	}

}
