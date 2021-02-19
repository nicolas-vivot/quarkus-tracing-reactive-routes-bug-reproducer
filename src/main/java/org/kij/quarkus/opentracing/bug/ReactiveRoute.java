package org.kij.quarkus.opentracing.bug;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;


@Traced
@ApplicationScoped
public class ReactiveRoute
{

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveRoute.class.getName());

    @Route(path = "/route1", methods = HttpMethod.GET)
    void hello(RoutingContext rc) {

        LOGGER.info("Reactive route 1");
        rc.response()
                .end("hello");
    }


    @Route(path = "/route2", methods = HttpMethod.GET)
    void hello2(RoutingContext rc) {

        LOGGER.info("Reactive route 2");
        rc.response()
                .end("hello 2");
    }

}
