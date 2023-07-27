package com.springjwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.springjwt.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

}