package com.pickrecalled.config;

import com.pickrecalled.bean.Color;
import com.pickrecalled.bean.MyImportBeanDefinitionRegistrar;
import com.pickrecalled.bean.MyImportSelector;
import com.pickrecalled.bean.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class })
public class ImportConfig {

}
