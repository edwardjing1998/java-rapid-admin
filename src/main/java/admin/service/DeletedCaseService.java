package admin.service;

import admin.dto.DeletedAccountTransactionDTO;
import admin.dto.DeletedCaseDTO;
import admin.model.DeletedAccountTransaction;
import admin.model.DeletedCase;
import admin.repository.DeletedCaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeletedCaseService {

    private final DeletedCaseRepository deletedCaseRepository;

    public DeletedCaseService(DeletedCaseRepository deletedCaseRepository) {
        this.deletedCaseRepository = deletedCaseRepository;
    }

    public List<DeletedCaseDTO> getAllDeletedCases() {
        List<DeletedCase> cases = deletedCaseRepository.findAll();
        return cases.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteDeletedCasesByAccount(String account) {
        deletedCaseRepository.deleteByAccount(account);
    }

    private DeletedCaseDTO mapToDTO(DeletedCase deletedCase) {
        DeletedCaseDTO dto = new DeletedCaseDTO();
        dto.setCaseNumber(deletedCase.getCaseNumber());
        dto.setPiId(deletedCase.getPiId());
        dto.setCustomerId(deletedCase.getCustomerId());
        dto.setPrimaryPiId(deletedCase.getPrimaryPiId());
        dto.setAccount(deletedCase.getAccount());
        dto.setLastName(deletedCase.getLastName());
        dto.setFirstName(deletedCase.getFirstName());
        dto.setHmPhone(deletedCase.getHomePhone());
        dto.setWkPhone(deletedCase.getWorkPhone());
        dto.setEntityCd(deletedCase.getEntityCode());
        dto.setRoleCd(deletedCase.getRoleCode());
        dto.setPiStatus(deletedCase.getPiStatus());
        dto.setStatus(deletedCase.getStatus());
        dto.setActive(deletedCase.getActive() != null && deletedCase.getActive());
        dto.setReason(deletedCase.getReason());
        dto.setSubreason(deletedCase.getSubreason());
        dto.setDisposition(deletedCase.getDisposition());
        dto.setInHour(deletedCase.getInHour());
        dto.setInDate(deletedCase.getInDate());
        dto.setNextDate(deletedCase.getNextDate());
        dto.setOutDate(deletedCase.getOutDate());
        dto.setAutoDate(deletedCase.getAutoDate());
        dto.setNumCards(deletedCase.getNumCards());
        dto.setFinalActionCardsNr(deletedCase.getFinalActionCardsNumber());
        dto.setDeliveryId(deletedCase.getDeliveryId());
        dto.setSysPrin(deletedCase.getSysPrin());
        dto.setCycle(deletedCase.getCycle());
        dto.setFrstUpdtVendId(deletedCase.getFirstUpdateVendorId());
        dto.setContactCd(deletedCase.getContactCode());
        dto.setContactPhNr(deletedCase.getContactPhoneNumber());
        dto.setReturnReasonCd(deletedCase.getReturnReasonCode());
        dto.setIssuanceCd(deletedCase.getIssuanceCode());
        dto.setIssuanceDt(deletedCase.getIssuanceDate());
        dto.setWorkStationNameTx(deletedCase.getWorkstationName());
        dto.setOperatorCd(deletedCase.getOperatorCode());
        dto.setBarcodeTypeCd(deletedCase.getBarcodeTypeCode());
        dto.setRecTypTx(deletedCase.getRecordTypeText());
        dto.setSrvcTypTx(deletedCase.getServiceTypeText());
        dto.setMailerId(deletedCase.getMailerId());
        dto.setAs400ClientId(deletedCase.getAs400ClientId());
        dto.setAs400SystemId(deletedCase.getAs400SystemId());
        dto.setBscSpplmntlId(deletedCase.getBasicSupplementalId());
        dto.setOrigMlDt(deletedCase.getOriginalMailDate());
        dto.setMsgId(deletedCase.getMessageId());
        dto.setMlMthd(deletedCase.getMailMethod());
        dto.setSourceFile(deletedCase.getSourceFile());
        dto.setCustomerId(deletedCase.getCustomerIdField());
        dto.setMsIssueDate(deletedCase.getMsIssueDate());
        dto.setCustomerId2(deletedCase.getCustomerId2());
        dto.setMarketCode(deletedCase.getMarketCode());
        dto.setAccountTokenid(deletedCase.getAccountTokenId());
        dto.setPiIdTokenId(deletedCase.getPiIdTokenId());
        dto.setPrimaryPiIdTokenId(deletedCase.getPrimaryPiIdTokenId());

        // Map related DeletedAccountTransactions
        List<DeletedAccountTransactionDTO> transactions = deletedCase.getAccountTransactions()
                .stream()
                .map(this::mapToTransactionDTO)
                .collect(Collectors.toList());
        dto.setAccountTransactions(transactions);

        return dto;
    }

    private DeletedAccountTransactionDTO mapToTransactionDTO(DeletedAccountTransaction tx) {
        DeletedAccountTransactionDTO dto = new DeletedAccountTransactionDTO();
        dto.setCaseNumber(tx.getId().getCaseNumber());
        dto.setTransNo(tx.getId().getTransNo());
        dto.setDateTime(tx.getId().getDateTime());
        dto.setPiId(tx.getPiId());
        dto.setAccount(tx.getAccount());
        dto.setActionId(tx.getActionId());
        dto.setUid(tx.getUid());
        dto.setDocumentNo(tx.getDocumentNo());
        dto.setSysPrin(tx.getSysPrin());
        dto.setNoCards(tx.getNoCards());
        dto.setActionReason(tx.getActionReason());
        dto.setOperatorTime(tx.getOperatorTime());
        dto.setWorkstationName(tx.getWorkstationName());
        dto.setPostageCategoryCd(tx.getPostageCategoryCd());
        return dto;
    }
}
