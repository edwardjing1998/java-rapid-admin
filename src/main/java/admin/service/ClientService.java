package admin.service;

import admin.dto.ClientDTO;
import admin.dto.ClientReportOptionDTO;
import admin.dto.SysPrinsPrefixDTO;
import admin.model.Client;
import admin.model.ClientReportOption;
import admin.model.SysPrinsPrefix;
import admin.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClientsWithDetails() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO dto = new ClientDTO();
            dto.setClient(client.getClient());
            dto.setName(client.getName());
            dto.setAddr(client.getAddr());
            dto.setCity(client.getCity());
            dto.setState(client.getState());
            dto.setZip(client.getZip());
            dto.setContact(client.getContact());
            dto.setPhone(client.getPhone());
            dto.setActive(client.getActive());

            // Manually convert report options without client reference
            List<ClientReportOptionDTO> reportOptionDTOs = client.getReportOptions().stream()
                    .map(ro -> new ClientReportOptionDTO(
                            ro.getId(),
                            ro.getReportId(),
                            ro.getReceiveFlag(),
                            ro.getOutputTypeCd(),
                            ro.getFileTypeCd(),
                            ro.getEmailFlag(),
                            ro.getReportPasswordTx()
                    )).collect(Collectors.toList());
            dto.setReportOptions(reportOptionDTOs);

            // Manually convert sys prins prefixes without client reference
            List<SysPrinsPrefixDTO> sysPrinsDTOs = client.getSysPrinsPrefixes().stream()
                    .map(sp -> new SysPrinsPrefixDTO(
                            sp.getPrefixId(),
                            sp.getPrefix(),
                            sp.getDescription()
                    )).collect(Collectors.toList());
            dto.setSysPrinsPrefixes(sysPrinsDTOs);

            return dto;
        }).collect(Collectors.toList());
    }
}
