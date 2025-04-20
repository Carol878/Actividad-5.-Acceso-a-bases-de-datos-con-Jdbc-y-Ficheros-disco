package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Cliente;

public class ClienteDaoImplMy8Jdbc extends AbsGenericoDaoImpl implements ClienteDao {
	
	public ClienteDaoImplMy8Jdbc() {
		super();
	}

	@Override
	public String altaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarUno(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		sql = "select * from clientes";
		List<Cliente> aux = new ArrayList<Cliente>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setCif(rs.getString("clientes_cif"));
				cliente.setNombre(rs.getString("clientes_nombre"));
				cliente.setApellidos(rs.getString("clientes_apellidos"));
				cliente.setDomicilio(rs.getString("clientes_domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("clientes_facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("clientes_numero_empleados"));
				
				aux.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}

	@Override
	public String eliminarCliente(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

}
