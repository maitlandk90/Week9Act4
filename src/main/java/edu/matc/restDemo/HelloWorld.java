package edu.matc.restDemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String msg) {
        // Return a simple message
        String output = "Hello " + msg;
        return Response.status(200).entity(output).build();
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    @Path("/{param}.html")
    public Response getMessageHTML(@PathParam("param") String msg) {
        // Return a simple message
        String output = "<h2>Hello " + msg + "</h2>";
        return Response.status(200).entity(output).build();
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{param}.json")
    public msgBean getMessageJSON(@PathParam("param") String message) {
        // Return a simple message
        msgBean msg = new msgBean();
        msg.setMsg("Hello " + message);
        return msg;
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{param}.xml")
    public String getMessageXML(@PathParam("param") String message) {
        // Return a simple message
        String msg;
        msg = "<?xml version=\"1.0\"?>" + "<Hello>" + message + "</Hello>";
        return msg;
    }

}