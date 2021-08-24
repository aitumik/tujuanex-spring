package com.aitumik.tujuanex.greetingservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GreetingsRepository extends JpaRepository<Greeting,Long> {
    List<Greeting> findByPublished(boolean published);
}