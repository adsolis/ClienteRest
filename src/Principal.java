import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;



public class Principal {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ClientRequest clienteRequest = new ClientRequest("http://localhost:8080/RestWebService/rest/mensaje/Lyz");
		clienteRequest.header("custom-header", "value");
		//Gson gson = new Gson();
		
		try {
			ClientResponse<String> respuesta = clienteRequest.get(String.class);
			if(respuesta.getStatus() == 200) {
				System.out.println(respuesta.getEntity());
				//Properties properties = gson.fromJson(respuesta.getEntity().toString(), Properties.class);
				//System.out.println("boala: " +  properties.getProperty("nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			PersonaBean persona = new PersonaBean();
			persona.setNombre("Alexxx");
			ResteasyClient cliente = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = cliente.target("http://localhost:8080/RestWebService/rest/jsonServicio/envio");
			Response response = target.request().post(Entity.entity(persona, "application/json"));
			System.out.print(response.getEntity());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
