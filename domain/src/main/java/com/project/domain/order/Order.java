package com.project.domain.order;


import org.jmolecules.event.annotation.Externalized;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.modulith.events.ApplicationModuleListener;

@Externalized
public class Order {
    private int id;

    @ApplicationModuleListener
    public void onUser() {
    }


    public static class OrderCreatedEvent implements DomainEvent {

    }

    public static class Handler {
        @ApplicationModuleListener
        public void onOrderCreated(OrderCreatedEvent event) {

        }
    }
}