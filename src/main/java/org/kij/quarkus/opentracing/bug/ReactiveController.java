package org.kij.quarkus.opentracing.bug;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.smallrye.mutiny.Multi;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReactiveController
{

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReactiveController.class.getName());

    @GET
    @Path("/route3")
    public Multi<String> lessonRatings(String lessonId) {

        LOGGER.info("JAX-RS Reactive");

        return Multi.createFrom()
                .empty();
    }

}
