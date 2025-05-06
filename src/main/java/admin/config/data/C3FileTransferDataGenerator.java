package admin.config.data;

import admin.model.AdminQueryList;
import admin.model.C3FileTransfer;
import admin.repository.AdminQueryListRepository;
import admin.repository.C3FileTransferRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("local")
public class C3FileTransferDataGenerator {

    private final C3FileTransferRepository repository;
    private final AdminQueryListRepository adminQueryListRepository;
    public C3FileTransferDataGenerator(C3FileTransferRepository repository, AdminQueryListRepository adminQueryListRepository) {
        this.repository = repository;
        this.adminQueryListRepository = adminQueryListRepository;
    }

    @PostConstruct
    public void generateData() {
        List<C3FileTransfer> transfers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            C3FileTransfer t = new C3FileTransfer();
            t.setFileTransId(i); // Must match reportId
            t.setSequenceNr(i);
            t.setTransferCd(100 + i);
            t.setProtocolNm("FTP");
            t.setTransPrgNm("TRANS_PRG_" + i);
            t.setModeNm("ACTIVE");
            t.setSecurityNm("TLSv1.2");
            t.setIpPortCd("127.0.0.1:808" + i);
            t.setListenerSrvNm("LISTENER_" + i);
            t.setDdNm("DD" + i);
            t.setOrgTypeCd(100- i);
            t.setMemberCd("membe cd " + i);
            t.setRecordLengthNr(80 + i);
            t.setBlockSizeNr(256 + i);
            t.setConvertFileCd(3);
            t.setXferFileNm("xfer_file_" + i + ".dat");
            t.setJobNm("JOB_" + i);
            t.setProgramNm("PRGM_" + i);
            t.setRemoteFileNm("remote_" + i + ".txt");
            t.setLocalFileNm("local_" + i + ".txt");
            t.setControlFileNm("control_" + i + ".ctl");
            t.setGatewayAccessCd("GATEWAY_" + i);
            t.setBinFileCRLFind((byte) (1000 % 2));
            t.setLocalFileName("file local name " + i);
            transfers.add(t);
        }

        repository.saveAll(transfers);
    }
}
