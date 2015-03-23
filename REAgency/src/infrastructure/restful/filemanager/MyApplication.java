package infrastructure.restful.filemanager;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
	public MyApplication() {
		super(UploadFileResource.class, MultiPartFieldInjectedResource.class,
				MultiPartFeature.class);
	}
}