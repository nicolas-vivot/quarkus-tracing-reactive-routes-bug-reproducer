package org.kij.quarkus.opentracing.bug.datadog;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import datadog.opentracing.DDTracer;
import io.opentracing.util.GlobalTracer;
import io.quarkus.runtime.Startup;

@Startup
@ApplicationScoped
public class DDTracerActivation
{

    @PostConstruct
    public void setUp() {

        DDTracer tracer = DDTracer.builder()
                .build();

        tracer.addScopeListener(new Slf4jMdcInjectingScopeListener());

        GlobalTracer.registerIfAbsent(tracer);
        datadog.trace.api.GlobalTracer.registerIfAbsent(tracer);
    }
}
