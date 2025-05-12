package admin.repository;

import admin.dto.AccountTransactionReportDTO;
import admin.model.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountTransactionReportRepository extends Repository<AccountTransaction, Long> {

    @Query(value = """
        SELECT 
            AT.case_number as caseNumber,
            AT.action_reason as actionReason,
            AT.date_time as dateTime,
            AT.pi_id as piId,
            AT.account as account,
            C.last_name as lastName,
            C.first_name as firstName,
            A.addr1_tx as addr1Tx,
            A.addr2_tx as addr2Tx,
            A.city_tx as cityTx,
            A.state_tx as stateTx,
            A.zip_cd as zipCd,
            C.sys_prin as sysPrin,
            CL.client as client,
            CL.name as name
        FROM 
            ACCOUNT_TRANS AT
        JOIN 
            CASES C ON C.case_number = AT.case_number
        JOIN 
            ADDRESSES A ON A.case_number_id = C.case_number AND A.address_entity_cd = '1'
        JOIN 
            SYS_PRINS SP ON AT.sys_prin = SP.sys_prin
        JOIN 
            CLIENTS CL ON CL.client = SP.client
        WHERE 
            AT.action_id = 'ROA'
            AND AT.date_time >= :fromDate
            AND AT.date_time < :toDate
            AND SP.client = :client
        """, nativeQuery = true)
    List<AccountTransactionReportDTO> findReport(
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate,
            @Param("client") String client
    );

    @Query(value = """
        SELECT 
            AT.case_number as caseNumber,
            AT.action_reason as actionReason,
            AT.date_time as dateTime,
            AT.pi_id as piId,
            AT.account as account,
            C.last_name as lastName,
            C.first_name as firstName,
            A.addr1_tx as addr1Tx,
            A.addr2_tx as addr2Tx,
            A.city_tx as cityTx,
            A.state_tx as stateTx,
            A.zip_cd as zipCd,
            C.sys_prin as sysPrin,
            CL.client as client,
            CL.name as name
        FROM 
            ACCOUNT_TRANS AT
        JOIN 
            CASES C ON C.case_number = AT.case_number
        JOIN 
            ADDRESSES A ON A.case_number_id = C.case_number AND A.address_entity_cd = '1'
        JOIN 
            SYS_PRINS SP ON AT.sys_prin = SP.sys_prin
        JOIN 
            CLIENTS CL ON CL.client = SP.client
        WHERE 
            AT.action_id = 'ROA'
            AND AT.date_time >= :fromDate
            AND AT.date_time < :toDate
        """, nativeQuery = true)
    List<AccountTransactionReportDTO> findReportForAllClients(
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate
    );
}
