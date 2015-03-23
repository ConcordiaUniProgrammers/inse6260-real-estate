package test.infrastructure.restful;

import java.io.File;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.junit.Test;

public class FileUploaderResourceTest {

//	private Client client;
//	private WebTarget target;
//	private IRETypeService service;
//	
//	@Before
//	public void setUp(){
//		try {
//			this.client = ClientBuilder.newClient();
//			this.target = client.target("http://localhost:8080/REAgency/webapi/");
//			this.service = new RETypeService();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
	@Test
	public void testUploadFile() {
		String TARGET_URL = "http://localhost:8080/REAgency/fileapi/file/upload";
		File file = new File("D:\\countries-2014.csv");
		
		if(file.exists()){
			 Client client = ClientBuilder.newBuilder()
			            .register(MultiPartFeature.class).build();
			    WebTarget webTarget = client.target(TARGET_URL);
			    MultiPart multiPart = new MultiPart();
			    multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

			    FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file",
			            file,
			            MediaType.APPLICATION_OCTET_STREAM_TYPE);
			    multiPart.bodyPart(fileDataBodyPart);

			    Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
			            .post(Entity.entity(multiPart, multiPart.getMediaType()));

			    System.out.println(response.getStatus() + " "
			            + response.getStatusInfo() + " " + response);
		}
	}

}
