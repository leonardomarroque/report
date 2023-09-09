package org.br.mineradora.message;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.QuotationDTO;
import org.br.mineradora.service.OpportunityService;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    @Blocking
    public void receiveProposal(ProposalDTO proposal) {

        LOG.info("-- Receiving new proposal from Kafka topic --");
        opportunityService.buildOpportunity(proposal);

    }

    @Incoming("quotation")
    @Blocking
    public void receiveQuotation(QuotationDTO quotation) {

        LOG.info("-- Receiving new currency quotation from Kafka topic  --");
        opportunityService.saveQuotation(quotation);

    }

}