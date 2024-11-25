package com.project.modules.satoken.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jmolecules.event.types.DomainEvent;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LoginSuccessEvent implements DomainEvent {
    String userId;
}