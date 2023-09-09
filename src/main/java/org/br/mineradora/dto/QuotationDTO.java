package org.br.mineradora.dto;

import java.math.BigDecimal;
import java.util.Date;

public record QuotationDTO(Date date, BigDecimal currencyPrice) {
}
