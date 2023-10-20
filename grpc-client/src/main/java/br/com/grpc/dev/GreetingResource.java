package br.com.grpc.dev;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/hello")
public class GreetingResource {

    @GrpcClient("hello")
    HelloGrpc helloService;

    @GrpcClient("hello")
    HelloGrpcGrpc.HelloGrpcBlockingStub helloGrpcBlockingStub;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/mutiny/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> helloMutiny(@PathParam("name") String name) {
        var retorno = helloService.sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform((reply) -> generateResponse(reply));
        return retorno;
    }

    @GET
    @Path("/blocking/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloBlocking(@PathParam("name") String name) {
        HelloReply reply = helloGrpcBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return generateResponse(reply);
    }


    public String generateResponse(HelloReply reply) {
        var result = String.format("%s! HelloWorld-Service.", reply.getMessage());
        System.out.println(result);
        return result;
    }

}
