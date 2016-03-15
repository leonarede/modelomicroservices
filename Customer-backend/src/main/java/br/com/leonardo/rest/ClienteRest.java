package br.com.leonardo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class ClienteRest {

	private static List<Cliente> clients = new ArrayList<Cliente>();

	static {

		Cliente customer1 = new Cliente();
		customer1.setId(1);
		customer1.setName("Cliente 1");
		customer1.setEmail("customer1@gmail.com");

		Cliente customer2 = new Cliente();
		customer2.setId(2);
		customer2.setName("Cliente 2");
		customer2.setEmail("customer2@gmail.com");

		Cliente customer3 = new Cliente();
		customer3.setId(3);
		customer3.setName("Cliente 3");
		customer3.setEmail("customer3@gmail.com");

		Cliente customer4 = new Cliente();
		customer4.setId(4);
		customer4.setName("Cliente 4");
		customer4.setEmail("customer4@gmail.com");

		Cliente customer5 = new Cliente();
		customer5.setId(5);
		customer5.setName("Cliente 5");
		customer5.setEmail("customer5@gmail.com");

		clients.add(customer1);
		clients.add(customer2);
		clients.add(customer3);
		clients.add(customer4);
		clients.add(customer5);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes() {
		return clients;
	}

	@GET
	@Path("cliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getCliente(@QueryParam("id") long id) {

		Cliente cli = null;

		for (Cliente c : clients) {

			if (c.getId() == id)
				cli = c;

		}

		return cli;
	}

}