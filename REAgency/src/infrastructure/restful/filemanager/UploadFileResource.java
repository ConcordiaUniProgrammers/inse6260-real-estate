package infrastructure.restful.filemanager;

import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.contract.infracontract.IUnitOfWork;
import core.domain.realestate.areaaggregate.Country;

@Path("/file")
public class UploadFileResource {

	private static final String FILE_PATH = "C:/uploaded/xx.jpg";

	@GET
	@Path("/get")
	@Produces("image/jpeg")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.jpg");
		return response.build();

	}

//	@POST
//	@Path("/upload")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(
//			@FormDataParam("file") InputStream uploadedInputStream,
//			@FormDataParam("file") FormDataContentDisposition fileDetail)
//			throws IOException {
//
//		String uploadedFileLocation = "d://uploaded/"
//				+ fileDetail.getFileName();
//		writeToFile(uploadedInputStream, uploadedFileLocation);
//		String output = "File uploaded to : " + uploadedFileLocation;
//		return Response.status(200).entity(output).build();
//	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

//	@POST
//		@Path("/countries")
//		@Consumes(MediaType.MULTIPART_FORM_DATA)
//		public String uploadCountriesFile(
//				@FormDataParam("file") InputStream uploadedInputStream,
//				@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
//			
//			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DIConfiguration.class);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(uploadedInputStream));
//		    String line;
//		    while ((line = reader.readLine()) != null) {
//		    	
//				IUnitOfWork uow = context.getBean(UnitOfWork.class);
//		    	Country country = new Country();
//				country.setIsArchived(false);
//				country.setName(line);
//				uow.getCountryRepository().save(country);
//				uow.commit();
//		    }
//			context.close();
//			return (new Boolean(true).toString());
//		}
}
