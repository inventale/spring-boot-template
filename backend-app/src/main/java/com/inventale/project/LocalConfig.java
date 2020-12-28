package com.inventale.project;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SuppressWarnings("unused")
@Configuration
@EnableAutoConfiguration(
        // disable cloud auto-configurations for local profiles
        exclude = {ContextInstanceDataAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@Profile(ProfileNames.LOCAL)
public class LocalConfig {
}
