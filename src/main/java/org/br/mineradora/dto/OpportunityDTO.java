package org.br.mineradora.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OpportunityDTO(long proposalId, String customer, BigDecimal priceTonne, BigDecimal lastDollarQuotation) {
}
