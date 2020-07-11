package dwws;

import com.codahale.metrics.annotation.Metered;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Metered
@WebService
public class HelloWorldSOAP {
  @WebMethod
  public String sayHello() {
    return "Hello world!";
  }
}
