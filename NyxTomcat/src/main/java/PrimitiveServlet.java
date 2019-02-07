import javax.servlet.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {

    private final String head = "HTTP/1.1 200 File Not Found\r\n" +
            //"Content-Type: text/html\r\n" +
            "\r\n";

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println(head);
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");

    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() {
        return null;
    }
    public ServletConfig getServletConfig() {
        return null;
    }

}
