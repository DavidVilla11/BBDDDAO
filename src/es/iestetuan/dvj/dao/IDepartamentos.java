package es.iestetuan.dvj.dao;

import es.iestetuan.dvj.dao.vo.Departamentos;

public interface IDepartamentos {
	
	public void crearDepartamento(Departamentos departamento);
	public void modificarDepartamento(Departamentos departamento);
	public void borrarDepartamento(int idDepartamento);
	public void consultarDepartamento(int idDepartamento);
}
