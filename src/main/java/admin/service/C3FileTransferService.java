package admin.service;

import admin.dto.C3FileTransferDTO;
import admin.service.mapper.C3FileTransferMapper;
import admin.model.C3FileTransfer;
import admin.model.AdminQueryList;
import admin.repository.AdminQueryListRepository;
import admin.repository.C3FileTransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class C3FileTransferService {
    private static final Logger logger = LoggerFactory.getLogger(C3FileTransferService.class);

    private final C3FileTransferRepository c3FileTransferRepository;
    private final AdminQueryListRepository adminQueryListRepository;
    private final C3FileTransferMapper c3FileTransferMapper;

    public C3FileTransferService(C3FileTransferRepository c3FileTransferRepository,
                                 AdminQueryListRepository adminQueryListRepository,
                                 C3FileTransferMapper c3FileTransferMapper) {
        this.c3FileTransferRepository = c3FileTransferRepository;
        this.adminQueryListRepository = adminQueryListRepository;
        this.c3FileTransferMapper = c3FileTransferMapper;
    }

    @Transactional
    public boolean deleteC3fileTransferList(Integer reportId) {
        Optional<AdminQueryList> optionalAdminQuery = adminQueryListRepository.findById(reportId);

        if (optionalAdminQuery.isPresent()) {
            AdminQueryList adminQuery = optionalAdminQuery.get();

            C3FileTransfer relatedTransfer = adminQuery.getC3FileTransfer();
            if (relatedTransfer != null) {
                c3FileTransferRepository.delete(relatedTransfer);
            }

            adminQueryListRepository.delete(adminQuery);

            return true;
        }

        return false;
    }

    public Optional<C3FileTransferDTO> getC3fileTransferById(Integer fileTransId) {
        return c3FileTransferRepository.findById(fileTransId)
                .map(c3FileTransferMapper::toDto);
    }

    public List<C3FileTransferDTO> getAllTransfers() {
        return c3FileTransferRepository.findAll()
                .stream()
                .map(c3FileTransferMapper::toDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public C3FileTransfer createC3fileTransfer(C3FileTransfer c3FileTransfer) {
        logger.info("C3FileTransfer::fileTransId {} in createC3fileTransfer", c3FileTransfer.getFileTransId());
        return c3FileTransferRepository.save(c3FileTransfer);
    }

    public Optional<C3FileTransfer> updateC3fileTransferList(C3FileTransferDTO c3FileTransferDTO) {
        var existingTransferOpt = c3FileTransferRepository.findById(c3FileTransferDTO.getFileTransId());

        if (existingTransferOpt.isPresent() && c3FileTransferDTO != null) {
            C3FileTransfer existing = existingTransferOpt.get();
            C3FileTransfer updated = c3FileTransferMapper.toEntity(c3FileTransferDTO);
            updated.setAdminQueryList(existing.getAdminQueryList());
            return Optional.of(c3FileTransferRepository.save(updated));
        }

        return Optional.empty();
    }
}
