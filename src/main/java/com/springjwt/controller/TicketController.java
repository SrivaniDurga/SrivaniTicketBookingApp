package com.springjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springjwt.model.Ticket;
import com.springjwt.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/buyticket")
	public String createTicket(@RequestBody Ticket ticket) {
		return ticketService.BuyTicket(ticket)
;
	}
	
	@PutMapping("/updateticket/{ticketId}")
	public Ticket updateTicket(@PathVariable("ticketId") Long ticketId, @RequestBody Ticket ticket ) {
		return ticketService.updateTicket(ticketId , ticket);
	}
	
	@GetMapping("/showticket/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Long ticketId) {
		return ticketService.ShowTicket(ticketId);
	}
	
	@DeleteMapping("/cancelticket/{ticketId}")
	public String cancelTicket(@PathVariable("ticketId") Long ticketId) {
		return ticketService.CancelTicket(ticketId);
	}
	
}
