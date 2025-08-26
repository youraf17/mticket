package com.accedo.mticket.repository;

import com.accedo.mticket.domain.TicketStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketStateHistoryRepository extends JpaRepository<TicketStateHistory, UUID> {
}
