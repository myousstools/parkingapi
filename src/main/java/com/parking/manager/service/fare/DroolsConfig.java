package com.parking.manager.service.fare;

import java.io.IOException;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * The type Drools config.
 */
@Configuration
public class DroolsConfig {
  private static final String RULES_PATH = "drools/";

  /**
   * Kie file system kie file system.
   *
   * @return the kie file system
   * @throws IOException the io exception
   */
  @Bean
  public KieFileSystem kieFileSystem() throws IOException {
    KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
    for (Resource file : getRuleFiles()) {
      kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
    }

    return kieFileSystem;
  }

  private Resource[] getRuleFiles() throws IOException {
    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.drl");
  }

  /**
   * Kie container kie container.
   *
   * @return the kie container
   * @throws IOException the io exception
   */
  @Bean
  public KieContainer kieContainer() throws IOException {
    final KieRepository kieRepository = getKieServices().getRepository();

    kieRepository.addKieModule(new KieModule() {
      public ReleaseId getReleaseId() {
        return kieRepository.getDefaultReleaseId();
      }
    });

    KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem());
    kieBuilder.buildAll();

    return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
  }

  private KieServices getKieServices() {
    return KieServices.Factory.get();
  }

  /**
   * Kie base kie base.
   *
   * @return the kie base
   * @throws IOException the io exception
   */
  @Bean
  @ConditionalOnMissingBean(KieBase.class)
  public KieBase kieBase() throws IOException {
    return kieContainer().getKieBase();
  }

  /**
   * Kie session kie session.
   *
   * @return the kie session
   * @throws IOException the io exception
   */
  @Bean
  @ConditionalOnMissingBean(KieSession.class)
  public KieSession kieSession() throws IOException {
    return kieContainer().newKieSession();
  }
}