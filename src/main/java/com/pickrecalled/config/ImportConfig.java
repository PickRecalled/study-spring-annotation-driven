package com.pickrecalled.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class })
public class ImportConfig {

}
