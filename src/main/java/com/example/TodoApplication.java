package com.example;

import org.eclipse.sisu.space.SpaceModule;
import org.eclipse.sisu.space.URLClassSpace;
import org.eclipse.sisu.wire.WireModule;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class TodoApplication extends Application<TodoConfiguration> {
    public static void main(String[] args) throws Exception {
        new TodoApplication().run(args);
    }

    @Override
    public String getName() {
        return "todo-application";
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig("com.example")
                .searchCommands()
                .modules(new TodoModule())
                .build());
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) {
        // Resources will be automatically registered by Guice and Sisu
    }

    private static class TodoModule extends DropwizardAwareModule<TodoConfiguration> {
        @Override
        protected void configure() {
            // Configure Sisu classpath scanning
            install(new WireModule(new SpaceModule(new URLClassSpace(getClass().getClassLoader()))));
        }
    }
} 