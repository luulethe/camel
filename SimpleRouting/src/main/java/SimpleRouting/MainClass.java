package SimpleRouting;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * User: lent
 * Date: 8/20/13
 */
public class MainClass
{

    public static void main(String[] args) throws Exception
    {
        String url = "http://uet.vnu.edu.vn/~chauttm/TDD/";
        String file = "file://D:/Temp";
        MainClass mainClass = new MainClass();
        mainClass.getDataFromWebsite(url, file);
    }

    public void getDataFromWebsite(final String url, final String file) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder()
        {
            @Override
            public void configure() throws Exception
            {
                from(url).to(file);
            }
        });
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
