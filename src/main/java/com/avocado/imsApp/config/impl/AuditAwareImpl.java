package com.avocado.imsApp.config.impl;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("pragadeesh2050"); //TODO: Need to update the current User....
    }
}