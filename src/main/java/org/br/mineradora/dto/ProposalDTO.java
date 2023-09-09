package org.br.mineradora.dto;

import java.math.BigDecimal;

public record ProposalDTO(long proposalId, String customer, BigDecimal priceTonne) {
}
