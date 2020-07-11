package dwws;

import com.roskart.dropwizard.jaxws.EndpointBuilder;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

  private JAXWSBundle jaxWsBundle = new JAXWSBundle();

  public static void main(final String[] args) throws Exception {
    new App().run(args);
  }

  @Override
  public String getName() {
    return "dwws";
  }

  @Override
  public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
    bootstrap.addBundle(jaxWsBundle);
  }

  @Override
  public void run(final AppConfiguration configuration, final Environment environment) {
    var resource =
        new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
    environment.jersey().register(resource);

    jaxWsBundle.publishEndpoint(new EndpointBuilder("/hello", new HelloWorldSOAP()));
  }
}
