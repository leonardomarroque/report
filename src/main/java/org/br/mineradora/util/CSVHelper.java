package org.br.mineradora.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.br.mineradora.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream opportunitiesToCSV(List<OpportunityDTO> opportunities) {

        final CSVFormat format = CSVFormat.DEFAULT.withHeader("Proposal ID", "Customer", "Price per Ton", "Best currency quote");

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)

        ) {

            for(OpportunityDTO opps : opportunities) {

                List<String> data = Arrays.asList(
                        String.valueOf(opps.proposalId()),
                        opps.customer(),
                        String.valueOf(opps.priceTonne()),
                        String.valueOf(opps.lastDollarQuotation()));

                csvPrinter.printRecord(data);

            }

            csvPrinter.flush();

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {

            throw new RuntimeException("Fail to import data to CSV file: " + e.getMessage());

        }

    }

}
