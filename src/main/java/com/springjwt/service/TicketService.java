package com.springjwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjwt.model.Ticket;
import com.springjwt.repository.TicketRepository;


@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	//BuyTicket
	public String BuyTicket(Ticket buyTicket) {
		Ticket t= ticketRepository.save(buyTicket);
		return "Thankyou for choosing us! Your ticket is Confirmed with ticketid: "+t.getTicketId()+"\n Happy Journey";
	}
	
	//show Ticket 
	
	public Ticket ShowTicket(Long ticketId) {
		return ticketRepository.findById(ticketId).orElse(new Ticket());
	}
	
	//update Ticket
	
	public Ticket updateTicket(Long ticketId , Ticket ticket) {
		Ticket updateTicket = ShowTicket(ticketId);
		updateTicket.setFirstName(ticket.getFirstName());
		updateTicket.setLastName(ticket.getLastName());
		updateTicket.setDestinationStation(ticket.getDestinationStation());
		updateTicket.setSourceStation(ticket.getSourceStation());
		updateTicket.setEmail(ticket.getEmail());
		updateTicket.setMobileNumber(ticket.getMobileNumber());
		return ticketRepository.save(updateTicket);
	}
	
	//Cancel Ticket
	public String CancelTicket(Long ticketId) {
		ticketRepository.deleteById(ticketId);
		return "Your Ticket is cancelled Successfully";
	}
}
