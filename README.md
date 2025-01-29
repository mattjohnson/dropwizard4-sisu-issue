# Error when running application
Getting an error when trying to use dropwizard4 with dropwizard-guicy and sisu.
```
INFO  [2025-01-29 19:39:47,863] io.dropwizard.core.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2025-01-29 19:39:47,864] io.dropwizard.core.server.DefaultServerFactory: Registering admin handler with root path prefix: /
java.lang.ExceptionInInitializerError
        at org.eclipse.sisu.wire.DependencyAnalyzer.<init>(DependencyAnalyzer.java:93)
        at org.eclipse.sisu.wire.ElementAnalyzer.<init>(ElementAnalyzer.java:100)
        at org.eclipse.sisu.wire.WireModule.configure(WireModule.java:74)
        at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:426)
        at com.google.inject.AbstractModule.install(AbstractModule.java:106)
        at com.example.TodoApplication$TodoModule.configure(TodoApplication.java:41)
        at com.google.inject.AbstractModule.configure(AbstractModule.java:64)
        at com.google.inject.spi.Elements$RecordingBinder.install(Elements.java:426)
        at com.google.inject.spi.Elements.getElements(Elements.java:113)
        at ru.vyarus.dropwizard.guice.module.installer.internal.ModulesSupport.analyzeModules(ModulesSupport.java:113)
        at ru.vyarus.dropwizard.guice.module.installer.internal.ModulesSupport.prepareModules(ModulesSupport.java:81)
        at ru.vyarus.dropwizard.guice.module.GuiceyRunner.analyzeAndRepackageBindings(GuiceyRunner.java:89)
        at ru.vyarus.dropwizard.guice.GuiceBundle.run(GuiceBundle.java:141)
        at ru.vyarus.dropwizard.guice.GuiceBundle.run(GuiceBundle.java:101)
        at io.dropwizard.core.setup.Bootstrap.run(Bootstrap.java:199)
        at io.dropwizard.core.cli.EnvironmentCommand.run(EnvironmentCommand.java:65)
        at io.dropwizard.core.cli.ConfiguredCommand.run(ConfiguredCommand.java:98)
        at io.dropwizard.core.cli.Cli.run(Cli.java:78)
        at io.dropwizard.core.Application.run(Application.java:94)
        at com.example.TodoApplication.main(TodoApplication.java:15)
Caused by: java.lang.IllegalArgumentException: org.eclipse.sisu.Parameters is not a binding annotation. Please annotate it with @BindingAnnotation.
        at com.google.common.base.Preconditions.checkArgument(Preconditions.java:220)
        at com.google.inject.Key.ensureIsBindingAnnotation(Key.java:382)
        at com.google.inject.Key.strategyFor(Key.java:370)
        at com.google.inject.Key.get(Key.java:229)
        at org.eclipse.sisu.wire.ParameterKeys.<clinit>(ParameterKeys.java:28)
        ... 20 more
```
